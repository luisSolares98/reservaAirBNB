package com.nur.dtos;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@Setter
@ToString
public class CheckInDTO {

    private String checkInId;
    private String reserveId;
    private Date dateTimeCheckIn;
    private String typeCheckIn;
}
