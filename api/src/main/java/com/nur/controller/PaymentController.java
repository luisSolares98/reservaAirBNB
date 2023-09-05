package com.nur.controller;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.payment.create.CreatePaymentCommand;
import com.nur.command.payment.get.GetPaymentCommand;
import com.nur.dtos.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    final Pipeline pipeline;
    @Autowired
    public PaymentController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("/")
    public PaymentDTO create(@RequestBody PaymentDTO dto) {
        CreatePaymentCommand assignSeatCommand = new CreatePaymentCommand(dto);
        return assignSeatCommand.execute(pipeline);
    }
    @GetMapping("/{idPayment}")
    public PaymentDTO get(@PathVariable String idPayment) {
        GetPaymentCommand assignSeatCommand = new GetPaymentCommand(idPayment);
        return assignSeatCommand.execute(pipeline);
    }
}
