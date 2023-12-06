package com.nur.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PublishDTO {
    private String id;

    private String publishID;

    private BigDecimal amount;

    private String userID;

    private String reserveID;
}
