package com.nur.repositories.checkout;

import com.nur.model.CheckOutJapModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICheckOutCrudRepository extends JpaRepository<CheckOutJapModel, UUID> {
}
