package com.nur.util;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.ReserveDTO;
import com.nur.model.Reserve;
import com.nur.model.ReserveDTOFixture;
import com.nur.model.ReserveFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ReserveInMapperTest {
    @Mock
    ReserveInMapper mapper;
    @BeforeEach
    void setUp() {
        mapper = new ReserveInMapper();
    }

    @Test
    void from() throws ParseException, BussinessRuleValidationException {
        Reserve expect = ReserveFixture.whitDefault();
        Reserve response = ReserveInMapper.from(ReserveDTOFixture.withDefault());
        assertEquals(expect.toString(), response.toString());
    }

    @Test
    void testFromNull() {
        ReserveDTO expect = ReserveDTO.builder().build();
        ReserveDTO response = ReserveInMapper.from((Reserve) null);
        assertEquals(expect.toString(), response.toString());
    }
    @Test
    void testFrom() throws BussinessRuleValidationException, ParseException {
        Reserve example = ReserveFixture.whitDefault();
        ReserveDTO expect = ReserveDTOFixture.withDefaultResponseNull();
        expect.setDateIn(expect.getDateIn());
        expect.setState(expect.getState());
        expect.setDateOut(expect.getDateOut());
        expect.setReserveID(expect.getReserveID());
        ReserveDTO response = ReserveInMapper.from(example);
        assertEquals(expect.toString(), response.toString());
    }
}