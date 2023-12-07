package com.nur.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

	private int status;

	private String message;

	private Date timestamp;

	private String metodo;

	public ErrorResponse(String message) {
		this.message = message;
	}

}
