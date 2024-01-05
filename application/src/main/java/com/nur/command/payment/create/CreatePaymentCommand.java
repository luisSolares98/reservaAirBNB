package com.nur.command.payment.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PaymentDTO;

public class CreatePaymentCommand implements Command<PaymentDTO> {

	PaymentDTO paymentDTO;

	public CreatePaymentCommand(PaymentDTO paymentDTO) {
		this.paymentDTO = paymentDTO;
	}

}
