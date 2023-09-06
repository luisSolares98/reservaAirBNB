package com.nur.model;

import com.nur.core.BussinessRuleValidationException;
import com.nur.util.UtilTest;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PaymentFixture {
    public static Payment whitDefault() throws BussinessRuleValidationException, ParseException {
        return new Payment(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), "Inicio",10, UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"));
    }
    public static List<Payment> whitDefaultList() throws BussinessRuleValidationException, ParseException {
        return Arrays.asList(new Payment(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), "Inicio",10, UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27")), new Payment(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), "Inicio",10, UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27")));
    }

    public static List<PaymentJapModel> whitDefaultListJPA() throws BussinessRuleValidationException, ParseException {
        return Arrays.asList(new PaymentJapModel(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), 10,  "Inicio", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27")), new PaymentJapModel(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), 10,  "Inicio", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27")));
    }
    public static PaymentJapModel whitDefaultJPA() throws BussinessRuleValidationException, ParseException {
        Payment payment =  whitDefault();
        PaymentJapModel model = new PaymentJapModel();
        model.setId(payment.getKey());
        model.setStatePayment(payment.getStatePayment());
        model.setPayment(payment.getPayment());
        model.setReserveID(payment.getReserveID());
        return model;
    }
}
