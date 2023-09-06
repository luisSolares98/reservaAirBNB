package com.nur.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.Date;

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
}
