package com.nur.repositories.reserve;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.Reserve;
import static org.mockito.ArgumentMatchers.any;

import com.nur.model.ReserveFixture;
import com.nur.model.ReserveJpaModel;
import com.nur.utils.ReserveUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ReserveJpaRepositoryTest {
    @InjectMocks
    ReserveJpaRepository servicio;

    @Spy
    IReserveCrudRepository reserveCrudRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll() throws BussinessRuleValidationException, ParseException {
        List<ReserveJpaModel> expectJpa = ReserveFixture.whitDefaultListJPA();
        Mockito.when(reserveCrudRepository.findAll()).thenReturn(Optional.of(expectJpa).orElse(null));

        List<Reserve> expect = ReserveFixture.whitDefaultList();
        List<Reserve> respuesta = servicio.getAll();
        assertNotNull(respuesta);
        assertEquals(expect.toString(), respuesta.toString());
    }

    @Test
    void getAllVoid() throws BussinessRuleValidationException, ParseException {
        Mockito.when(reserveCrudRepository.findAll()).thenReturn(Collections.emptyList());
        List<Reserve> respuesta = servicio.getAll();
        assertNotNull(respuesta);
        assertEquals(0, respuesta.size());
    }
    @Test
    void updateReserve() throws BussinessRuleValidationException, ParseException {
        Reserve reserve = ReserveFixture.whitDefault();
        UUID sampleId = UUID.randomUUID();

        Mockito.when(reserveCrudRepository.save(any(ReserveJpaModel.class))).thenAnswer(invocation -> {
            ReserveJpaModel savedModel = invocation.getArgument(0);
            savedModel.setId(sampleId); // Assign a UUID or an appropriate ID here
            return savedModel;
        });
        UUID respuesta = servicio.updateReserve(reserve);
        assertNotNull(respuesta);
        assertEquals(sampleId, respuesta);

    }

    @Test
    void getById() throws BussinessRuleValidationException, ParseException {
        Reserve expect = ReserveFixture.whitDefault();
        UUID sampleId = UUID.randomUUID();
        Mockito.when(reserveCrudRepository.findById(sampleId)).thenReturn(Optional.of(ReserveFixture.whitDefaultJPA()));

        Reserve respuesta = servicio.getById(sampleId);
        assertNotNull(respuesta);
        assertEquals(expect.toString(), respuesta.toString());
    }

    @Test
    void getByIdNull() throws BussinessRuleValidationException, ParseException {
        UUID sampleId = UUID.randomUUID();
        Mockito.when(reserveCrudRepository.findById(sampleId)).thenReturn(Optional.empty());
        assertThrows(InvalidDataException.class, () -> {
            servicio.getById(sampleId);
        });
    }
}