package com.nur.model;

import com.nur.core.AggregateRoot;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Getter
@ToString
public class CheckOut extends AggregateRoot {
    public Date dateTimeCheckOut;
    public String typeCheckOut;
    private UUID reserveID;

    public CheckOut(UUID key, Date dateTimeCheckOut, String typeCheckOut, UUID reserveID) {
        this.key = key;
        this.dateTimeCheckOut = dateTimeCheckOut;
        this.typeCheckOut = typeCheckOut;
        this.reserveID = reserveID;
    }

    public CheckOut(Date dateTimeCheckOut, String typeCheckOut, UUID reserveID) {
        this.dateTimeCheckOut = dateTimeCheckOut;
        this.typeCheckOut = typeCheckOut;
        this.reserveID = reserveID;
    }
}

