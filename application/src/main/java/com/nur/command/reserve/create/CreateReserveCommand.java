package com.nur.command.reserve.create;

import com.nur.dtos.ReserveDTO;

import an.awesome.pipelinr.Command;


public class CreateReserveCommand implements Command<ReserveDTO> {
    ReserveDTO reserveDTO;
    public CreateReserveCommand(ReserveDTO reserveDTO) {
        this.reserveDTO = reserveDTO;
    }
}
