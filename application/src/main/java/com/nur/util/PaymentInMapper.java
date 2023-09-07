package com.nur.util;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.PaymentDTO;
import com.nur.model.Payment;

import java.util.UUID;

public class PaymentInMapper {
    public static PaymentDTO from(Payment payment) {
        if (payment == null) return PaymentDTO.builder().build();
        return PaymentDTO.builder()
                .reserveID(payment.getReserveID().toString())
                .paymentId(payment.getKey().toString())
                .payment(payment.getPayment())
                .statePayment(payment.getStatePayment())
                .build();
    }

    public static Payment from(PaymentDTO paymentDTO)
            throws BussinessRuleValidationException {
        return new Payment(paymentDTO.getStatePayment(), paymentDTO.getPayment(), UUID.fromString(paymentDTO.getReserveID()));
    }
}
