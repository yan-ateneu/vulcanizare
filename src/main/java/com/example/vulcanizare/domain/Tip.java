package com.example.vulcanizare.domain;

public enum Tip {
    masina("masina"), duba("duba"), camion("camion"), bicicleta("bicicleta");

    private String tip;

    public String getTip() {
        return tip;
    }

    Tip(String tip) {
        this.tip = tip;
    }
}
