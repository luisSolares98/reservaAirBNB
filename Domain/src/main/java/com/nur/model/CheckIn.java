package com.nur.model;

import com.nur.core.AggregateRoot;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
public class CheckIn extends AggregateRoot {
    private Date dateTimeCheckIn;
    private String typeCheckIn;
    private UUID reserveID;
    public CheckIn(UUID checkIn, Date dateTimeCheckIn, String typeCheckIn, UUID reserveID) {
        this.key = checkIn;
        this.dateTimeCheckIn = dateTimeCheckIn;
        this.typeCheckIn = typeCheckIn;
        this.reserveID = reserveID;
    }
    public CheckIn(Date dateTimeCheckIn, String typeCheckIn, UUID reserveID) {
        this.dateTimeCheckIn = dateTimeCheckIn;
        this.typeCheckIn = typeCheckIn;
        this.reserveID = reserveID;
    }
}
