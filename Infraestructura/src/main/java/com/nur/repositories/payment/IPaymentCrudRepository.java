package com.nur.repositories.payment;

import com.nur.model.PaymentJapModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPaymentCrudRepository extends JpaRepository<PaymentJapModel, UUID> {
}
