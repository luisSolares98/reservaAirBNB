package com.nur.command.payment.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PaymentDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.Payment;
import com.nur.respositories.IPaymentRepository;
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
        try{
            Payment check = repository.getById(UUID.fromString(command.getPaymen()));
            return PaymentInMapper.from(check);
        } catch (Exception e) {
            throw new InvalidDataException("Datos Null");
        }
    }

}
