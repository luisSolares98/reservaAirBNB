package com.nur.repositories.checkin;

import com.nur.model.CheckInJapModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ICheckInCrudRepository  extends JpaRepository<CheckInJapModel, UUID> {
}
