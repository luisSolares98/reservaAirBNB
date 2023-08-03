package com.nur.factories;

import com.nur.modal.Reserve;
import com.nur.modal.enun.StateReserve;

import java.util.Date;

public interface IReserveFactory {
    Reserve createReserve(Date dateIn, String state, Date dateOut);
}
