package com.nur.command.reserve.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.ReserveDTO;
import lombok.Getter;

@Getter
public class GetReserveCommand implements Command<ReserveDTO> {
    String reserveID;

    public GetReserveCommand(String reserveID) {
        this.reserveID = reserveID;
    }
}
