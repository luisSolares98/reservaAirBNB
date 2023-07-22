package com.nur.modal;

import com.nur.core.AggregateRoot;
import lombok.Getter;
import java.beans.Statement;
import java.util.UUID;

@Getter
public class Payment extends AggregateRoot<UUID> {
    private Statement statePayment;
    private double payment;

    public Payment(Statement statePayment, double payment) {
        super(UUID.randomUUID());
        this.statePayment = statePayment;
        this.payment = payment;
    }
}
