package com.nur.factories.checkin;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.CheckIn;
import java.util.Date;
import java.util.UUID;

public interface ICheckInFactory {
  CheckIn create(Date dateTimeCheckIn, String typeCheckIn, UUID reserveID) throws BussinessRuleValidationException;
}
