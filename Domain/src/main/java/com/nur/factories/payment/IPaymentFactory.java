package com.nur.factories.payment;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Payment;
import java.util.UUID;

public interface IPaymentFactory {

	Payment create(String statePayment, float payment, UUID reserveID) throws BussinessRuleValidationException;

}
