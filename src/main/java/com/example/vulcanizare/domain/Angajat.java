package com.example.vulcanizare.domain;

import lombok.Data;
import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Angajat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "informatie necesara")
    private String porecla;

    @ManyToMany(mappedBy = "angajati",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Vehicul> vehicule;
}
