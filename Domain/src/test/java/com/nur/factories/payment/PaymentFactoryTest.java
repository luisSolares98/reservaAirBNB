package com.nur.factories.payment;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.checkout.CheckOutFactory;
import com.nur.factories.checkout.ICheckOutFactory;
import com.nur.model.CheckOut;
import com.nur.model.CheckOutFixture;
import com.nur.model.Payment;
import com.nur.model.PaymentFixture;
import com.nur.rule.NotNegativeRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PaymentFactoryTest {

    @Mock
    PaymentFactory factory;

    @Spy
    IPaymentFactory inFactory;
    @BeforeEach
    void setUp() {
        this.factory  = new PaymentFactory();
    }

    @Test
    void create() throws BussinessRuleValidationException, ParseException {
        Payment expect =  PaymentFixture.whitDefault();
        Payment response = factory.create(expect.getStatePayment(), expect.getPayment(), expect.getReserveID());
        assertEquals(expect.toString(), response.toString());
    }
    @Test
    void createFail() throws BussinessRuleValidationException, ParseException {
        Payment expect =  PaymentFixture.whitDefault();
        BussinessRuleValidationException exception = assertThrows(BussinessRuleValidationException.class, () -> factory.create(expect.getStatePayment(), 0, expect.getReserveID())) ;
        assertEquals("payment negative number or 0", exception.getDetails());
    }
}