package com.nur.core;

public abstract class AggregateRoot<UID> extends Entity<UID>{
    protected AggregateRoot(UID key) {
        super(key);
    }
}
