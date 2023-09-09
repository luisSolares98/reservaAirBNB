package com.nur.command.reserve.create;

import an.awesome.pipelinr.Command;
import com.nur.core.BussinessRule;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.ReserveDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.reserve.IReserveFactory;
import com.nur.factories.reserve.ReserveFactory;
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
    public ReserveDTO handle(CreateReserveCommand createReserveCommand)  {
        Reserve reserve = null;
        try {
            reserve = reserveFactory.createReserve(createReserveCommand.reserveDTO.getDateIn(), createReserveCommand.reserveDTO.getState(), createReserveCommand.reserveDTO.getDateOut());
            reserveRepository.updateReserve(reserve);
            return ReserveInMapper.from(reserve);
        } catch (BussinessRuleValidationException ex) {
            throw new InvalidDataException(ex.getDetails());
        }
    }

}
