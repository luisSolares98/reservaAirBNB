package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.Payment;
import com.nur.model.PaymentJapModel;
import com.nur.valueobjects.NullRule;

import java.util.Collections;
import java.util.List;

public class PaymentUtils {
    public static List<PaymentJapModel> paymentJpaModelList(
            List<Payment> checkOuts
    ) {
        if (checkOuts == null) return Collections.emptyList();
        return checkOuts
                .stream()
                .map((Payment checkOut) -> paymentToJpaEntity(checkOut))
                .toList();
    }
    public static PaymentJapModel paymentToJpaEntity(
            Payment payment
    ) {
        PaymentJapModel model = new PaymentJapModel();
        model.setId(payment.getKey());
        model.setPayment(payment.getPayment());
        model.setStatePayment(payment.getStatePayment());
        model.setReserveID(payment.getReserveID());
        return model;
    }
    public static Payment jpaToPayment(PaymentJapModel jpaModel)
            throws BussinessRuleValidationException {
        if (jpaModel == null) {
            throw new InvalidDataException("Data Not Found");
        }
        return new Payment(jpaModel.getId(),jpaModel.getStatePayment(), jpaModel.getPayment(), jpaModel.getReserveID());
    }
}
