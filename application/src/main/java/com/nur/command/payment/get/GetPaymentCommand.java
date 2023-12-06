package com.nur.command.payment.get;

import com.nur.dtos.PaymentDTO;

import an.awesome.pipelinr.Command;
import lombok.Getter;

@Getter
public class GetPaymentCommand implements Command<PaymentDTO> {
    String paymen;

    public GetPaymentCommand(String paymen) {
        this.paymen = paymen;
    }
}
