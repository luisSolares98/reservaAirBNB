package com.nur.model;

import com.nur.core.AggregateRoot;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CheckOut extends AggregateRoot {

	private final Date dateTimeCheckOut;

	private final String typeCheckOut;

	private UUID reserveID;

	public CheckOut(UUID key, Date dateTimeCheckOut, String typeCheckOut, UUID reserveID) {
		this.key = key;
		this.dateTimeCheckOut = dateTimeCheckOut;
		this.typeCheckOut = typeCheckOut;
		this.reserveID = reserveID;
	}

	public CheckOut(Date dateTimeCheckOut, String typeCheckOut, UUID reserveID) {
		this.dateTimeCheckOut = dateTimeCheckOut;
		this.typeCheckOut = typeCheckOut;
		this.reserveID = reserveID;
	}

}
