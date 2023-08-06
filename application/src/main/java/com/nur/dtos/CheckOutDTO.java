package com.nur.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Builder
@Setter
public class CheckOutDTO {
    public String checkOutId;
    public String reserveId;
    private Date dateTimeCheckOut;
    private String typeCheckOut;
}
