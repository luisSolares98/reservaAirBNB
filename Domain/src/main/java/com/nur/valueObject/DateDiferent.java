package com.nur.valueObject;

import com.nur.core.BussinessRuleValidationException;
import com.nur.core.ValueObject;
import com.nur.rule.DateRule;

import java.util.Date;

public class DateDiferent extends ValueObject {

	public DateDiferent(Date dateIn, Date dateOut) throws BussinessRuleValidationException {
		CheckRule(new DateRule(dateIn, dateOut));

	}

}
