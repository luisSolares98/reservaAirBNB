package com.nur.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Builder
@Setter
@ToString
public class CheckOutDTO {
    public String checkOutId;
    public String reserveId;
    private Date dateTimeCheckOut;
    private String typeCheckOut;
}
