package com.nur.model;

import com.nur.core.BussinessRuleValidationException;
import com.nur.util.UtilTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PublishFixture {
    public static Publication whitDefault() throws BussinessRuleValidationException, ParseException {
        return new Publication(new BigDecimal("100.0"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c11"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c20"));
    }
    public static List<Publication> whitDefaultList() throws BussinessRuleValidationException, ParseException {
        return Arrays.asList(whitDefaultAll());
    }
    public static Publication whitDefaultAll() throws BussinessRuleValidationException, ParseException {
        return new Publication(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c00"), new BigDecimal("100.0"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c11"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c20"));
    }
    public static List<UserPublicReserveJpaModel> whitDefaultListJPA() throws BussinessRuleValidationException, ParseException {
        return Arrays.asList(new UserPublicReserveJpaModel(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c00"),  UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c11"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c20"), new BigDecimal("100.0")));
    }
    public static UserPublicReserveJpaModel whitDefaultJPA() throws BussinessRuleValidationException, ParseException {
        Publication publication = whitDefaultAll();
        UserPublicReserveJpaModel model = new UserPublicReserveJpaModel();
        model.setId(publication.getKey());
        model.setPublishID(publication.getPublicationID());
        model.setUserID(publication.getUserID());
        model.setReserveID(publication.getReserveID());
        model.setAmount(publication.getAmount());
        return model;
    }
}
