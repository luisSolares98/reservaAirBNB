package com.nur.repositories.payment;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.*;
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
class PaymentJpaRepositoryTest {
    @InjectMocks
    PaymentJpaRepository servicio;

    @Spy
    IPaymentCrudRepository paymentCrudRepository;
    @Spy
    IReserveCrudRepository reserveCrudRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    void update()  throws BussinessRuleValidationException, ParseException{
        Payment payment = PaymentFixture.whitDefault();
        UUID sampleId = UUID.randomUUID();
        Mockito.when(reserveCrudRepository.findById(any())).thenReturn(Optional.of(ReserveFixture.whitDefaultJPA()));

        Mockito.when(paymentCrudRepository.save(any(PaymentJapModel.class))).thenAnswer(invocation -> {
            PaymentJapModel savedModel = invocation.getArgument(0);
            savedModel.setId(sampleId); // Assign a UUID or an appropriate ID here
            return savedModel;
        });
        UUID respuesta = servicio.update(payment);
        assertNotNull(respuesta);
        assertEquals(sampleId, respuesta);
    }

    @Test
    void getById()  throws BussinessRuleValidationException, ParseException{
        Payment expect = PaymentFixture.whitDefault();
        UUID sampleId = UUID.randomUUID();
        Mockito.when(paymentCrudRepository.findById(sampleId)).thenReturn(Optional.of(PaymentFixture.whitDefaultJPA()));

        Payment respuesta = servicio.getById(sampleId);
        assertNotNull(respuesta);
        assertEquals(expect.getReserveID(), respuesta.getReserveID());
    }
}