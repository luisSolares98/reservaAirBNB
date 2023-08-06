package com.nur.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@Setter
public class CheckInDTO {

    public String checkInId;
    public String reserveId;
    private Date dateTimeCheckIn;
    private String typeCheckIn;
}
