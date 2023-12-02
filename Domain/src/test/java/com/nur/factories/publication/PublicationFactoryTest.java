package com.nur.factories.publication;

import com.nur.core.BussinessRuleValidationException;
import com.nur.factories.reserve.IReserveFactory;
import com.nur.factories.reserve.ReserveFactory;
import com.nur.model.Publication;
import com.nur.model.PublicationFixture;
import com.nur.model.Reserve;
import com.nur.model.ReserveFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PublicationFactoryTest {

    @Mock
    PublicationFactory publicationFactory;

    @Spy
    IPublicationFactory iPublicationFactory;
    @BeforeEach
    void setUp() {
        this.publicationFactory  = new PublicationFactory();
    }

    @Test
    void createPublication() throws BussinessRuleValidationException, ParseException {
        Publication expect = PublicationFixture.whitDefault();

        Publication response = publicationFactory.createPublication(expect.getPublicationID(), expect.getReserveID(), expect.getAmount(), expect.getUserID());
        assertEquals(expect.getPublicationID(), response.getPublicationID());
    }

    @Test
    void createPublicationAll() throws BussinessRuleValidationException, ParseException {
        Publication expect = PublicationFixture.whitDefaultAll();

        Publication response = publicationFactory.createPublication(expect.getPublicationID(), expect.getReserveID(), expect.getAmount(), expect.getUserID());
        assertEquals(expect.getPublicationID(), response.getPublicationID());
    }
}