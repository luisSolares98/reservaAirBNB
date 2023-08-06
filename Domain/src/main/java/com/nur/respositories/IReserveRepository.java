package com.nur.respositories;

import com.nur.model.Reserve;
import java.util.List;
import java.util.UUID;

public interface IReserveRepository {

    List<Reserve> getAll();

    UUID updateReserve(Reserve reserve);
    Reserve getById(UUID id);
}