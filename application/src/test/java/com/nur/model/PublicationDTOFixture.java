package com.nur.model;

import com.nur.dtos.PublishDTO;
import com.nur.dtos.ReserveDTO;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.UUID;

public class PublicationDTOFixture {
    public static PublishDTO withDefaultResponse() throws ParseException {
        return PublishDTO.builder().ID("effa368e-2f33-49c7-94e4-a4dfb3be2c27").amount(new BigDecimal("100.0")).publishID("effa368e-2f33-49c7-94e4-a4dfb3be2c11").reserveID("effa368e-2f33-49c7-94e4-a4dfb3be2c27").userID("effa368e-2f33-49c7-94e4-a4dfb3be2c20").build();
    }


}
