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
    private int dni;
    private Date dateIn;
    private StateReserve state;
    private Date dateOut;
    public Reserve(int dni, Date dateIn, StateReserve state, Date dateOut) {
        super(UUID.randomUUID());
        this.dni = dni;
        this.dateIn = dateIn;
        this.state = state;
        this.dateOut = dateOut;
    }
}
