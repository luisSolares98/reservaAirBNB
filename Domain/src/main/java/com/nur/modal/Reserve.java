package com.nur.modal;

import com.nur.core.Entity;
import com.nur.modal.enun.StateReserve;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
public class Reserve extends Entity<UUID>  {
    private Date dateIn;
    private String state;
    private Date dateOut;
    public Reserve(Date dateIn, String state, Date dateOut) {
        super(UUID.randomUUID());
        this.dateIn = dateIn;
        this.state = state;
        this.dateOut = dateOut;
    }
}
