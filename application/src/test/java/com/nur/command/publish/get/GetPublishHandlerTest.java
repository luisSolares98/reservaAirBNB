package com.nur.command.publish.get;

import com.nur.command.reserve.get.GetReserveCommand;
import com.nur.command.reserve.get.GetReserveHandler;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.PublishDTO;
import com.nur.dtos.ReserveDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.publication.IPublicationFactory;
import com.nur.factories.reserve.IReserveFactory;
import com.nur.model.*;
import com.nur.respositories.IPublicationRepository;
import com.nur.respositories.IReserveRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetPublishHandlerTest {
    @Mock
    IPublicationRepository repository;
    @Spy
    IPublicationFactory factory;

    @Mock
    GetPublishHandler service;

    @BeforeEach
    void setUp() {
        service = new GetPublishHandler(repository);
    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        doReturn(PublicationFixture.whitDefaultList()).when(repository).getByUserID(any(UUID.class));
        List<Publication> expect = PublicationFixture.whitDefaultList();
        GetPublishCommand command = new GetPublishCommand(PublicationDTOFixture.withDefaultResponse().getUserID());
        List<Publication> respuesta = service.handle(command);
        assertNotNull(respuesta);
        assertEquals(expect.get(0).getPublicationID(), respuesta.get(0).getPublicationID());
    }

    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        GetPublishCommand command = new GetPublishCommand(null);
        assertThrows(InvalidDataException.class, () -> service.handle(command)) ;
    }
}