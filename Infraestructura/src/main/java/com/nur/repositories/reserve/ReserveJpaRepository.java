package com.nur.repositories.reserve;

import com.nur.model.Reserve;
import com.nur.model.ReserveJpaModel;
import com.nur.respositories.IReserveRepository;
import com.nur.utils.ReserveUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ReserveJpaRepository implements IReserveRepository {
    @Autowired
    private IReserveCrudRepository reserveCrudRepository;
    @Override
    public List<Reserve> getAll() {
        return null;
    }

    @Override
    public UUID updateReserve(Reserve reserve) {
        ReserveJpaModel reserveJpaModel = ReserveUtils.reservaToJpaEntity(reserve);
        reserveCrudRepository.save(reserveJpaModel);
        return reserveCrudRepository.save(reserveJpaModel).getId();
    }

    @Override
    public Reserve getById(UUID id) {
        try {
            return ReserveUtils.jpaToreserva(
                    reserveCrudRepository.findById(id).orElse(null)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*@Override
    public void CreateAsync(Reserve obj) {
        ReserveJpaModel reserveJpaModel = ReserveUtils.reservaToJpaEntity(obj);
        System.out.println(reserveCrudRepository.save(reserveJpaModel).getId());
    }*/

}
