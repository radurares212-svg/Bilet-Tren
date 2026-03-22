package model;

import java.time.LocalTime;

public class Statia {
    private String nume;
    private LocalTime oraPlecare;

    public Statia(String nume, LocalTime oraPlecare) {
        this.nume = nume;
        this.oraPlecare = oraPlecare;
    }

    public String getNume() { return nume; }
    public LocalTime getOraPlecare() { return oraPlecare; }

    @Override
    public String toString() {
        return nume + " (" + oraPlecare + ")";
    }
}