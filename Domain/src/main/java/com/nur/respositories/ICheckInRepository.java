package com.nur.respositories;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.CheckIn;

import java.util.UUID;

public interface ICheckInRepository {

	UUID update(CheckIn checkIn) throws BussinessRuleValidationException;

	CheckIn getById(UUID id) throws BussinessRuleValidationException;

}
