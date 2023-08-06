package com.nur.dtos;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
public class ReserveDTO {
    private String reserveID;
    private Date dateIn;
    private String state;
    private Date dateOut;
    public ReserveDTO(String reserveID, Date dateIn, String state, Date dateOut) {
        this.reserveID = reserveID;
        this.dateIn = dateIn;
        this.state = state;
        this.dateOut = dateOut;
    }
}
