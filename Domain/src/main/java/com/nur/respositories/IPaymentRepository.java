package com.nur.respositories;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Payment;
import java.util.UUID;

public interface IPaymentRepository {
    UUID update(Payment payment);

    Payment getById(UUID id) throws BussinessRuleValidationException;

}
