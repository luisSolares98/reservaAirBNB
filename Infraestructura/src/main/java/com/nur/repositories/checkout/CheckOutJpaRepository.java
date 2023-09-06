package com.nur.repositories.checkout;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.*;
import com.nur.repositories.reserve.IReserveCrudRepository;
import com.nur.respositories.ICheckOutRepository;
import com.nur.utils.CheckOutUtils;
import com.nur.utils.ReserveUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.UUID;
@Service
public class CheckOutJpaRepository implements ICheckOutRepository {
    @Autowired
    private ICheckOutCrudRepository repository;
    @Autowired
    private IReserveCrudRepository reserveCrudRepository;
    @Override
    public UUID update(CheckOut checkOut) {
        CheckOutJapModel model = CheckOutUtils.checkOutToJpaEntity(checkOut);
        try {
            Reserve reserve = ReserveUtils.jpaToreserva(
                    Objects.requireNonNull(reserveCrudRepository.findById(model.getReserveID()).orElse(null))
            );
            if(reserve == null) throw new BussinessRuleValidationException("not find", "reserve" );

            reserve.setState("Finalized");
            ReserveJpaModel reserveJpaModel = ReserveUtils.reservaToJpaEntity(reserve);
            reserveJpaModel.setId(model.getReserveID());
            reserveCrudRepository.save(reserveJpaModel);
            return repository.save(model).getId();
        } catch (BussinessRuleValidationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CheckOut getById(UUID id) {
        try {
            return CheckOutUtils.jpaToCheckOut(repository.findById(id).orElse(null));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
