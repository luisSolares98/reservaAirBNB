package com.nur.command.publish.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PublishDTO;
import com.nur.dtos.ReserveDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.publication.IPublicationFactory;
import com.nur.factories.publication.PublicationFactory;
import com.nur.factories.reserve.IReserveFactory;
import com.nur.factories.reserve.ReserveFactory;
import com.nur.model.Publication;
import com.nur.model.Reserve;
import com.nur.respositories.IPublicationRepository;
import com.nur.respositories.IReserveRepository;
import com.nur.util.ReserveInMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Component
public class GetPublishHandler implements Command.Handler<GetPublishCommand, List<Publication>> {
    private final IPublicationRepository publicationRepository;
    private final IPublicationFactory publicationFactory;

    public GetPublishHandler(IPublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
        this.publicationFactory = new PublicationFactory();
    }

    @SneakyThrows
    @Override
    public List<Publication> handle(GetPublishCommand command) {
        try{
            List<Publication> list = publicationRepository.getByUserID(
                    UUID.fromString(command.getUserID())
            );
            return list;
        } catch (Exception ex) {
            throw new InvalidDataException(ex.getMessage());
        }
    }

}
