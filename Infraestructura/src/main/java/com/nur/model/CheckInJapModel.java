package com.nur.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "CheckIn")
@Getter
@Setter
public class CheckInJapModel {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private Date dateTimeCheckIn;

    @Column(nullable = false)
    private UUID reserveID;

    @Column(nullable = false)
    private String typeCheckIn;
}
