package com.nur.factories.checkin;

import com.nur.core.BussinessRuleValidationException;
import com.nur.factories.reserve.IReserveFactory;
import com.nur.model.CheckIn;
import com.nur.model.CheckInFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CheckInFactoryTest {

	@Mock
	CheckInFactory factory;

	@Spy
	ICheckInFactory inFactory;

	@BeforeEach
	void setUp() {
		this.factory = new CheckInFactory();
	}

	@Test
	void create() throws BussinessRuleValidationException, ParseException {
		CheckIn expect = CheckInFixture.whitDefault();
		CheckIn response = factory.create(expect.getDateTimeCheckIn(), expect.getTypeCheckIn(), expect.getReserveID());
		assertEquals(expect.toString(), response.toString());
	}

}