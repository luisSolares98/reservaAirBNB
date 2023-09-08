package com.nur.command.checkout.get;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CheckOutDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.checkout.ICheckOutFactory;
import com.nur.model.CheckInDTOFixture;
import com.nur.model.CheckOutDTOFixture;
import com.nur.model.CheckOutFixture;
import com.nur.respositories.ICheckOutRepository;
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
class GetCheckOutHandlerTest {

    @Mock
    ICheckOutRepository repository;
    @Spy
    ICheckOutFactory factory;

    @Mock
    GetCheckOutHandler service;
    @BeforeEach
    void setUp() {
        service = new GetCheckOutHandler(repository);
    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        when(repository.getById(any(UUID.class))).thenReturn(CheckOutFixture.whitDefault());
        CheckOutDTO expect = CheckOutDTOFixture.withDefaultResponse();
        GetCheckOutCommand command = new GetCheckOutCommand(CheckInDTOFixture.withDefaultResponse().getCheckInId());
        CheckOutDTO respuesta = service.handle(command);

        assertEquals(expect.getCheckOutId(), respuesta.getCheckOutId());
    }
    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        GetCheckOutCommand command = new GetCheckOutCommand(null);
        assertThrows(InvalidDataException.class, () -> service.handle(command)) ;
    }
}