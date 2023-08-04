package com.nur.valueObject;

import com.nur.core.IBussinessRule;
import lombok.Getter;

@Getter
public class NotNegative implements IBussinessRule {
    Float number;

    public NotNegative(Float number) {
        this.number = number;
    }

    @Override
    public boolean isValid() {
        return number > 0;
    }

    @Override
    public String message() {
        return "negative number";
    }
}
