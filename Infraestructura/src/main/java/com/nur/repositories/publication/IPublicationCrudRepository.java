package com.nur.repositories.publication;

import com.nur.model.ReserveJpaModel;
import com.nur.model.UserPublicReserveJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IPublicationCrudRepository extends JpaRepository<UserPublicReserveJpaModel, UUID> {
    @Query(value = "SELECT * FROM user_public up WHERE up.userid = :userID", nativeQuery = true)
    public List<UserPublicReserveJpaModel> listByUserId(@Param("userID") UUID userID);
}
