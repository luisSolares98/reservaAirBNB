package com.nur.model;

import com.nur.core.AggregateRoot;
import com.nur.core.BussinessRuleValidationException;
import com.nur.valueObject.NotNegative;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;
@Getter
public class Payment extends AggregateRoot {
    private String statePayment;
    private NotNegative payment;
    private UUID reserveID;

    public Payment(String statePayment, float payment, UUID reserveID) throws BussinessRuleValidationException {
        this.statePayment = statePayment;
        this.payment = new NotNegative(payment);
        this.reserveID = reserveID;
    }
    public float getPayment() {
        return payment.getPayment();
    }
}
