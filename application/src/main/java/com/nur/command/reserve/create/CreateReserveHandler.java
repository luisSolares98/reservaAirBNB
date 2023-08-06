package com.nur.command.reserve.create;

import an.awesome.pipelinr.Command;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.ReserveDTO;
import com.nur.factories.IReserveFactory;
import com.nur.factories.ReserveFactory;
import com.nur.model.Reserve;
import com.nur.respositories.IReserveRepository;
import com.nur.util.ReserveInMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateReserveHandler implements Command.Handler<CreateReserveCommand, ReserveDTO> {


    private final IReserveRepository reserveRepository;
    private final IReserveFactory reserveFactory;


    public CreateReserveHandler(IReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
        this.reserveFactory = new ReserveFactory();
    }


    @Override
    public ReserveDTO handle(CreateReserveCommand createReserveCommand) {
        Reserve reserve = null;
        try {
            reserve = reserveFactory.createReserve(createReserveCommand.reserveDTO.getDateIn(), createReserveCommand.reserveDTO.getState(), createReserveCommand.reserveDTO.getDateOut());
            if (reserve == null) {
                return null;
            }
            reserveRepository.updateReserve(reserve);
            return ReserveInMapper.from(reserve);
        } catch (BussinessRuleValidationException e) {
            throw new RuntimeException(e);
        }
    }

}
