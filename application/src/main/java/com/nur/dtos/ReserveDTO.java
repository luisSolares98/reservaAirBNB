package com.nur.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
