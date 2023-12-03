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
import java.util.Properties;

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
    void publicationJpaModelList() throws BussinessRuleValidationException, ParseException {
        List<UserPublicReserveJpaModel> listJpa = PublishFixture.whitDefaultListJPA();
        List<Publication> list = PublishFixture.whitDefaultList();
        List<Publication> expect = PublicationUtils.publicationJpaModelList(listJpa);
        assertEquals(expect.toString(), list.toString());
    }

    @Test
    void publicationJpaModelListNull() throws BussinessRuleValidationException, ParseException {
        List<Publication> expect = PublicationUtils.publicationJpaModelList(null);
        assertNotNull(expect);
    }

    @Test
    void publicationToJpaEntity() throws BussinessRuleValidationException, ParseException {
        UserPublicReserveJpaModel expect = PublishFixture.whitDefaultJPA();
        UserPublicReserveJpaModel response = PublicationUtils.publicationToJpaEntity(PublishFixture.whitDefaultAll());
        assertEquals(expect.toString(), response.toString());

    }

    @Test
    void jpaToPublication() throws BussinessRuleValidationException, ParseException {
        Publication expect = PublishFixture.whitDefault();
        Publication response = PublicationUtils.jpaToPublication(PublishFixture.whitDefaultJPA());
        assertEquals(expect.toString(), response.toString());
    }

    @Test
    void jpaToPublicationNull() throws BussinessRuleValidationException {
        InvalidDataException exception = assertThrows(InvalidDataException.class, () -> PublicationUtils.jpaToPublication(null)) ;
        assertEquals("Data Not Found", exception.getMessage());
    }
}