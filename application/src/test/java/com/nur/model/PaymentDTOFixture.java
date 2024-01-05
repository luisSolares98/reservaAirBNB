package com.nur.model;

import com.nur.dtos.PaymentDTO;

import java.text.ParseException;

public class PaymentDTOFixture {

	public static PaymentDTO withDefault() throws ParseException {
		return PaymentDTO.builder().payment(10).statePayment("Inicio").reserveID("effa368e-2f33-49c7-94e4-a4dfb3be2c27")
				.build();
	}

	public static PaymentDTO withDefaultResponse() throws ParseException {
		return PaymentDTO.builder().paymentId("cbeeff88-e224-44c5-b397-e5cce833df68").payment(10).statePayment("Inicio")
				.reserveID("effa368e-2f33-49c7-94e4-a4dfb3be2c27").build();
	}

}
