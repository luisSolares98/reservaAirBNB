package com.nur.dtos;

import com.nur.valueObject.NotNegative;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@Setter
public class PaymentDTO {
    public String paymentId;
    private String statePayment;
    private float payment;
    private String reserveID;
}
