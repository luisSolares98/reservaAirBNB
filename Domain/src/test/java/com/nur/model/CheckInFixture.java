package com.nur.model;

import com.nur.core.BussinessRuleValidationException;
import com.nur.util.UtilTest;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CheckInFixture {

	public static CheckIn whitDefault() throws BussinessRuleValidationException, ParseException {
		return new CheckIn(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"),
				"Digital", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"));
	}

	public static List<CheckIn> whitDefaultList() throws BussinessRuleValidationException, ParseException {
		return Arrays.asList(
				new CheckIn(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"),
						"Digital", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27")),
				new CheckIn(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"),
						"Digital", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27")));
	}

}
