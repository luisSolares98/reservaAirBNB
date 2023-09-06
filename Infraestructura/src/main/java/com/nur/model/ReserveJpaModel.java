package com.nur.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Builder
@Table(name = "Reserve")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReserveJpaModel {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    @NotNull(message = "la fecha de ingreso no puede ser null")
    private Date dateIn;

    @Column(nullable = false)
    @NotNull(message = "la fecha de salida no puede ser null")
    private Date dateOut;

    @Column(nullable = false)
    @NotNull(message = "el estado no puede ser null")
    private String state;


}
