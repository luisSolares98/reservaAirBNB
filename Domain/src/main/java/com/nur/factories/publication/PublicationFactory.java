package com.nur.factories.publication;


import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Publication;

import java.math.BigDecimal;
import java.util.UUID;

public class PublicationFactory implements IPublicationFactory {

    @Override
    public Publication createPublication(UUID publishId, UUID reserveID, BigDecimal amount, UUID userID) throws BussinessRuleValidationException {
        return new Publication(amount, publishId, reserveID, userID);
    }
}
