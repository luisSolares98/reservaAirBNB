package com.nur.repositories.checkout;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.*;
import com.nur.repositories.reserve.IReserveCrudRepository;
import com.nur.respositories.ICheckOutRepository;
import com.nur.utils.CheckOutUtils;
import com.nur.utils.ReserveUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
@Service
public class CheckOutJpaRepository implements ICheckOutRepository {
    @Autowired
    private ICheckOutCrudRepository repository;
    @Autowired
    private IReserveCrudRepository reserveCrudRepository;
    @Override
    public UUID update(CheckOut checkOut) throws BussinessRuleValidationException {
        CheckOutJapModel model = CheckOutUtils.checkOutToJpaEntity(checkOut);
        Reserve reserve = ReserveUtils.jpaToreserva(
            reserveCrudRepository.findById(model.getReserveID()).orElse(null)
        );

        reserve.setState("Finalized");
        ReserveJpaModel reserveJpaModel = ReserveUtils.reservaToJpaEntity(reserve);
        reserveJpaModel.setId(model.getReserveID());
        reserveCrudRepository.save(reserveJpaModel);
        return repository.save(model).getId();
    }

    @Override
    public CheckOut getById(UUID id) throws BussinessRuleValidationException {
       return CheckOutUtils.jpaToCheckOut(repository.findById(id).orElse(null));
    }
}
