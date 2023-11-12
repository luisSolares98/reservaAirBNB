package com.nur.model;

import lombok.*;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;
@Entity
@Table(name = "CheckOut")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CheckOutJapModel {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private Date dateTimeCheckOut;

    @Column(nullable = false)
    private UUID reserveID;

    @Column(nullable = false)
    private String typeCheckOut;

}
