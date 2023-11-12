package com.nur.respositories;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Publication;

import java.util.List;
import java.util.UUID;

public interface IPublicationRepository {
    UUID update(Publication publication) throws BussinessRuleValidationException;

    Publication getById(UUID id) throws BussinessRuleValidationException;

    List<Publication> getByUserID(UUID userID) throws BussinessRuleValidationException;
}
