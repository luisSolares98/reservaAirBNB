package com.nur.factories;

import com.nur.modal.Reserve;
import com.nur.modal.enun.StateReserve;

import java.util.Date;

public class ReserveFactory implements IReserveFactory{
    @Override
    public Reserve createReserve( Date dateIn, String state, Date dateOut) {
        return new Reserve( dateIn, state, dateOut);
    }
}
