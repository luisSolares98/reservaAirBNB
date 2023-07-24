package com.nur.factories;

import com.nur.modal.Reserve;
import com.nur.modal.enun.StateReserve;

import java.util.Date;

public class ReserveFactory implements IReserveFactory{
    @Override
    public Reserve createReserve(int dni, Date dateIn, StateReserve state, Date dateOut) {
        return new Reserve(dni, dateIn, state, dateOut);
    }
}
