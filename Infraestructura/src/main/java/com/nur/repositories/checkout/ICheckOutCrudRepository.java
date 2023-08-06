package com.nur.repositories.checkout;

import com.nur.model.CheckOutJapModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface ICheckOutCrudRepository extends JpaRepository<CheckOutJapModel, UUID> {
}
