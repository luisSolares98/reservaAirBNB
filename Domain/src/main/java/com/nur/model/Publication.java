package com.nur.model;

import com.nur.core.AggregateRoot;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
public class Publication extends AggregateRoot {
    private BigDecimal amount;

    private UUID publicationID;

    private UUID userID;

    private UUID reserveID;

    public Publication(BigDecimal amount, UUID publicationID, UUID reserveID, UUID userID) {
        this.amount = amount;
        this.publicationID = publicationID;
        this.reserveID = reserveID;
        this.userID = userID;
    }
    public Publication(UUID ID, BigDecimal amount, UUID publicationID, UUID reserveID, UUID userID) {
        this.key = ID;
        this.amount = amount;
        this.publicationID = publicationID;
        this.reserveID = reserveID;
        this.userID = userID;
    }
}
