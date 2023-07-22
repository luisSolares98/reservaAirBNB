package com.nur.valueobjects;

import com.nur.core.IBussinessRule;
import java.util.Objects;

public class NullRule implements IBussinessRule {
    Object obj;

    public NullRule(Object obj) {
        this.obj = obj;
    }

    @Override
    public boolean isValid() {
        return Objects.isNull(obj);
    }

    @Override
    public String message() {
        return "Object is null";
    }
}
