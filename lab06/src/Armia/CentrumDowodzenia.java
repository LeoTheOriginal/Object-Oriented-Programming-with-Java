package Armia;

import java.util.HashMap;
import java.util.Map;

public class CentrumDowodzenia implements CentrumDowodzeniaInterface {
    private final Map<String, CzolgInterface> czolgi = new HashMap<>();
    private int counter = 1;

    public CentrumDowodzenia() {
    }

    @Override
    public void zarejestrujCzolg(CzolgInterface czolg) {
        czolgi.put(Integer.toString(counter), czolg);
        counter++;
    }

    @Override
    public void wydajRozkaz(String nrCzolgu, Rozkaz rozkaz) {
        CzolgInterface czolg = czolgi.get(nrCzolgu);
        if (czolg != null) {
            czolg.odbierzRozkaz(rozkaz);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Do tej pory centrum dowodzenia wyslalo nastepujace rozkazy:\n");
        for (Map.Entry<String, CzolgInterface> entry : czolgi.entrySet()) {
            result.append("Czolg nr ").append(entry.getKey()).append(" otrzymal rozkazy:\n");
            CzolgInterface czolg = entry.getValue();
            for (Rozkaz rozkaz : czolg.getRozkazy()) {
                result.append(rozkaz.getKomenda()).append("\n");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
