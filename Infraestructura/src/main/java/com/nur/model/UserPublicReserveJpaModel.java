package com.nur.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "UserPublic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserPublicReserveJpaModel {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    @NotNull(message = "el publishID no puede ser null")
    private UUID publishID;

    @Column(nullable = false)
    @NotNull(message = "el reserveID no puede ser null")
    private UUID reserveID;

    @Column(nullable = false)
    @NotNull(message = "el userID no puede ser null")
    private UUID userID;

    @Column(nullable = false)
    @NotNull(message = "el amount no puede ser null")
    private BigDecimal amount;
}
