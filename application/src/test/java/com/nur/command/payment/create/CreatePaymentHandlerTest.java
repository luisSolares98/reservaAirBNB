package com.nur.command.payment.create;

import com.nur.command.checkout.create.CreateCheckOutCommand;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CheckOutDTO;
import com.nur.dtos.PaymentDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.payment.IPaymentFactory;
import com.nur.model.CheckOutDTOFixture;
import com.nur.model.PaymentDTOFixture;
import com.nur.respositories.IPaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreatePaymentHandlerTest {

    @Mock
    IPaymentRepository repository;
    @Spy
    IPaymentFactory factory;

    @Mock
    CreatePaymentHandler service;
    @BeforeEach
    void setUp() {
        service = new CreatePaymentHandler(repository);

    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        PaymentDTO expect = PaymentDTOFixture.withDefaultResponse();
        CreatePaymentCommand command = new CreatePaymentCommand(PaymentDTOFixture.withDefaultResponse());
        PaymentDTO respuesta = service.handle(command);
        assertEquals(expect.getReserveID(), respuesta.getReserveID());
    }
    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        PaymentDTO expect = PaymentDTOFixture.withDefaultResponse();
        expect.setReserveID(null);
        CreatePaymentCommand command = new CreatePaymentCommand(expect);
        assertThrows(InvalidDataException.class, () -> service.handle(command)) ;
    }
    @Test
    void handleErrorMoneda() throws ParseException, BussinessRuleValidationException {
        PaymentDTO expect = PaymentDTOFixture.withDefaultResponse();
        expect.setPayment(0l);
        CreatePaymentCommand command = new CreatePaymentCommand(expect);
        assertThrows(InvalidDataException.class, () -> service.handle(command)) ;
    }
}