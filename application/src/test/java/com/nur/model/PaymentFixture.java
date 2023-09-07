package com.nur.model;

import com.nur.core.BussinessRuleValidationException;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PaymentFixture {
    public static Payment whitDefault() throws BussinessRuleValidationException, ParseException {
        return new Payment(UUID.fromString("cbeeff88-e224-44c5-b397-e5cce833df68"), "Inicio",10, UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"));
    }
    public static List<Payment> whitDefaultList() throws BussinessRuleValidationException, ParseException {
        return Arrays.asList(new Payment(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), "Inicio",10, UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27")), new Payment(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), "Inicio",10, UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27")));
    }

}
