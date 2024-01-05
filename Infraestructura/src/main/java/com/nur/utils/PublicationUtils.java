package com.nur.utils;

import com.nur.exceptions.InvalidDataException;
import com.nur.model.Publication;
import com.nur.model.UserPublicReserveJpaModel;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PublicationUtils {

	public static List<Publication> publicationJpaModelList(List<UserPublicReserveJpaModel> publications) {
		if (publications == null)
			return Collections.emptyList();
		return publications.stream().map(PublicationUtils::jpaToPublication).toList();
	}

	public static UserPublicReserveJpaModel publicationToJpaEntity(Publication publication) {
		UserPublicReserveJpaModel model = new UserPublicReserveJpaModel();
		model.setId(publication.getKey());
		model.setAmount(publication.getAmount());
		model.setPublishID(publication.getPublicationID());
		model.setReserveID(publication.getReserveID());
		model.setUserID(publication.getUserID());
		return model;
	}

	public static Publication jpaToPublication(UserPublicReserveJpaModel jpaModel) {

		if (Objects.isNull(jpaModel))
			throw new InvalidDataException("jpaModel is null");

		return new Publication(jpaModel.getId(), jpaModel.getAmount(), jpaModel.getPublishID(), jpaModel.getReserveID(),
				jpaModel.getUserID());
	}

}
