package com.nur.repositories.payment;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.*;
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
    public Payment getById(UUID id) {
        try {
            return PaymentUtils.jpaToPayment(
                    paymentCrudRepository.findById(id).orElse(null)
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Payment findByReserve(UUID reserve) throws BussinessRuleValidationException {
        return null;
    }
}
