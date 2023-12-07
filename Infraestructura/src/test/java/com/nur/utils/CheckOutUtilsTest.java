package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CheckOutUtilsTest {

	@Mock
	CheckOutUtils utils;

	@BeforeEach
	void setUp() {
		utils = new CheckOutUtils();
	}

	@Test
	void checkOutJpaModelListVoid() throws BussinessRuleValidationException, ParseException {
		List<CheckOutJapModel> listJpa = CheckOutFixture.whitDefaultListJPA();
		List<CheckOutJapModel> expect = CheckOutUtils.checkOutJpaModelList(null);
		assertNotNull(expect);
	}

	@Test
	void checkOutJpaModelList() throws BussinessRuleValidationException, ParseException {
		List<CheckOutJapModel> listJpa = CheckOutFixture.whitDefaultListJPA();
		List<CheckOut> list = CheckOutFixture.whitDefaultList();
		List<CheckOutJapModel> expect = CheckOutUtils.checkOutJpaModelList(list);
		assertEquals(expect.toString(), listJpa.toString());
	}

	@Test
	void jpaToCheckOutNull() throws BussinessRuleValidationException {
		InvalidDataException exception = assertThrows(InvalidDataException.class,
				() -> CheckOutUtils.jpaToCheckOut(null));
		assertEquals("Data Not Found", exception.getMessage());
	}

	@Test
	void jpaToCheckOut() throws BussinessRuleValidationException, ParseException {
		CheckOut expect = CheckOutFixture.whitDefault();
		CheckOut response = CheckOutUtils.jpaToCheckOut(CheckOutFixture.whitDefaultJPA());
		assertEquals(expect.toString(), response.toString());
	}

}