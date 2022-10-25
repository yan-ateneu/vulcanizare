package com.example.vulcanizare.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class DetaliiClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nr_telefon;

    private String adresa;

    @OneToOne
    private Client client;
}
