package com.nur.core;

import com.nur.AggregateRootTest;
import com.nur.ConcreteEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class EntityTest {
    @Spy
    ConcreteEntity entity;

    @Spy
    AggregateRootTest testAgregate = new AggregateRootTest();
    @BeforeEach
    void setUp() {
        entity = new ConcreteEntity();
    }

    @Test
    void addDomainEvents() {
    }

    @Test
    void setKey() {
        UUID KEYnew = UUID.randomUUID();
        entity.setKey(KEYnew);
        assertEquals(KEYnew.toString(), entity.getKey().toString());
    }

    @Test
    void getKey() {
    }

    @Test
    void getDomainEvents() {
        LocalDateTime fecha = LocalDateTime.now();
        DomainEvent event = new DomainEvent(fecha) {
            @Override
            public UUID getKey() {
                return super.getKey();
            }
            @Override
            public LocalDateTime getOcurredOn() {
                return super.getOcurredOn();
            }
        };
        entity.addDomainEvents(event);
        assertFalse(entity.getDomainEvents().isEmpty());
        assertTrue(entity.getDomainEvents().contains(event));
    }
}