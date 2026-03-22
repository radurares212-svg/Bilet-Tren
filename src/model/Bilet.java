package model;

import java.time.LocalDateTime;

public class Bilet {
    private Calator calator;
    private Tren tren;
    private String statieImbarcare;
    private String statieDestinatie;
    private TipRezervare tip;
    private LocalDateTime dataCumparare;
    private double pret;

    public Bilet(Calator calator, Tren tren, String statieImbarcare, String statieDestinatie,
                 TipRezervare tip, LocalDateTime dataCumparare, double pret) {
        this.calator = calator;
        this.tren = tren;
        this.statieImbarcare = statieImbarcare;
        this.statieDestinatie = statieDestinatie;
        this.tip = tip;
        this.dataCumparare = dataCumparare;
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "tren=" + tren.getNume() +
                ", ruta=" + statieImbarcare + " -> " + statieDestinatie +
                ", tip=" + tip +
                ", dataCumparare=" + dataCumparare +
                ", pret=" + pret + " RON" +
                '}';
    }
}