package service;

import java.util.ArrayList;
import java.util.List;
import model.Tren;

public class ServiciuTren {
    private List<Tren> trenuri = new ArrayList<>();

    public void adaugaTren(Tren tren) {
        trenuri.add(tren);
    }

    public List<Tren> getTrenuri() {
        return trenuri;
    }

    // Metodă nouă pentru a căuta trenul în listă
    public Tren gasesteTrenDupaNume(String nume) {
        return trenuri.stream()
                .filter(t -> t.getNume().equalsIgnoreCase(nume))
                .findFirst()
                .orElse(null);
    }
}