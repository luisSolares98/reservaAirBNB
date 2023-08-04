package com.nur.repositories.reserve;

import com.nur.model.ReserveJpaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IReserveCrudRepository extends CrudRepository<ReserveJpaModel, UUID> {
    @Query(
            "SELECT reserveJpaModel from ReserveJpaModel as reserveJpaModel"
    )
    List<ReserveJpaModel> listReserve(ReserveJpaModel reserveJpaModel);
}
