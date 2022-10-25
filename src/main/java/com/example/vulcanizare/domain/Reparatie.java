package com.example.vulcanizare.domain;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Reparatie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "informatie necesara")
    private String tip_reparatie;


    @ManyToMany(mappedBy = "reparatii",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Vehicul> vehicule;
}
