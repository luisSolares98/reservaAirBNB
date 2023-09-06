package com.nur.rule;


import com.nur.core.BussinessRule;

public class NotNegativeRule implements BussinessRule {
    private final float payment;

    public NotNegativeRule(float payment) {
        this.payment = payment;
    }

    @Override
    public boolean isValid() {
        return payment > 0;
    }

    @Override
    public String message() {
        return "payment negative number or 0";
    }
}
