package service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import model.*;

public class ServiciuBilete {

    public boolean esteRutaValida(Tren tren, String deLa, String panaLa) {
        List<Statia> statii = tren.getStatii();
        int idxStart = -1, idxEnd = -1;

        for (int i = 0; i < statii.size(); i++) {
            if (statii.get(i).getNume().equalsIgnoreCase(deLa)) idxStart = i;
            if (statii.get(i).getNume().equalsIgnoreCase(panaLa)) idxEnd = i;
        }
        return idxStart != -1 && idxEnd != -1 && idxStart < idxEnd;
    }

    public boolean poateFiCumparat(Tren tren, String statiePlecare) {
        Statia statia = tren.getStatii().stream()
                .filter(s -> s.getNume().equalsIgnoreCase(statiePlecare))
                .findFirst().orElse(null);

        if (statia == null) return false;

        LocalDateTime acum = LocalDateTime.now();
        LocalDateTime oraPlecare = LocalDateTime.of(acum.toLocalDate(), statia.getOraPlecare());

        long minute = ChronoUnit.MINUTES.between(acum, oraPlecare);
        return minute >= 5 && minute <= 48 * 60;
    }

    public Bilet cumparaBilet(Calator calator, Tren tren, String deLa, String panaLa, TipRezervare tip) {
        if (!esteRutaValida(tren, deLa, panaLa)) throw new IllegalArgumentException("Ruta invalida");
        if (!poateFiCumparat(tren, deLa)) throw new IllegalStateException("Timp insuficient (5min-48h)");

        int indexStart = -1, indexEnd = -1;
        for (int i = 0; i < tren.getStatii().size(); i++) {
            if (tren.getStatii().get(i).getNume().equalsIgnoreCase(deLa)) indexStart = i;
            if (tren.getStatii().get(i).getNume().equalsIgnoreCase(panaLa)) indexEnd = i;
        }

        double pret = (indexEnd - indexStart) * 10.0;
        if (tip == TipRezervare.FARA_LOC) pret *= 0.9;

        Bilet bilet = new Bilet(calator, tren, deLa, panaLa, tip, LocalDateTime.now(), pret);
        calator.adaugaBilet(bilet);
        return bilet;
    }
}