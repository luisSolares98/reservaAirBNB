package com.nur.command.checkin.get;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CheckInDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.checkin.ICheckInFactory;
import com.nur.model.CheckInDTOFixture;
import com.nur.model.CheckInFixture;
import com.nur.respositories.ICheckInRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.ParseException;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetCheckInHandlerTest {

	@Mock
	ICheckInRepository checkInRepository;

	@Spy
	ICheckInFactory checkInFactory;

	@Mock
	GetCheckInHandler service;

	@BeforeEach
	void setUp() {
		service = new GetCheckInHandler(checkInRepository);
	}

	@Test
	void handle() throws ParseException, BussinessRuleValidationException {
		when(checkInRepository.getById(any(UUID.class))).thenReturn(CheckInFixture.whitDefault());
		CheckInDTO expect = CheckInDTOFixture.withDefaultResponse();
		GetCheckInCommand command = new GetCheckInCommand(CheckInDTOFixture.withDefaultResponse().getCheckInId());
		CheckInDTO respuesta = service.handle(command);

		assertEquals(expect.getCheckInId(), respuesta.getCheckInId());
	}

	@Test
	void handleError() throws ParseException, BussinessRuleValidationException {
		GetCheckInCommand command = new GetCheckInCommand(null);
		assertThrows(InvalidDataException.class, () -> service.handle(command));
	}

}