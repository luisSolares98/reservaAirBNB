package com.nur.factories.checkout;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.CheckOut;
import java.util.Date;
import java.util.UUID;

public interface ICheckOutFactory {

	CheckOut create(Date dateTimeCheckOut, String typeCheckOut, UUID reserveID) throws BussinessRuleValidationException;

}
