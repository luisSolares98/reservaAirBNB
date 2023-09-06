package com.nur.rule;

import com.nur.core.BussinessRule;

import java.util.Date;

public class DateRule implements BussinessRule {
    private final Date dateIn;
    private final Date dateOut;

    public DateRule(Date dateIn, Date dateOut) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    @Override
    public boolean isValid() {
        return dateOut.getTime() > dateIn.getTime();
    }

    @Override
    public String message() {
        return "la fecha de ingreso no puede ser mayor a la de la salida";
    }
}
