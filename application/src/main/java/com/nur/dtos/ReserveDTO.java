package com.nur.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReserveDTO {

    private String reserveID;

    private Date dateIn;

    private String state;

    private Date dateOut;

    private String publishID;

    private BigDecimal amount;

    private String userID;

}
