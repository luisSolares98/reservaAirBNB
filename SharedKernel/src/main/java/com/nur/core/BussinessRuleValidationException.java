package com.nur.core;

import lombok.Getter;

@Getter
public class BussinessRuleValidationException extends Exception {
    public BussinessRule brokenRule;
    public String details;

    public BussinessRuleValidationException(String message, String details) {
        super(message);
        this.details = details;
    }

    public BussinessRuleValidationException(BussinessRule brokenRule) {
        this.brokenRule = brokenRule;
        this.details = brokenRule.message();
    }
    @Override
    public String toString() {
        String name = this.brokenRule == null ? "BussinessRule" : this.brokenRule.getClass().getName();
        return name + ':' + this.details;
    }
}
