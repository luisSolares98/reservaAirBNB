package com.nur.dtos;

import com.nur.valueObject.NotNegative;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@Setter
@ToString
public class PaymentDTO {
    public String paymentId;
    private String statePayment;
    private float payment;
    private String reserveID;
}
