package com.nur.repositories.checkin;

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
class CheckInJpaRepositoryTest {
    @InjectMocks
    CheckInJpaRepository servicio;

    @Spy
    ICheckInCrudRepository checkInCrudRepository;

    @Spy
    IReserveCrudRepository reserveCrudRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    void update() throws BussinessRuleValidationException, ParseException{
        CheckIn expect = CheckInFixture.whitDefault();
        UUID sampleId = UUID.randomUUID();
        Mockito.when(reserveCrudRepository.findById(any(UUID.class))).thenReturn(Optional.of(ReserveFixture.whitDefaultJPA()));

        Mockito.when(checkInCrudRepository.save(any(CheckInJapModel.class))).thenAnswer(invocation -> {
            CheckInJapModel savedModel = invocation.getArgument(0);
            savedModel.setId(sampleId); // Assign a UUID or an appropriate ID here
            return savedModel;
        });
        UUID respuesta = servicio.update(expect);
        assertNotNull(respuesta);
        assertEquals(sampleId, respuesta);
    }

    @Test
    void getById() throws BussinessRuleValidationException, ParseException {
        CheckIn expect = CheckInFixture.whitDefault();
        UUID sampleId = UUID.randomUUID();
        Mockito.when(checkInCrudRepository.findById(sampleId)).thenReturn(Optional.of(CheckInFixture.whitDefaultJPA()));

        CheckIn respuesta = servicio.getById(sampleId);
        assertNotNull(respuesta);
        assertEquals(expect.toString(), respuesta.toString());
    }
}