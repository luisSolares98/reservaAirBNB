package com.nur.factories.checkout;

import com.nur.core.BussinessRuleValidationException;
import com.nur.factories.checkin.CheckInFactory;
import com.nur.factories.checkin.ICheckInFactory;
import com.nur.model.CheckIn;
import com.nur.model.CheckInFixture;
import com.nur.model.CheckOut;
import com.nur.model.CheckOutFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CheckOutFactoryTest {

    @Mock
    CheckOutFactory factory;

    @Spy
    ICheckOutFactory inFactory;
    @BeforeEach
    void setUp() {
        this.factory  = new CheckOutFactory();
    }

    @Test
    void create() throws BussinessRuleValidationException, ParseException {
        CheckOut expect =  CheckOutFixture.whitDefault();
        CheckOut response = factory.create(expect.getDateTimeCheckOut(), expect.getTypeCheckOut(), expect.getReserveID());
        assertEquals(expect.toString(), response.toString());
    }
}