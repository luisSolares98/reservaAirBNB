package com.nur.command.payment.create;

import an.awesome.pipelinr.Command;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.PaymentDTO;
import com.nur.factories.payment.IPaymentFactory;
import com.nur.factories.payment.PaymentFactory;
import com.nur.model.Payment;
import com.nur.respositories.IPaymentRepository;
import com.nur.util.PaymentInMapper;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class CreatePaymentHandler implements Command.Handler<CreatePaymentCommand, PaymentDTO> {


    private final IPaymentRepository repository;
    private final IPaymentFactory factory;


    public CreatePaymentHandler(IPaymentRepository repository) {
        this.repository = repository;
        this.factory = new PaymentFactory();
    }


    @Override
    public PaymentDTO handle(CreatePaymentCommand command) {
        Payment payment = null;
        try {
            payment = factory.create(command.paymentDTO.getStatePayment(), command.paymentDTO.getPayment(), UUID.fromString(command.paymentDTO.getReserveID()));

            if (payment == null) {
                return null;
            }
            repository.update(payment);
            return PaymentInMapper.from(payment);
        } catch (BussinessRuleValidationException e) {
            throw new RuntimeException(e);
        }
    }

}
