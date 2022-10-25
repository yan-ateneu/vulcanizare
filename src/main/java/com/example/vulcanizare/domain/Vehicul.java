package com.example.vulcanizare.domain;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Vehicul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String nr_matriculare;

    @Enumerated(value = EnumType.STRING)
    private Tip tip;

    @OneToOne(mappedBy = "vehicul",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private DetaliiVehicul detaliiVehicul;

    @ManyToOne
    protected Client proprietar;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "vehicul_reparatie",
            joinColumns = @JoinColumn(name = "vehicul_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "reparatie_id",
                    referencedColumnName = "id"))
    protected List<Reparatie> reparatii;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "vehicul_angajat",
            joinColumns = @JoinColumn(name = "vehicul_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "angajat_id",
                    referencedColumnName = "id"))
    protected List<Angajat> angajati;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNr_matriculare() {
        return nr_matriculare;
    }

    public void setNr_matriculare(String nr_matriculare) {
        this.nr_matriculare = nr_matriculare;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public DetaliiVehicul getDetaliiVehicul() {
        return detaliiVehicul;
    }

    public void setDetaliiVehicul(DetaliiVehicul detaliiVehicul) {
        this.detaliiVehicul = detaliiVehicul;
    }

    public Client getProprietar() {
        return proprietar;
    }

    public void setProprietar(Client proprietar) {
        this.proprietar = proprietar;
    }

    public List<Reparatie> getReparatii() {
        return reparatii;
    }

    public void setReparatii(List<Reparatie> reparatii) {
        this.reparatii = reparatii;
    }

    public List<Angajat> getAngajati() {
        return angajati;
    }

    public void setAngajati(List<Angajat> angajati) {
        this.angajati = angajati;
    }
}
