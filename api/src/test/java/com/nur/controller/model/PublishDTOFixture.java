package com.nur.controller.model;

import com.nur.dtos.PublishDTO;
import com.nur.model.Publication;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PublishDTOFixture {

	public static List<PublishDTO> withDefaultResponse() throws ParseException {
		return Arrays.asList(PublishDTO.builder().id("effa368e-2f33-49c7-94e4-a4dfb3be2c27")
				.amount(new BigDecimal("100.0")).publishID("effa368e-2f33-49c7-94e4-a4dfb3be2c11")
				.reserveID("effa368e-2f33-49c7-94e4-a4dfb3be2c27").userID("effa368e-2f33-49c7-94e4-a4dfb3be2c20")
				.build());
	}

	public static List<Publication> withDefault() throws ParseException {
		return Arrays.asList(new Publication(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c00"),
				new BigDecimal("100.0"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c11"),
				UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"),
				UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c20")));
	}

}
