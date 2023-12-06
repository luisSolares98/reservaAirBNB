package com.nur.model;

import com.nur.core.AggregateRoot;
import com.nur.core.BussinessRuleValidationException;
import com.nur.valueObject.NotNegative;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;
@Getter
@ToString
public class Payment extends AggregateRoot {
    private String statePayment;
    private NotNegative payments;
    private UUID reserveID;
    public Payment(UUID key, String statePayment, float payment, UUID reserveID) throws BussinessRuleValidationException {
        this.key = key;
        this.statePayment = statePayment;
        this.payments = new NotNegative(payment);
        this.reserveID = reserveID;
    }

    public Payment(String statePayment, float payment, UUID reserveID) throws BussinessRuleValidationException {
        this.statePayment = statePayment;
        this.payments = new NotNegative(payment);
        this.reserveID = reserveID;
    }
    public float getPayment() {
        return payments.getPayment();
    }
}
