package com.nur.controller;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.checkin.create.CreateCheckInCommand;
import com.nur.command.checkin.get.GetCheckInCommand;
import com.nur.command.reserve.create.CreateReserveCommand;
import com.nur.command.reserve.get.GetReserveCommand;
import com.nur.controller.model.CheckInDTOFixture;
import com.nur.controller.model.ReserveDTOFixture;
import com.nur.dtos.CheckInDTO;
import com.nur.dtos.ReserveDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CheckInControllerTest {
    @Mock
    Pipeline pipeline;
    @Mock
    CheckInController controller;
    @BeforeEach
    void setUp() {
        controller = new CheckInController(pipeline);
    }

    @Test
    void create() throws ParseException {
        CheckInDTO model = CheckInDTOFixture.withDefault();
        CheckInDTO expect = CheckInDTOFixture.withDefaultResponse();
        Mockito.when(pipeline.send(any(CreateCheckInCommand.class))).thenReturn(expect);
        CheckInDTO response = controller.create(model);
        Assertions.assertEquals(response, expect);
    }

    @Test
    void get() throws ParseException {
        CheckInDTO expect = CheckInDTOFixture.withDefaultResponse();
        Mockito.when(pipeline.send(any(GetCheckInCommand.class))).thenReturn(expect);
        CheckInDTO response = controller.get("effa368e-2f33-49c7-94e4-a4dfb3be2c27");
        Assertions.assertEquals(response, expect);
    }
}