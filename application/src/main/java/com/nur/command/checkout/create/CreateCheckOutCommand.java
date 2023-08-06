package com.nur.command.checkout.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CheckOutDTO;

public class CreateCheckOutCommand implements Command<CheckOutDTO> {
    CheckOutDTO checkOutDTO;
    public CreateCheckOutCommand(CheckOutDTO checkOutDTO) {
        this.checkOutDTO = checkOutDTO;
    }
}
