package com.nur.command.payment.get;

import com.nur.command.checkout.get.GetCheckOutCommand;
import com.nur.command.checkout.get.GetCheckOutHandler;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CheckOutDTO;
import com.nur.dtos.PaymentDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.payment.IPaymentFactory;
import com.nur.model.*;
import com.nur.respositories.IPaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class GetPaymentHandlerTest {

    @Mock
    IPaymentRepository repository;
    @Spy
    IPaymentFactory factory;

    @Mock
    GetPaymentHandler service;
    @BeforeEach
    void setUp() {
        service = new GetPaymentHandler(repository);
    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        when(repository.getById(any(UUID.class))).thenReturn(PaymentFixture.whitDefault());
        PaymentDTO expect = PaymentDTOFixture.withDefaultResponse();
        GetPaymentCommand command = new GetPaymentCommand(PaymentDTOFixture.withDefaultResponse().getPaymentId());
        PaymentDTO respuesta = service.handle(command);

        assertEquals(expect.getPaymentId(), respuesta.getPaymentId());
    }
    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        GetPaymentCommand command = new GetPaymentCommand(null);
        assertThrows(InvalidDataException.class, () -> service.handle(command)) ;
    }
}