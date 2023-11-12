package com.nur.repositories.publication;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Publication;
import com.nur.model.UserPublicReserveJpaModel;
import com.nur.respositories.IPublicationRepository;
import com.nur.utils.PublicationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PublicationJpaRepository implements IPublicationRepository {
    @Autowired
    private IPublicationCrudRepository publicationCrudRepository;


    @Override
    public UUID update(Publication publication) throws BussinessRuleValidationException {
        UserPublicReserveJpaModel reserveJpaModel = PublicationUtils.publicationToJpaEntity(publication);
        return publicationCrudRepository.save(reserveJpaModel).getId();
    }

    @Override
    public Publication getById(UUID id) throws BussinessRuleValidationException {
            return PublicationUtils.jpaToPublication(
                    publicationCrudRepository.findById(id).orElse(null)
            );
    }

    @Override
    public List<Publication> getByUserID(UUID userID) throws BussinessRuleValidationException {
        return PublicationUtils.publicationJpaModelList(publicationCrudRepository.listByUserId(userID));
    }


}
