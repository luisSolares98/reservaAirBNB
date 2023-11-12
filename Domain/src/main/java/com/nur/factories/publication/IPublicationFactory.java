package com.nur.factories.publication;


import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Publication;
import com.nur.model.Reserve;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public interface IPublicationFactory {
    Publication createPublication(UUID publishId, UUID reserveID, BigDecimal amount, UUID userID) throws BussinessRuleValidationException;
}
