package com.nur.model;

import com.nur.core.BussinessRuleValidationException;
import com.nur.core.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@Builder
public class Reserve extends Entity {
    private Date dateIn;
    private String state;
    private Date dateOut;

    public Reserve(UUID key, Date dateIn, String state, Date dateOut) {
        this.key = key;
        this.dateIn = dateIn;
        this.state = state;
        this.dateOut = dateOut;
    }
}
