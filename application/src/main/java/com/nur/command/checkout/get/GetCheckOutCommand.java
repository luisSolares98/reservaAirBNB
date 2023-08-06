package com.nur.command.checkout.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CheckOutDTO;
import lombok.Getter;

@Getter
public class GetCheckOutCommand implements Command<CheckOutDTO> {
    String check;

    public GetCheckOutCommand(String check) {
        this.check = check;
    }
}
