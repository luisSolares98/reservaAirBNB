package com.nur.valueObject;

import com.nur.core.BussinessRuleValidationException;
import com.nur.core.ValueObject;
import com.nur.rule.NotNegativeRule;
import lombok.Getter;

@Getter
public class NotNegative extends ValueObject {
    private final float payment;


    public NotNegative(float payment) throws BussinessRuleValidationException {
        CheckRule(new NotNegativeRule(payment));
        this.payment = payment;
    }

}
