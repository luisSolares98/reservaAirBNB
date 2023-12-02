package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.Publication;
import com.nur.model.Reserve;
import com.nur.model.ReserveFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class PublicationUtilsTest {

    @Mock
    PublicationUtils utils;

    @BeforeEach
    void setUp() {
        utils = new PublicationUtils();
    }

    @Test
    void publicationJpaModelList() {
    }

    @Test
    void publicationToJpaEntity() {
    }

    @Test
    void jpaToPublication() {

    }

    @Test
    void jpaToPublicationNull() throws BussinessRuleValidationException {
        InvalidDataException exception = assertThrows(InvalidDataException.class, () -> PublicationUtils.jpaToPublication(null)) ;
        assertEquals("Data Not Found", exception.getMessage());
    }
}