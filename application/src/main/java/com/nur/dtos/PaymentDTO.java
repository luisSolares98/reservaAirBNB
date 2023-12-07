package com.nur.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@Setter
@ToString
public class PaymentDTO {

	private String paymentId;

	private String statePayment;

	private float payment;

	private String reserveID;

}
