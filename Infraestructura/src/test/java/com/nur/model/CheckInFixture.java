package com.nur.model;

import com.nur.core.BussinessRuleValidationException;
import com.nur.util.UtilTest;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CheckInFixture {
    public static CheckIn whitDefault() throws BussinessRuleValidationException, ParseException {
        return new CheckIn(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"), "Digital", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"));
    }
    public static List<CheckIn> whitDefaultList() throws BussinessRuleValidationException, ParseException {
        return Arrays.asList(new CheckIn(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"), "Digital", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27")), new CheckIn(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"), "Digital", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27")));
    }

    public static List<CheckInJapModel> whitDefaultListJPA() throws BussinessRuleValidationException, ParseException {
        return Arrays.asList(new CheckInJapModel(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"),   UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), "Digital"), new CheckInJapModel(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"),  UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), "Digital"));
    }
    public static CheckInJapModel whitDefaultJPA() throws BussinessRuleValidationException, ParseException {
        CheckIn checkIn = whitDefault();
        CheckInJapModel model = new CheckInJapModel();
        model.setId(checkIn.getKey());
        model.setDateTimeCheckIn(checkIn.getDateTimeCheckIn());
        model.setTypeCheckIn(checkIn.getTypeCheckIn());
        model.setReserveID(checkIn.getReserveID());
        return model;
    }
}
