package com.nur.events;

import com.nur.core.DomainEvent;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.UUID;
@Getter
public class CheckOut extends DomainEvent {
    private LocalDateTime dateIn;
    private UUID key;

    public CheckOut(LocalDateTime dateIn, UUID key) {
        super(dateIn);
        this.dateIn = dateIn;
        this.key = key;
    }
}