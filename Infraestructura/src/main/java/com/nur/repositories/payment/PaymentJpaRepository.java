package com.nur.repositories.payment;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.*;
import com.nur.repositories.reserve.IReserveCrudRepository;
import com.nur.respositories.IPaymentRepository;
import com.nur.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PaymentJpaRepository implements IPaymentRepository {

    @Autowired
    private IPaymentCrudRepository paymentCrudRepository;

    @Override
    public UUID update(Payment payment) {
        PaymentJapModel model = PaymentUtils.paymentToJpaEntity(payment);
        model.setPayment(model.getPayment());
        paymentCrudRepository.save(model);
        return paymentCrudRepository.save(model).getId();
    }

    @Override
    public Payment getById(UUID id) throws BussinessRuleValidationException {
            return PaymentUtils.jpaToPayment(
                    paymentCrudRepository.findById(id).orElse(null)
            );
    }

}
