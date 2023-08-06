package com.nur.model;

import com.nur.core.BussinessRuleValidationException;
import com.nur.core.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
public class Reserve extends Entity {
    private Date dateIn;
    private String state;
    private Date dateOut;
    public Reserve(Date dateIn, String state, Date dateOut) throws BussinessRuleValidationException {
        this.key = UUID.randomUUID();
        this.dateIn = dateIn;
        this.state = state;
        this.dateOut = dateOut;
    }
}
