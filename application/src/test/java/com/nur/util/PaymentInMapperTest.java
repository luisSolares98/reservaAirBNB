package com.nur.util;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CheckOutDTO;
import com.nur.dtos.PaymentDTO;
import com.nur.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PaymentInMapperTest {

    @Mock
    PaymentInMapper mapper;
    @BeforeEach
    void setUp() {
        mapper = new PaymentInMapper();
    }

    @Test
    void from() throws ParseException, BussinessRuleValidationException {
        Payment expect = PaymentFixture.whitDefault();
        Payment response = PaymentInMapper.from(PaymentDTOFixture.withDefault());
        assertEquals(expect.toString(), response.toString());
    }

    @Test
    void testFromNull() {
        PaymentDTO expect = PaymentDTO.builder().build();
        PaymentDTO response = PaymentInMapper.from((Payment) null);
        assertEquals(expect.toString(), response.toString());
    }
    @Test
    void testFrom() throws BussinessRuleValidationException, ParseException {
        Payment example = PaymentFixture.whitDefault();
        PaymentDTO expect = PaymentDTOFixture.withDefaultResponse();
        expect.setReserveID(expect.getReserveID());
        expect.setPaymentId(expect.getPaymentId());
        expect.setStatePayment(expect.getStatePayment());
        expect.setPayment(expect.getPayment());
        PaymentDTO response = PaymentInMapper.from(example);
        assertEquals(expect.toString(), response.toString());
    }
}