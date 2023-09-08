package com.nur.command.checkin.create;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CheckInDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.checkin.ICheckInFactory;
import com.nur.model.CheckInDTOFixture;
import com.nur.respositories.ICheckInRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreateCheckInHandlerTest {
    @Mock
    ICheckInRepository checkInRepository;
    @Spy
    ICheckInFactory checkInFactory;

    @Mock
    CreateCheckInHandler service;
    @BeforeEach
    void setUp() {
        service = new CreateCheckInHandler(checkInRepository);

    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        // when(checkInFactory.create(any(Date.class),any(String.class),any(UUID.class))).thenReturn(CheckInFixture.whitDefault());
        CheckInDTO expect = CheckInDTOFixture.withDefaultResponse();
        CreateCheckInCommand command = new CreateCheckInCommand(CheckInDTOFixture.withDefaultResponse());
        CheckInDTO respuesta = service.handle(command);
        assertEquals(expect.getReserveId(), respuesta.getReserveId());
    }
    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        // when(checkInFactory.create(any(Date.class),any(String.class),any(UUID.class))).thenReturn(CheckInFixture.whitDefault());
        CheckInDTO expect = CheckInDTOFixture.withDefaultResponse();
        expect.setReserveId(null);
        CreateCheckInCommand command = new CreateCheckInCommand(expect);

        assertThrows(InvalidDataException.class, () -> service.handle(command)) ;

    }
}