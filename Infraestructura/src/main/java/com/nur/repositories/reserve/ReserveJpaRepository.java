package com.nur.repositories.reserve;

import com.nur.model.ReserveJpaModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ReserveJpaRepository implements IReserveCrudRepository{
    @Autowired
    private IReserveCrudRepository reserveCrudRepository;

    @Override
    public List<ReserveJpaModel> listReserve(ReserveJpaModel reserveJpaModel) {
        // Iterable<ReserveJpaModel> reserveJpaModels =  reserveCrudRepository.findAll();

        return null;
    }

    @Override
    public <S extends ReserveJpaModel> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ReserveJpaModel> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ReserveJpaModel> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public Iterable<ReserveJpaModel> findAll() {
        return reserveCrudRepository.findAll();
    }

    @Override
    public Iterable<ReserveJpaModel> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(ReserveJpaModel entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends ReserveJpaModel> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
