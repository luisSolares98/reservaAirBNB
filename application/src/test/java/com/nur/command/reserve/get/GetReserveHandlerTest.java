package com.nur.command.reserve.get;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.ReserveDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.reserve.IReserveFactory;
import com.nur.model.ReserveDTOFixture;
import com.nur.model.ReserveFixture;
import com.nur.respositories.IReserveRepository;
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
class GetReserveHandlerTest {
    @Mock
    IReserveRepository repository;
    @Spy
    IReserveFactory factory;

    @Mock
    GetReserveHandler service;
    @BeforeEach
    void setUp() {
        service = new GetReserveHandler(repository);
    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        when(repository.getById(any(UUID.class))).thenReturn(ReserveFixture.whitDefault());
        ReserveDTO expect = ReserveDTOFixture.withDefaultResponse();
        GetReserveCommand command = new GetReserveCommand(ReserveDTOFixture.withDefaultResponse().getReserveID());
        ReserveDTO respuesta = service.handle(command);

        assertEquals(expect.getReserveID(), respuesta.getReserveID());
    }
    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        GetReserveCommand command = new GetReserveCommand(null);
        InvalidDataException exception = assertThrows(InvalidDataException.class, () -> service.handle(command)) ;
        assertEquals("Datos Null", exception.getMessage());
    }
}