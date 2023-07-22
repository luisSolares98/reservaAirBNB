package com.nur.factories;

import com.nur.modal.Reserve;
import com.nur.modal.StateReserve;

import java.util.Date;

public interface IReserveFactory {
    Reserve createReserve(int dni, Date dateIn, StateReserve state, Date dateOut);
}
