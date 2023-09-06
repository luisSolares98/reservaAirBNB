package com.nur.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Payment")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
