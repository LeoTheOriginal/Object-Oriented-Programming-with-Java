package Armia;

import java.util.ArrayList;
import java.util.List;

public class Czolg implements CzolgInterface {
    private Rozkaz ostatniRozkaz;
    private final List<Rozkaz> rozkazy = new ArrayList<>();

    @Override
    public void odbierzRozkaz(Rozkaz rozkaz) {
        rozkazy.add(rozkaz);
        this.ostatniRozkaz = rozkaz;
    }

    @Override
    public Rozkaz ostatniRozkaz() {
        return new Rozkaz("Ostatni rozkaz do mnie: " + this.ostatniRozkaz.getKomenda());
    }

    @Override
    public List<Rozkaz> getRozkazy() {
        return this.rozkazy;
    }
}
