package com.nur.model;

import com.nur.core.BussinessRuleValidationException;
import com.nur.util.UtilTest;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CheckOutFixture {

	public static CheckOut whitDefault() throws BussinessRuleValidationException, ParseException {
		return new CheckOut(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"),
				"Digital", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"));
	}

	public static List<CheckOut> whitDefaultList() throws BussinessRuleValidationException, ParseException {
		return Arrays.asList(new CheckOut(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"),
				UtilTest.parseToDate("2022-05-21"), "Digital", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27")),
				new CheckOut(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"),
						UtilTest.parseToDate("2022-05-21"), "Digital",
						UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27")));
	}

}
