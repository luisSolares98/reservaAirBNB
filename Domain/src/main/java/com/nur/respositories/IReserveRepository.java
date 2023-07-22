package com.nur.respositories;

import com.nur.core.IRepository;
import com.nur.modal.Reserve;
import org.springframework.scheduling.config.Task;

import java.util.List;
import java.util.UUID;

public interface IReserveRepository extends IRepository<Reserve, UUID> {

    List<Reserve> getAll();

    Task updateReserve(Reserve reserve);

}