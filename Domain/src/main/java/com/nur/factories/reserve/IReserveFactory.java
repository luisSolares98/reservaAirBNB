package com.nur.factories.reserve;


import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Reserve;

import java.util.Date;
import java.util.UUID;

public interface IReserveFactory {
    Reserve createReserve(Date dateIn, String state, Date dateOut, UUID publishID) throws BussinessRuleValidationException;
}
