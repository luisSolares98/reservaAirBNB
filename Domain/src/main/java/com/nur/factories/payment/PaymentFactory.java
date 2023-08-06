package com.nur.factories.payment;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Payment;
import java.util.UUID;

public class PaymentFactory implements IPaymentFactory {

  @Override
  public Payment create(String statePayment, float payment, UUID reserveID) throws BussinessRuleValidationException {
    return new Payment(statePayment, payment, reserveID);
  }
}
