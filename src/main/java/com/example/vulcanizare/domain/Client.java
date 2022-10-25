package com.example.vulcanizare.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "informatie necesara")
    private String nume;

    private String prenume;

    @OneToOne(mappedBy = "client",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private DetaliiClient detalii_client;

    @OneToMany(mappedBy = "proprietar", cascade = CascadeType.ALL)
    private List<Vehicul> vehicule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public DetaliiClient getDetalii_client() {
        return detalii_client;
    }

    public void setDetalii_client(DetaliiClient detalii_client) {
        this.detalii_client = detalii_client;
    }

    public List<Vehicul> getVehicule() {
        return vehicule;
    }

    public void setVehicule(List<Vehicul> vehicule) {
        this.vehicule = vehicule;
    }
}
