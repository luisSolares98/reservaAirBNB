package com.nur.model;

import com.nur.core.BussinessRuleValidationException;
import com.nur.util.UtilTest;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ReserveFixture {

	public static Reserve whitDefault() throws BussinessRuleValidationException, ParseException {
		return new Reserve(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"),
				"Realizada", UtilTest.parseToDate("2022-05-29"),
				UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c28"));
	}

	public static List<Reserve> whitDefaultList() throws BussinessRuleValidationException, ParseException {
		return Arrays.asList(
				new Reserve(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"),
						"Realizada", UtilTest.parseToDate("2022-05-29"),
						UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c28")),
				new Reserve(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), UtilTest.parseToDate("2022-05-21"),
						"Realizada", UtilTest.parseToDate("2022-05-29"),
						UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c28")));
	}

	public static List<ReserveJpaModel> whitDefaultListJPA() throws BussinessRuleValidationException, ParseException {
		return Arrays.asList(
				new ReserveJpaModel(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"),
						UtilTest.parseToDate("2022-05-21"), UtilTest.parseToDate("2022-05-29"), "Realizada"),
				new ReserveJpaModel(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"),
						UtilTest.parseToDate("2022-05-21"), UtilTest.parseToDate("2022-05-29"), "Realizada"));
	}

	public static ReserveJpaModel whitDefaultJPA() throws BussinessRuleValidationException, ParseException {
		Reserve reserva = whitDefault();
		ReserveJpaModel model = new ReserveJpaModel();
		model.setId(reserva.getKey());
		model.setState(reserva.getState().toString());
		model.setDateIn(reserva.getDateIn());
		model.setDateOut(reserva.getDateOut());
		return model;
	}

}
