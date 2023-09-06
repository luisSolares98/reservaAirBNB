package com.nur.repositories.checkout;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.*;
import com.nur.repositories.payment.IPaymentCrudRepository;
import com.nur.repositories.payment.PaymentJpaRepository;
import com.nur.repositories.reserve.IReserveCrudRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CheckOutJpaRepositoryTest {
    @InjectMocks
    CheckOutJpaRepository servicio;

    @Spy
    ICheckOutCrudRepository checkOutCrudRepository;
    @Spy
    IReserveCrudRepository reserveCrudRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    void update()  throws BussinessRuleValidationException, ParseException{
        CheckOut payment = CheckOutFixture.whitDefault();
        UUID sampleId = UUID.randomUUID();
        Mockito.when(reserveCrudRepository.findById(any(UUID.class))).thenReturn(Optional.of(ReserveFixture.whitDefaultJPA()));

        Mockito.when(checkOutCrudRepository.save(any(CheckOutJapModel.class))).thenAnswer(invocation -> {
            CheckOutJapModel savedModel = invocation.getArgument(0);
            savedModel.setId(sampleId); // Assign a UUID or an appropriate ID here
            return savedModel;
        });
        UUID respuesta = servicio.update(payment);
        assertNotNull(respuesta);
        assertEquals(sampleId, respuesta);
    }

    @Test
    void getById() throws BussinessRuleValidationException, ParseException {
        CheckOut expect = CheckOutFixture.whitDefault();
        UUID sampleId = UUID.randomUUID();
        Mockito.when(checkOutCrudRepository.findById(sampleId)).thenReturn(Optional.of(CheckOutFixture.whitDefaultJPA()));

        CheckOut respuesta = servicio.getById(sampleId);
        assertNotNull(respuesta);
        assertEquals(expect.toString(), respuesta.toString());
    }
}