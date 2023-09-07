package com.nur.util;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CheckInDTO;
import com.nur.dtos.CheckOutDTO;
import com.nur.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CheckOutMapperTest {

    @Mock
    CheckOutMapper mapper;
    @BeforeEach
    void setUp() {
        mapper = new CheckOutMapper();
    }

    @Test
    void from() throws ParseException, BussinessRuleValidationException {
        CheckOut expect = CheckOutFixture.whitDefault();
        CheckOut response = CheckOutMapper.from(CheckOutDTOFixture.withDefault());
        assertEquals(expect.toString(), response.toString());
    }

    @Test
    void testFromNull() {
        CheckOutDTO expect = CheckOutDTO.builder().build();
        CheckOutDTO response = CheckOutMapper.from((CheckOut) null);
        assertEquals(expect.toString(), response.toString());
    }
    @Test
    void testFrom() throws BussinessRuleValidationException, ParseException {
        CheckOut example = CheckOutFixture.whitDefault();
        CheckOutDTO expect = CheckOutDTOFixture.withDefaultResponse();
        CheckOutDTO response = CheckOutMapper.from(example);
        assertEquals(expect.toString(), response.toString());
    }
}