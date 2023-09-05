package com.nur.model;

import com.nur.core.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Builder
public class Reserve extends Entity {
    private Date dateIn;
    private String state;
    private Date dateOut;

}
