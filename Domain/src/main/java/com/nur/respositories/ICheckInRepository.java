package com.nur.respositories;

import com.nur.model.CheckIn;

import java.util.UUID;

public interface ICheckInRepository {
    UUID update(CheckIn checkIn);

    CheckIn get(UUID id);
}
