package com.nur.model;

import com.nur.dtos.CheckInDTO;

import java.text.ParseException;

public class CheckInDTOFixture {

	public static CheckInDTO withDefault() throws ParseException {
		return CheckInDTO.builder().dateTimeCheckIn(UtilTest.parseToDate("2022-05-21")).typeCheckIn("Digital")
				.reserveId("effa368e-2f33-49c7-94e4-a4dfb3be2c27").build();
	}

	public static CheckInDTO withDefaultResponse() throws ParseException {
		return CheckInDTO.builder().checkInId("cbeeff88-e224-44c5-b397-e5cce833df68")
				.dateTimeCheckIn(UtilTest.parseToDate("2022-05-21")).typeCheckIn("Digital")
				.reserveId("effa368e-2f33-49c7-94e4-a4dfb3be2c27").build();
	}

}
