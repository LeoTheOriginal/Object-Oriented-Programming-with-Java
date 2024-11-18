package Armia;

import java.util.List;

public interface CzolgInterface {
    void odbierzRozkaz(Rozkaz rozkaz);
    Rozkaz ostatniRozkaz();
    List<Rozkaz> getRozkazy();
}
