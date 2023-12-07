package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.Publication;
import com.nur.model.UserPublicReserveJpaModel;

import java.util.Collections;
import java.util.List;

public class PublicationUtils {

	public static List<Publication> publicationJpaModelList(List<UserPublicReserveJpaModel> publications)
			throws BussinessRuleValidationException {
		if (publications == null)
			return Collections.emptyList();
		return publications.stream().map((UserPublicReserveJpaModel publication) -> {
			try {
				return jpaToPublication(publication);
			}
			catch (BussinessRuleValidationException e) {
				throw new RuntimeException(e);
			}
		}).toList();
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

	public static Publication jpaToPublication(UserPublicReserveJpaModel jpaModel)
			throws BussinessRuleValidationException {
		if (jpaModel == null) {
			throw new InvalidDataException("Data Not Found");
		}
		return new Publication(jpaModel.getId(), jpaModel.getAmount(), jpaModel.getPublishID(), jpaModel.getReserveID(),
				jpaModel.getUserID());
	}

}
