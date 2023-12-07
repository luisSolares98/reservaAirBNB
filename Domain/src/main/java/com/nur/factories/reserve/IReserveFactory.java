package com.nur.factories.reserve;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Reserve;

import java.util.Date;

public interface IReserveFactory {

	Reserve createReserve(Date dateIn, String state, Date dateOut) throws BussinessRuleValidationException;

}
