package com.nur.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private float payment;
    @Column(nullable = false)
    private String statePayment;
    @Column(nullable = false)
    private UUID reserveID;

}
