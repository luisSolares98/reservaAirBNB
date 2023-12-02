package com.nur.model;

import com.nur.core.BussinessRuleValidationException;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.UUID;

public class PublicationFixture {
    public static Publication whitDefault() throws BussinessRuleValidationException, ParseException {
        return new Publication(new BigDecimal("100.0"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c11"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c20"));
    }

    public static Publication whitDefaultAll() throws BussinessRuleValidationException, ParseException {
        return new Publication(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c00"), new BigDecimal("100.0"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c11"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c20"));
    }
}
