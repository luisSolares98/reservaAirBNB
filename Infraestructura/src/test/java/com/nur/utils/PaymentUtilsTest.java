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
class PaymentUtilsTest {

    @Mock
    PaymentUtils utils;

    @BeforeEach
    void setUp() {
        utils = new PaymentUtils();
    }

    @Test
    void paymentJpaModelListVoid() throws BussinessRuleValidationException, ParseException {
        List<PaymentJapModel> listJpa = PaymentFixture.whitDefaultListJPA();
        List<PaymentJapModel> expect = PaymentUtils.paymentJpaModelList(null);
        assertNotNull(expect);
    }
    @Test
    void paymentJpaModelList() throws BussinessRuleValidationException, ParseException {
        List<PaymentJapModel> listJpa = PaymentFixture.whitDefaultListJPA();
        List<Payment> list = PaymentFixture.whitDefaultList();
        List<PaymentJapModel> expect = PaymentUtils.paymentJpaModelList(list);
        assertEquals(expect.toString(), listJpa.toString());
    }
    @Test
    void jpaToPaymentNull() throws BussinessRuleValidationException {
        InvalidDataException exception = assertThrows(InvalidDataException.class, () -> PaymentUtils.jpaToPayment(null)) ;
        assertEquals("Data Not Found", exception.getMessage());
    }

    @Test
    void jpaToPayment() throws BussinessRuleValidationException, ParseException {
        Payment expect = PaymentFixture.whitDefault();
        Payment response = PaymentUtils.jpaToPayment(PaymentFixture.whitDefaultJPA());
        assertEquals(expect.getReserveID(), response.getReserveID());
    }
}