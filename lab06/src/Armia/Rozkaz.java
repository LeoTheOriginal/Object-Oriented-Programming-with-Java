package Armia;

public class Rozkaz {
    private final String tresc;

    public Rozkaz(String tresc) {
        this.tresc = tresc;
    }

    public String getKomenda() {
        return this.tresc;
    }

    @Override
    public String toString() {
        return tresc;
    }
}
