package com.nur.model;

import com.nur.core.BussinessRuleValidationException;
import com.nur.util.UtilTest;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
public class ReserveFixture {
    public static Reserve whitDefault() throws BussinessRuleValidationException, ParseException {
        return new Reserve(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"), "Realizada", UtilTest.parseToDate("2022-05-29"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c28"));
    }
    public static Reserve whitDefaultFail() throws BussinessRuleValidationException, ParseException {
        return new Reserve(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"), "Realizada", UtilTest.parseToDate("2022-05-20"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c28"));
    }
    public static List<Reserve> whitDefaultList() throws BussinessRuleValidationException, ParseException {
        return Arrays.asList(new Reserve(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"), "Realizada", UtilTest.parseToDate("2022-05-29"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c28")), new Reserve(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"), "Realizada", UtilTest.parseToDate("2022-05-29"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c29")));
    }
}
