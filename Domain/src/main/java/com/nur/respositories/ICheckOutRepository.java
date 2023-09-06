package com.nur.respositories;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.CheckOut;

import java.util.UUID;

public interface ICheckOutRepository {
    UUID update(CheckOut checkOut) throws BussinessRuleValidationException;

    CheckOut getById(UUID id) throws BussinessRuleValidationException;
}
