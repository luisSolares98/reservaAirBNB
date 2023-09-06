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
class CheckInUtilsTest {

    @Mock
    CheckInUtils utils;

    @BeforeEach
    void setUp() {
        utils = new CheckInUtils();
    }

    @Test
    void checkInJpaModelListVoid() throws BussinessRuleValidationException, ParseException {
        List<CheckInJapModel> listJpa = CheckInFixture.whitDefaultListJPA();
        List<CheckInJapModel> expect = CheckInUtils.checkInJpaModelList(null);
        assertNotNull(expect);
    }
    @Test
    void checkInJpaModelList() throws BussinessRuleValidationException, ParseException {
        List<CheckInJapModel> listJpa = CheckInFixture.whitDefaultListJPA();
        List<CheckIn> list = CheckInFixture.whitDefaultList();
        List<CheckInJapModel> expect = CheckInUtils.checkInJpaModelList(list);
        assertEquals(expect.toString(), listJpa.toString());
    }
    @Test
    void jpaToCheckInNull() throws BussinessRuleValidationException {
        InvalidDataException exception = assertThrows(InvalidDataException.class, () -> CheckInUtils.jpaToCheckIn(null)) ;
        assertEquals("Data Not Found", exception.getMessage());
    }

    @Test
    void jpaToCheckIn() throws BussinessRuleValidationException, ParseException {
        CheckIn expect = CheckInFixture.whitDefault();
        CheckIn response = CheckInUtils.jpaToCheckIn(CheckInFixture.whitDefaultJPA());
        assertEquals(expect.toString(), response.toString());
    }
}