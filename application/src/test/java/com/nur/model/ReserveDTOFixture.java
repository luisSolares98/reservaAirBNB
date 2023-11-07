package com.nur.model;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.ReserveDTO;

import java.text.ParseException;
import java.util.UUID;

public class ReserveDTOFixture {
    public static ReserveDTO withDefault() throws ParseException {
        return ReserveDTO.builder().dateIn(UtilTest.parseToDate("2022-05-21")).state("Realizada").dateOut(UtilTest.parseToDate("2022-05-29")).publishID(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c28")).build();
    }
    public static ReserveDTO withDefaultResponse() throws ParseException {
        return ReserveDTO.builder().reserveID("effa368e-2f33-49c7-94e4-a4dfb3be2c27").dateIn(UtilTest.parseToDate("2022-05-21")).state("Realizada").dateOut(UtilTest.parseToDate("2022-05-29")).build();
    }
    public static ReserveDTO whitDefaultFail() throws BussinessRuleValidationException, ParseException {
        return ReserveDTO.builder().reserveID("effa368e-2f33-49c7-94e4-a4dfb3be2c27").dateIn(UtilTest.parseToDate("2022-05-21")).state("Realizada").dateOut(UtilTest.parseToDate("2022-04-29")).build();
    }
}
