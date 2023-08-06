package com.nur.repositories.checkin;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.CheckIn;
import com.nur.model.CheckInJapModel;
import com.nur.model.Reserve;
import com.nur.model.ReserveJpaModel;
import com.nur.repositories.reserve.IReserveCrudRepository;
import com.nur.respositories.ICheckInRepository;
import com.nur.utils.CheckInUtils;

import com.nur.utils.ReserveUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class CheckInJpaRepository implements ICheckInRepository {
    @Autowired
    private ICheckInCrudRepository repository;
    @Autowired
    private IReserveCrudRepository reserveCrudRepository;

    @Override
    public UUID update(CheckIn checkIn) {
        CheckInJapModel model = CheckInUtils.checkInToJpaEntity(checkIn);
        try {
            Reserve reserve =ReserveUtils.jpaToreserva(
                    reserveCrudRepository.findById(model.getReserveID()).orElse(null)
            );
            if(reserve == null) throw new BussinessRuleValidationException("not find", "reserve" );

            reserve.setState("In Progress");
            ReserveJpaModel reserveJpaModel = ReserveUtils.reservaToJpaEntity(reserve);
            reserveJpaModel.setId(model.getReserveID());
            reserveCrudRepository.save(reserveJpaModel);
            return repository.save(model).getId();
        } catch (BussinessRuleValidationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CheckIn getById(UUID id) {
        try {
            return CheckInUtils.jpaToCheckIn(Objects.requireNonNull(repository.findById(id).orElse(null)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
