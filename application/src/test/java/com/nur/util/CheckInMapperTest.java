package com.nur.util;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CheckInDTO;
import com.nur.dtos.ReserveDTO;
import com.nur.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CheckInMapperTest {

    @Mock
    CheckInMapper mapper;
    @BeforeEach
    void setUp() {
        mapper = new CheckInMapper();
    }

    @Test
    void from() throws ParseException, BussinessRuleValidationException {
        CheckIn expect = CheckInFixture.whitDefault();
        CheckIn response = CheckInMapper.from(CheckInDTOFixture.withDefault());
        assertEquals(expect.toString(), response.toString());
    }

    @Test
    void testFromNull() {
        CheckInDTO expect = CheckInDTO.builder().build();
        CheckInDTO response = CheckInMapper.from((CheckIn) null);
        assertEquals(expect.toString(), response.toString());
    }
    @Test
    void testFrom() throws BussinessRuleValidationException, ParseException {
        CheckIn example = CheckInFixture.whitDefault();
        CheckInDTO expect = CheckInDTOFixture.withDefaultResponse();
        CheckInDTO response = CheckInMapper.from(example);
        assertEquals(expect.toString(), response.toString());
    }
}