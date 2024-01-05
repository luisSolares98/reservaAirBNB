package com.nur.repositories.reserve;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Reserve;
import com.nur.model.ReserveJpaModel;
import com.nur.respositories.IReserveRepository;
import com.nur.utils.ReserveUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class ReserveJpaRepository implements IReserveRepository {

	@Autowired
	private IReserveCrudRepository reserveCrudRepository;

	@Override
	public List<Reserve> getAll() throws BussinessRuleValidationException {
		List<ReserveJpaModel> jpaModels = reserveCrudRepository.findAll();
		List<Reserve> baggages = new ArrayList<>();
		if (jpaModels.isEmpty())
			return Collections.emptyList();
		for (ReserveJpaModel reserveJpaModel : jpaModels) {
			baggages.add(ReserveUtils.jpaToreserva(reserveJpaModel));
		}
		return baggages;
	}

	@Override
	public UUID updateReserve(Reserve reserve) {
		ReserveJpaModel reserveJpaModel = ReserveUtils.reservaToJpaEntity(reserve);
		return reserveCrudRepository.save(reserveJpaModel).getId();
	}

	@Override
	public Reserve getById(UUID id) throws BussinessRuleValidationException {

		return ReserveUtils.jpaToreserva(reserveCrudRepository.findById(id).orElse(null));
	}

}
