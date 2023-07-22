package com.nur.core;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Entity<UID> {
    public UID key;
    public List<DomainEvent> domainEvents;

    protected Entity(UID key) {
        this.key = key;
        this.domainEvents = new ArrayList<>();
    }

    public void addDomainEvents(DomainEvent event) {
        this.domainEvents.add(event);
    }
    protected void setKey(UID key) {
        this.key = key;
    }
}
