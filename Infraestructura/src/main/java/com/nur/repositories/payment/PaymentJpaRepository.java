package com.nur.repositories.payment;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Payment;
import com.nur.model.PaymentJapModel;
import com.nur.model.Reserve;
import com.nur.repositories.reserve.IReserveCrudRepository;
import com.nur.respositories.IPaymentRepository;
import com.nur.utils.PaymentUtils;
import com.nur.utils.ReserveUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentJpaRepository implements IPaymentRepository {

    @Autowired
    private IPaymentCrudRepository paymentCrudRepository;
    @Autowired
    private IReserveCrudRepository reserveCrudRepository;
    @Override
    public UUID update(Payment payment) throws BussinessRuleValidationException {
        PaymentJapModel model = PaymentUtils.paymentToJpaEntity(payment);
        Reserve reserve = ReserveUtils.jpaToreserva(
                reserveCrudRepository.findById(model.getReserveID()).orElse(null)
        );

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
