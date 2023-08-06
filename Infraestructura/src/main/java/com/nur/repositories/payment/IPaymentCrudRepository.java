package com.nur.repositories.payment;

import com.nur.model.PaymentJapModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface IPaymentCrudRepository extends JpaRepository<PaymentJapModel, UUID> {
}
