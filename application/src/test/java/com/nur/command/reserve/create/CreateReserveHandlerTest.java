package com.nur.command.reserve.create;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.ReserveDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.publication.IPublicationFactory;
import com.nur.factories.reserve.IReserveFactory;
import com.nur.model.ReserveDTOFixture;
import com.nur.respositories.IPublicationRepository;
import com.nur.respositories.IReserveRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class CreateReserveHandlerTest {

    @Mock
    IReserveRepository repository;
    @Spy
    IReserveFactory factory;

    @InjectMocks
    CreateReserveHandler service;

    @Mock
    IPublicationRepository publicationRepository;

    @Mock
    IPublicationFactory publicationFactory;


    @Mock
    RabbitTemplate template;

    @BeforeEach
    void setUp() {
        service = new CreateReserveHandler(repository, publicationRepository);
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        ReserveDTO expect = ReserveDTOFixture.withDefaultResponse();
        CreateReserveCommand command = new CreateReserveCommand(ReserveDTOFixture.withDefaultResponse());
        //Mockito.when(publicationFactory.createPublication(any(), any(),any(),any())).thenReturn(PublicationFixture.whitDefault());
        Mockito.doNothing().when(template).convertAndSend(anyString(), (Object) any());

        ReserveDTO respuesta = service.handle(command);
        assertEquals(expect.getDateIn(), respuesta.getDateIn());
        assertEquals(expect.getDateOut(), respuesta.getDateOut());
        assertEquals(expect.getState(), respuesta.getState());
    }
    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        CreateReserveCommand command = new CreateReserveCommand(null);
        assertThrows(NullPointerException.class, () -> service.handle(command)) ;
    }
    @Test
    void handleErrorFecha() throws ParseException, BussinessRuleValidationException {
        CreateReserveCommand command = new CreateReserveCommand(ReserveDTOFixture.whitDefaultFail());
        assertThrows(InvalidDataException.class, () -> service.handle(command)) ;
    }
}