package com.nur.modal;

import com.nur.core.AggregateRoot;
import lombok.Getter;
import java.util.Date;
import java.util.UUID;

@Getter
public class CheckOut extends AggregateRoot<UUID> {
    public Date dateTimeCheckIn;
    public String typeCheckIn;

    private UUID reserveID;
    public CheckOut(Date dateTimeCheckIn, String typeCheckIn, UUID reserveID) {
        super(UUID.randomUUID());
        this.dateTimeCheckIn = dateTimeCheckIn;
        this.typeCheckIn = typeCheckIn;
        this.reserveID = reserveID;
    }
}

