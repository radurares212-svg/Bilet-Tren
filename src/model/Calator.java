package model;

import java.util.ArrayList;
import java.util.List;

public class Calator {
    private String nume;
    private List<Bilet> bilete;

    public Calator(String nume) {
        this.nume = nume;
        this.bilete = new ArrayList<>();
    }

    public void adaugaBilet(Bilet bilet) {
        bilete.add(bilet);
    }

    public String getNume() { return nume; }
}