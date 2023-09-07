package com.nur.model;

import com.nur.dtos.CheckOutDTO;

import java.text.ParseException;

public class CheckOutDTOFixture {
    public static CheckOutDTO withDefault() throws ParseException {
        return CheckOutDTO.builder().dateTimeCheckOut(UtilTest.parseToDate("2022-05-21")).typeCheckOut("Digital").reserveId("effa368e-2f33-49c7-94e4-a4dfb3be2c27").build();
    }
    public static CheckOutDTO withDefaultResponse() throws ParseException {
        return CheckOutDTO.builder().checkOutId("cbeeff88-e224-44c5-b397-e5cce833df68").dateTimeCheckOut(UtilTest.parseToDate("2022-05-21")).typeCheckOut("Digital").reserveId("effa368e-2f33-49c7-94e4-a4dfb3be2c27").build();
    }
}
