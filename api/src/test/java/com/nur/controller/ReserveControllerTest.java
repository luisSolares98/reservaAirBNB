package com.nur.controller;
import an.awesome.pipelinr.Pipeline;
import com.nur.command.reserve.create.CreateReserveCommand;
import com.nur.command.reserve.get.GetReserveCommand;
import com.nur.controller.model.ReserveDTOFixture;
import com.nur.dtos.ReserveDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReserveControllerTest {
    @Mock
    Pipeline pipeline;
    @Mock
    ReserveController controller;
    @BeforeEach
    void setUp() {
        controller = new ReserveController(pipeline);
    }

    @Test
    void createReserve() throws ParseException {
        ReserveDTO model = ReserveDTOFixture.withDefault();
        ReserveDTO expect = ReserveDTOFixture.withDefaultResponse();
        Mockito.when(pipeline.send(any(CreateReserveCommand.class))).thenReturn(expect);
        ReserveDTO response = controller.createReserve(model);
        Assertions.assertEquals(response, expect);
    }

    @Test
    void getReserve() throws ParseException {
        ReserveDTO expect = ReserveDTOFixture.withDefaultResponse();
        Mockito.when(pipeline.send(any(GetReserveCommand.class))).thenReturn(expect);
        ReserveDTO response = controller.getReserve("effa368e-2f33-49c7-94e4-a4dfb3be2c27");
        Assertions.assertEquals(response, expect);
    }
}