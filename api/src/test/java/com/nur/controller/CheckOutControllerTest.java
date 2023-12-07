package com.nur.controller;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.checkin.create.CreateCheckInCommand;
import com.nur.command.checkin.get.GetCheckInCommand;
import com.nur.command.checkout.create.CreateCheckOutCommand;
import com.nur.command.checkout.get.GetCheckOutCommand;
import com.nur.controller.model.CheckInDTOFixture;
import com.nur.controller.model.CheckOutDTOFixture;
import com.nur.dtos.CheckInDTO;
import com.nur.dtos.CheckOutDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CheckOutControllerTest {

	@Mock
	Pipeline pipeline;

	@Mock
	CheckOutController controller;

	@BeforeEach
	void setUp() {
		controller = new CheckOutController(pipeline);
	}

	@Test
	void create() throws ParseException {
		CheckOutDTO model = CheckOutDTOFixture.withDefault();
		CheckOutDTO expect = CheckOutDTOFixture.withDefaultResponse();
		Mockito.when(pipeline.send(any(CreateCheckOutCommand.class))).thenReturn(expect);
		CheckOutDTO response = controller.create(model);
		Assertions.assertEquals(response, expect);
	}

	@Test
	void get() throws ParseException {
		CheckOutDTO expect = CheckOutDTOFixture.withDefaultResponse();
		Mockito.when(pipeline.send(any(GetCheckOutCommand.class))).thenReturn(expect);
		CheckOutDTO response = controller.get("effa368e-2f33-49c7-94e4-a4dfb3be2c27");
		Assertions.assertEquals(response, expect);
	}

}