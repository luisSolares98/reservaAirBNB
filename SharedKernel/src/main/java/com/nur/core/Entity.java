package com.nur.core;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public abstract class Entity {
    public UUID key;
    public List<DomainEvent> domainEvents;

    protected Entity() {
        this.key = UUID.randomUUID();
        this.domainEvents = new ArrayList<>();
    }

    public void addDomainEvents(DomainEvent event) {
        this.domainEvents.add(event);
    }
    protected void setKey(UUID key) {
        this.key = key;
    }
}
