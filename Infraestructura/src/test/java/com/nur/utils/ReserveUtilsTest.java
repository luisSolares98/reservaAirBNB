package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.Reserve;
import com.nur.model.ReserveFixture;
import com.nur.model.ReserveJpaModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.ParseException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReserveUtilsTest {

	@Mock
	ReserveUtils utils;

	@BeforeEach
	void setUp() {
		utils = new ReserveUtils();
	}

	@Test
	void reserveJpaModelListVoid() throws BussinessRuleValidationException, ParseException {
		List<ReserveJpaModel> listJpa = ReserveFixture.whitDefaultListJPA();
		List<ReserveJpaModel> expect = ReserveUtils.reserveJpaModelList(null);
		assertNotNull(expect);
	}

	@Test
	void reserveJpaModelList() throws BussinessRuleValidationException, ParseException {
		List<ReserveJpaModel> listJpa = ReserveFixture.whitDefaultListJPA();
		List<Reserve> list = ReserveFixture.whitDefaultList();
		List<ReserveJpaModel> expect = ReserveUtils.reserveJpaModelList(list);
		assertEquals(expect.toString(), listJpa.toString());
	}

	@Test
	void jpaToreservaNull() throws BussinessRuleValidationException {
		InvalidDataException exception = assertThrows(InvalidDataException.class,
				() -> ReserveUtils.jpaToreserva(null));
		assertEquals("Data Not Found", exception.getMessage());
	}

	@Test
	void jpaToreserva() throws BussinessRuleValidationException, ParseException {
		Reserve expect = ReserveFixture.whitDefault();
		Reserve response = ReserveUtils.jpaToreserva(ReserveFixture.whitDefaultJPA());
		assertEquals(expect.toString(), response.toString());
	}

}