package com.nur.modal;

import com.nur.core.AggregateRoot;
import lombok.Getter;
import java.util.Date;
import java.util.UUID;

@Getter
public class CheckIn extends AggregateRoot<UUID> {
    public Date dateTimeCheckIn;
    public String typeCheckIn;

    public CheckIn(Date dateTimeCheckIn, String typeCheckIn) {
        super(UUID.randomUUID());
        this.dateTimeCheckIn = dateTimeCheckIn;
        this.typeCheckIn = typeCheckIn;
    }
}
