package com.nur.factories.checkin;

import com.nur.model.CheckIn;
import java.util.Date;
import java.util.UUID;

public class CheckInFactory implements ICheckInFactory {

	@Override
	public CheckIn create(Date dateTimeCheckIn, String typeCheckIn, UUID reserveID) {
		return new CheckIn(dateTimeCheckIn, typeCheckIn, reserveID);
	}

}
