package com.nur.repositories.publication;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class PublicationJpaRepositoryTest {
    @InjectMocks
    PublicationJpaRepository servicio;

    @Spy
    IPublicationCrudRepository publicationCrudRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void updateReserve() throws BussinessRuleValidationException, ParseException {
        Publication publication = PublishFixture.whitDefault();
        UUID sampleId = UUID.randomUUID();

        Mockito.when(publicationCrudRepository.save(any(UserPublicReserveJpaModel.class))).thenAnswer(invocation -> {
            UserPublicReserveJpaModel savedModel = invocation.getArgument(0);
            savedModel.setId(sampleId); // Assign a UUID or an appropriate ID here
            return savedModel;
        });
        UUID respuesta = servicio.update(publication);
        assertNotNull(respuesta);
        assertEquals(sampleId, respuesta);

    }

    @Test
    void getById() throws BussinessRuleValidationException, ParseException {
        Publication expect = PublishFixture.whitDefault();
        UUID sampleId = UUID.randomUUID();
        Mockito.when(publicationCrudRepository.findById(sampleId)).thenReturn(Optional.of(PublishFixture.whitDefaultJPA()));

        Publication response = servicio.getById(sampleId);
        assertNotNull(response);
        assertEquals(expect.getPublicationID(), response.getPublicationID());
    }
    @Test
    void getByUserId() throws BussinessRuleValidationException, ParseException {
        List<Publication> expect = PublishFixture.whitDefaultList();
        UUID sampleId = UUID.randomUUID();
        Mockito.when(publicationCrudRepository.listByUserId(sampleId)).thenReturn(PublishFixture.whitDefaultListJPA());

        List<Publication> response = servicio.getByUserID(sampleId);
        assertNotNull(response);
        assertEquals(expect.get(0).getPublicationID(), response.get(0).getPublicationID());
    }
}