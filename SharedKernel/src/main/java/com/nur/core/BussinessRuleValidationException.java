package com.nur.core;

import lombok.Getter;

import java.io.Serializable;
@Getter
public class BussinessRuleValidationException extends Exception implements Serializable {
    public IBussinessRule brokenRule;
    public String details;

    public BussinessRuleValidationException(String message, String details) {
        super(message);
        this.details = details;
    }

    public BussinessRuleValidationException(IBussinessRule brokenRule) {
        this.brokenRule = brokenRule;
        this.details = brokenRule.message();
    }
    @Override
    public String toString() {
        String name = this.brokenRule == null ? "BussinessRule" : this.brokenRule.getClass().getName();
        return name + ':' + this.details;
    }
}
