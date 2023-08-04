package com.nur.modal;

import com.nur.core.AggregateRoot;
import com.nur.modal.enun.StatePayment;
import com.nur.valueObject.NotNegative;
import lombok.Getter;

import java.util.UUID;
/*valuoObject mayor a 0 pagos*/
@Getter
public class Payment extends AggregateRoot<UUID> {
    private String statePayment;
    private NotNegative payment;
    private UUID reserveID;

    public Payment(String statePayment, float payment, UUID reserveID) {
        super(UUID.randomUUID());
        this.statePayment = statePayment;
        this.payment = new NotNegative(payment);
        this.reserveID = reserveID;
    }
    public float getPayment() {
        return payment.getNumber();
    }
}
