package com.nur.core;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public abstract class DomainEvent {

	public UUID Key;

	public LocalDateTime OcurredOn;

	protected DomainEvent(LocalDateTime ocurredOn) {
		this.OcurredOn = ocurredOn;
		this.Key = UUID.randomUUID();
	}

}
