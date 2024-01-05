package com.nur.model;

import com.nur.core.BussinessRuleValidationException;
import com.nur.core.Entity;
import com.nur.valueObject.DateDiferent;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Reserve extends Entity {

	private Date dateIn;

	private String state;

	private Date dateOut;

	public Reserve(UUID key, Date dateIn, String state, Date dateOut, UUID uuid) {
		this.key = key;
		this.dateIn = dateIn;
		this.state = state;
		this.dateOut = dateOut;
	}

	public Reserve(Date dateIn, String state, Date dateOut) throws BussinessRuleValidationException {
		new DateDiferent(dateIn, dateOut);
		this.dateIn = dateIn;
		this.state = state;
		this.dateOut = dateOut;
	}

}
