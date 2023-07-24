package com.nur.modal;

import com.nur.core.AggregateRoot;
import com.nur.valueObject.NotNegative;
import lombok.Getter;
import java.beans.Statement;
import java.util.UUID;
/*valuoObject mayor a 0 pagos*/
@Getter
public class Payment extends AggregateRoot<UUID> {
    private Statement statePayment;
    private NotNegative payment;

    public Payment(Statement statePayment, float payment) {
        super(UUID.randomUUID());
        this.statePayment = statePayment;
        this.payment = new NotNegative(payment);
    }
}
