package com.nur.core;

import java.util.Objects;

public class ValueObject {
    protected void CheckRule(IBussinessRule rule) throws BussinessRuleValidationException {
        if (Objects.isNull(rule)) {
            throw new IllegalArgumentException("Rule cannot be null");
        }
        if (!rule.isValid()) {
            throw new BussinessRuleValidationException(rule);
        }
    }
}
