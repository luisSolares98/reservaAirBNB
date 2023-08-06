package com.nur.command.payment.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CheckOutDTO;
import com.nur.dtos.PaymentDTO;
import lombok.Getter;

@Getter
public class GetPaymentCommand implements Command<PaymentDTO> {
    String paymen;

    public GetPaymentCommand(String paymen) {
        this.paymen = paymen;
    }
}
