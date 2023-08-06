package com.nur.command.checkin.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CheckInDTO;
public class CreateCheckInCommand implements Command<CheckInDTO> {
    CheckInDTO checkInDTO;
    public CreateCheckInCommand(CheckInDTO reserveDTO) {
        this.checkInDTO = reserveDTO;
    }
}
