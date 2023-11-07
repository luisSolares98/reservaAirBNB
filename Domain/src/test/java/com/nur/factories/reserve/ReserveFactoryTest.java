package com.nur.factories.reserve;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Reserve;
import com.nur.model.ReserveFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ReserveFactoryTest {
    @Mock
    ReserveFactory reserveFactory;

    @Spy
    IReserveFactory iReserveFactory;
    @BeforeEach
    void setUp() {
        this.reserveFactory  = new ReserveFactory();
    }

    @Test
    void createReserve() throws BussinessRuleValidationException, ParseException {
        Reserve expect = ReserveFixture.whitDefault();
        expect.setState(expect.getState());
        expect.setDateIn(expect.getDateIn());
        expect.setDateOut(expect.getDateOut());
        Reserve reserve = reserveFactory.createReserve(expect.getDateIn(), expect.getState(), expect.getDateOut(), expect.getPublishID());
        assertEquals(expect.toString(), reserve.toString());
    }
    @Test
    void createFail() throws BussinessRuleValidationException, ParseException {
        Reserve expect = ReserveFixture.whitDefaultFail();
        BussinessRuleValidationException exception = assertThrows(BussinessRuleValidationException.class, () -> reserveFactory.createReserve(expect.getDateIn(), expect.getState(), expect.getDateOut(), expect.getPublishID())) ;
        assertEquals("la fecha de ingreso no puede ser mayor a la de la salida", exception.getDetails());
    }
}