package com.nur.core;

import java.util.Objects;

public abstract class ValueObject {
    protected void CheckRule(BussinessRule rule) throws BussinessRuleValidationException {
        if (Objects.isNull(rule)) {
            throw new IllegalArgumentException("Rule cannot be null");
        }
        if (!rule.isValid()) {
            throw new BussinessRuleValidationException(rule);
        }
    }
}
