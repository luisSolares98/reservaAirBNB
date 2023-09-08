package com.nur.command.checkout.create;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CheckOutDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.checkout.ICheckOutFactory;
import com.nur.model.CheckOutDTOFixture;
import com.nur.respositories.ICheckOutRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreateCheckOutHandlerTest {

    @Mock
    ICheckOutRepository repository;
    @Spy
    ICheckOutFactory factory;

    @Mock
    CreateCheckOutHandler service;
    @BeforeEach
    void setUp() {
        service = new CreateCheckOutHandler(repository);

    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        CheckOutDTO expect = CheckOutDTOFixture.withDefaultResponse();
        CreateCheckOutCommand command = new CreateCheckOutCommand(CheckOutDTOFixture.withDefaultResponse());
        CheckOutDTO respuesta = service.handle(command);
        assertEquals(expect.getReserveId(), respuesta.getReserveId());
    }
    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        CheckOutDTO expect = CheckOutDTOFixture.withDefaultResponse();
        expect.setReserveId(null);
        CreateCheckOutCommand command = new CreateCheckOutCommand(expect);

        assertThrows(InvalidDataException.class, () -> service.handle(command)) ;
    }
}