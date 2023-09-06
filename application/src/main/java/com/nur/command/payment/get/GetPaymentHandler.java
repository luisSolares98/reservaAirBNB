package com.nur.command.payment.get;

import an.awesome.pipelinr.Command;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CheckOutDTO;
import com.nur.dtos.PaymentDTO;
import com.nur.factories.checkout.CheckOutFactory;
import com.nur.factories.checkout.ICheckOutFactory;
import com.nur.model.CheckOut;
import com.nur.model.Payment;
import com.nur.respositories.ICheckOutRepository;
import com.nur.respositories.IPaymentRepository;
import com.nur.util.CheckOutMapper;
import com.nur.util.PaymentInMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetPaymentHandler implements Command.Handler<GetPaymentCommand, PaymentDTO> {
    private final IPaymentRepository repository;

    public GetPaymentHandler(IPaymentRepository repository) {
        this.repository = repository;
    }

    @SneakyThrows
    @Override
    public PaymentDTO handle(GetPaymentCommand command) {
        Payment check = repository.getById(UUID.fromString(command.getPaymen()));
        if (check == null) {
            return null;
        }
        return PaymentInMapper.from(check);
    }

}
