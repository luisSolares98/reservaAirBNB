package com.nur.respositories;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Reserve;
import java.util.List;
import java.util.UUID;

public interface IReserveRepository {

    List<Reserve> getAll() throws BussinessRuleValidationException;

    UUID updateReserve(Reserve reserve);
    Reserve getById(UUID id) throws BussinessRuleValidationException;
}