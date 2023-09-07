package com.nur.dtos;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@Setter
@ToString
public class CheckInDTO {

    public String checkInId;
    public String reserveId;
    private Date dateTimeCheckIn;
    private String typeCheckIn;
}
