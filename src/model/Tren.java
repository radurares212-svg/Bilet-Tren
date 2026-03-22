package model;

import java.util.List;

public class Tren {
    private String nume;
    private List<Statia> statii;

    public Tren(String nume, List<Statia> statii) {
        this.nume = nume;
        this.statii = statii;
    }

    public String getNume() { return nume; }
    public List<Statia> getStatii() { return statii; }

    @Override
    public String toString() {
        return "Tren " + nume;
    }
}