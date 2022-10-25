package com.example.vulcanizare.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
public class DetaliiVehicul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "informatie necesara")
    protected String marca;

    protected String model;

    @NotNull(message = "informatie necesara")
    private int nr_roti;

    @OneToOne
    private Vehicul vehicul;
}
