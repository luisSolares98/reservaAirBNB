package com.nur.controller;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.checkout.create.CreateCheckOutCommand;
import com.nur.command.checkout.get.GetCheckOutCommand;
import com.nur.command.payment.create.CreatePaymentCommand;
import com.nur.command.payment.get.GetPaymentCommand;
import com.nur.controller.model.CheckOutDTOFixture;
import com.nur.controller.model.PaymentDTOFixture;
import com.nur.dtos.CheckOutDTO;
import com.nur.dtos.PaymentDTO;
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
class PaymentControllerTest {

    @Mock
    Pipeline pipeline;
    @Mock
    PaymentController controller;
    @BeforeEach
    void setUp() {
        controller = new PaymentController(pipeline);
    }

    @Test
    void create() throws ParseException {
        PaymentDTO model = PaymentDTOFixture.withDefault();
        PaymentDTO expect = PaymentDTOFixture.withDefaultResponse();
        Mockito.when(pipeline.send(any(CreatePaymentCommand.class))).thenReturn(expect);
        PaymentDTO response = controller.create(model);
        Assertions.assertEquals(response, expect);
    }

    @Test
    void get() throws ParseException {
        PaymentDTO expect = PaymentDTOFixture.withDefaultResponse();
        Mockito.when(pipeline.send(any(GetPaymentCommand.class))).thenReturn(expect);
        PaymentDTO response = controller.get("effa368e-2f33-49c7-94e4-a4dfb3be2c27");
        Assertions.assertEquals(response, expect);
    }
}