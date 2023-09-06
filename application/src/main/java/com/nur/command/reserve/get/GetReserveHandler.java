package com.nur.command.reserve.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.ReserveDTO;
import com.nur.factories.reserve.IReserveFactory;
import com.nur.factories.reserve.ReserveFactory;
import com.nur.model.Reserve;
import com.nur.respositories.IReserveRepository;
import com.nur.util.ReserveInMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class GetReserveHandler implements Command.Handler<GetReserveCommand, ReserveDTO> {
    private final IReserveRepository reserveRepository;
    private final IReserveFactory reserveFactory;

    public GetReserveHandler(IReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
        this.reserveFactory = new ReserveFactory();
    }

    @SneakyThrows
    @Override
    public ReserveDTO handle(GetReserveCommand createReserveCommand) {
        Reserve reserve = reserveRepository.getById(
                UUID.fromString(createReserveCommand.getReserveID())
        );
        if (reserve == null) {
            return null;
        }
        return ReserveInMapper.from(reserve);
    }

}
