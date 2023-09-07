package com.nur.command.reserve.create;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.ReserveDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.reserve.IReserveFactory;
import com.nur.model.ReserveDTOFixture;
import com.nur.respositories.IReserveRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateReserveHandlerTest {

    @Mock
    IReserveRepository repository;
    @Spy
    IReserveFactory factory;

    @Mock
    CreateReserveHandler service;
    @BeforeEach
    void setUp() {
        service = new CreateReserveHandler(repository);

    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        ReserveDTO expect = ReserveDTOFixture.withDefaultResponse();
        CreateReserveCommand command = new CreateReserveCommand(ReserveDTOFixture.withDefaultResponse());
        ReserveDTO respuesta = service.handle(command);
        assertEquals(expect.getDateIn(), respuesta.getDateIn());
        assertEquals(expect.getDateOut(), respuesta.getDateOut());
        assertEquals(expect.getState(), respuesta.getState());
    }
    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        CreateReserveCommand command = new CreateReserveCommand(null);

        InvalidDataException exception = assertThrows(InvalidDataException.class, () -> service.handle(command)) ;
        assertEquals("Datos Null", exception.getMessage());
    }
}