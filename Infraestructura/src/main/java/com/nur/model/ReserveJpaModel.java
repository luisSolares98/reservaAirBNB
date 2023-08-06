package com.nur.model;

import lombok.*;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Builder
@Table(name = "Reserve")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReserveJpaModel {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private Date dateIn;

    @Column(nullable = false)
    private Date dateOut;

    @Column(nullable = false)
    private String state;


}
