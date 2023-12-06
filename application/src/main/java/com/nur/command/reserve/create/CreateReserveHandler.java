package com.nur.command.reserve.create;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.ReserveDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.publication.IPublicationFactory;
import com.nur.factories.publication.PublicationFactory;
import com.nur.factories.reserve.IReserveFactory;
import com.nur.factories.reserve.ReserveFactory;
import com.nur.model.Publication;
import com.nur.model.Reserve;
import com.nur.rabbit.Config;
import com.nur.rabbit.CustomMessage;
import com.nur.rabbit.Pattern;
import com.nur.rabbit.Response;
import com.nur.respositories.IPublicationRepository;
import com.nur.respositories.IReserveRepository;
import com.nur.util.ReserveInMapper;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

import an.awesome.pipelinr.Command;

@Component
public class CreateReserveHandler implements Command.Handler<CreateReserveCommand, ReserveDTO> {


    private final IReserveRepository reserveRepository;

    private final IReserveFactory reserveFactory;

    private IPublicationRepository publicationRepository;

    private final IPublicationFactory publicationFactory;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    public CreateReserveHandler(IReserveRepository reserveRepository, IPublicationRepository publicationRepository) {
        this.reserveRepository = reserveRepository;
        this.publicationRepository = publicationRepository;
        this.reserveFactory = new ReserveFactory();
        this.publicationFactory = new PublicationFactory();
    }


    @Override
    public ReserveDTO handle(CreateReserveCommand createReserveCommand)  {
        Reserve reserve = null;
        try {
            reserve = reserveFactory.createReserve(createReserveCommand.reserveDTO.getDateIn(), createReserveCommand.reserveDTO.getState(), createReserveCommand.reserveDTO.getDateOut());
            UUID reserveID = reserveRepository.updateReserve(reserve);

            Publication publication = publicationFactory.createPublication(UUID.fromString(createReserveCommand.reserveDTO.getPublishID()),reserveID, createReserveCommand.reserveDTO.getAmount(), UUID.fromString(createReserveCommand.reserveDTO.getUserID()) );
            publicationRepository.update(publication);

            Pattern pattern = Pattern.builder().cmd(Config.EXCHANGE).build();

            CustomMessage message = CustomMessage.builder().id(UUID.fromString(createReserveCommand.reserveDTO.getUserID()))
                    .message("The Reserve was successfully created").build();

            Response response = Response.builder().data(message).pattern(pattern).build();

            // Reddis notify
            template.convertAndSend(Config.EXCHANGE, response);

            pattern.setCmd(Config.EXCHANGE2);
            CustomMessage message2 = CustomMessage.builder().id(publication.getPublicationID())
                    .message("The Reserve was successfully created").build();
            response.setData(message2);
            // Reddis notify
            template.convertAndSend(Config.EXCHANGE2, response);

            return ReserveInMapper.from(reserve);
        } catch (BussinessRuleValidationException ex) {
            throw new InvalidDataException(ex.getDetails());
        }
    }

}
