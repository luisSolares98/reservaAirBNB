package com.nur.modal;

import com.nur.core.AggregateRoot;
import com.nur.modal.enun.StatePayment;
import com.nur.valueObject.NotNegative;
import lombok.Getter;

import java.util.UUID;
/*valuoObject mayor a 0 pagos*/
@Getter
public class Payment extends AggregateRoot<UUID> {
    private StatePayment statePayment;
    private NotNegative payment;

    public Payment(StatePayment statePayment, float payment) {
        super(UUID.randomUUID());
        this.statePayment = statePayment;
        this.payment = new NotNegative(payment);
    }
}
