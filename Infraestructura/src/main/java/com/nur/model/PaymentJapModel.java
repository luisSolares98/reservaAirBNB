package com.nur.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Payment")
@Getter
@Setter
public class PaymentJapModel {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private BigDecimal payment;

    @Column(nullable = false)
    private String statePayment;
}
