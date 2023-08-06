package com.nur.event;

import com.nur.core.DomainEvent;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
public class CheckIn extends DomainEvent {
    private LocalDateTime dateIn;
    private UUID key;

    public CheckIn(LocalDateTime dateIn, UUID key) {
        super(dateIn);
        this.dateIn = dateIn;
        this.key = key;
    }
}
