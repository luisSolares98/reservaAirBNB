package com.nur.modal;

import com.nur.core.AggregateRoot;
import lombok.Getter;
import java.util.Date;
import java.util.UUID;

@Getter
public class CheckIn extends AggregateRoot<UUID> {
    private Date dateTimeCheckIn;
    private String typeCheckIn;
    private UUID reserveID;
    public CheckIn(Date dateTimeCheckIn, String typeCheckIn, UUID reserveID) {
        super(UUID.randomUUID());
        this.dateTimeCheckIn = dateTimeCheckIn;
        this.typeCheckIn = typeCheckIn;
        this.reserveID = reserveID;
    }
}
