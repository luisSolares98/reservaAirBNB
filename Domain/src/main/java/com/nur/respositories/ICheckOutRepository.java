package com.nur.respositories;

import com.nur.model.CheckOut;

import java.util.UUID;

public interface ICheckOutRepository {
    UUID update(CheckOut checkOut);

    CheckOut getById(UUID id);
}
