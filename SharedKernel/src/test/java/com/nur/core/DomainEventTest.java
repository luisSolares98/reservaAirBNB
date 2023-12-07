package com.nur.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DomainEventTest {

	@Mock
	DomainEvent event;

	LocalDateTime fecha;

	@BeforeEach
	void setUp() {
		fecha = LocalDateTime.now();
		event = new DomainEvent(fecha) {
			@Override
			public UUID getKey() {
				return super.getKey();
			}

			@Override
			public LocalDateTime getOcurredOn() {
				return super.getOcurredOn();
			}
		};
		ReflectionTestUtils.setField(event, "Key", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"));

	}

	@Test
	void getKey() {
		assertEquals(event.getKey().toString(), "effa368e-2f33-49c7-94e4-a4dfb3be2c27");
	}

	@Test
	void getOcurredOn() {
		assertEquals(event.getOcurredOn().toString(), fecha.toString());
	}

}