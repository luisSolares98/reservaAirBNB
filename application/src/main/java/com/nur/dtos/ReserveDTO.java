package com.nur.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReserveDTO {
    public ReserveDTO(String reserveID, Date dateIn, String state, Date dateOut) {
        this.reserveID = reserveID;
        this.dateIn = dateIn;
        this.state = state;
        this.dateOut = dateOut;
    }

    private String reserveID;
    private Date dateIn;
    private String state;
    private Date dateOut;
}
