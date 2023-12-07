package com.nur.factories.reserve;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Reserve;

import java.util.Date;

public class ReserveFactory implements IReserveFactory {

	@Override
	public Reserve createReserve(Date dateIn, String state, Date dateOut) throws BussinessRuleValidationException {
		return new Reserve(dateIn, state, dateOut);
	}

}
