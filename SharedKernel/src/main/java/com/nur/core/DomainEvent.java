package com.nur.core;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public abstract class DomainEvent {

	public final UUID key;

	public final LocalDateTime ocurredOn;

	protected DomainEvent(LocalDateTime ocurredOn) {
		this.ocurredOn = ocurredOn;
		this.key = UUID.randomUUID();
	}

}
