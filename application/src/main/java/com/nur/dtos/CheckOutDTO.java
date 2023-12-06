package com.nur.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Builder
@Setter
@ToString
public class CheckOutDTO {
    private String checkOutId;
    private String reserveId;
    private Date dateTimeCheckOut;
    private String typeCheckOut;
}
