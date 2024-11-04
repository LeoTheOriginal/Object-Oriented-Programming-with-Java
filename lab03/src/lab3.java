//Proszę zaimplementować klasę lab3string
//UWAGA! Rozwiązanie w stylu:
//String wspak(String a)
// {
//  return "kapsw eizdeb ot";
// }
// oznacza automatycznie 0 (ZERO) punktów (choćby dotyczyło TYLKO JEDNEJ metody).


/**
 *Klasa lab3string.
 *
 *@author Piotrowski Dawid
 *@version 0.1
 */
class lab3string {

    /**
     * Zwraca długość podanego wyrazu.
     *
     * @param wyraz wyraz, którego długość ma zostać obliczona
     * @return długość wyrazu
     */
    public static int dlugosc(String wyraz) {
        return wyraz.length();
    }

    /**
     * Zlicza, ile razy określona litera pojawia się w podanym wyrazie.
     *
     * @param wyraz wyraz, w którym należy zliczyć wystąpienia litery
     * @param literka litera do zliczenia
     * @return liczba wystąpień litery w wyrazie
     */
    public static int ile_razy_literka_wystepuje(String wyraz, char literka) {
        int licznik = 0;
        for (int i = 0; i < wyraz.length(); i++) {
            if (wyraz.charAt(i) == literka) {
                licznik++;
            }
        }
        return licznik;
    }

    /**
     * Sprawdza, czy dwa wyrazy są takie same.
     *
     * @param wyraz1 pierwszy wyraz
     * @param wyraz2 drugi wyraz
     * @return true, jeśli wyrazy są takie same, false w przeciwnym razie
     */
    public static boolean czy_takie_same(String wyraz1, String wyraz2) {
        return wyraz1.equals(wyraz2);
    }

    /**
     * Odwraca podany wyraz.
     *
     * @param wyraz wyraz do odwrócenia
     * @return odwrócony wyraz
     */
    public static String wspak(String wyraz) {
        StringBuilder wynik = new StringBuilder();
        for(int i = wyraz.length() - 1; i >= 0; --i) {
            wynik.append(wyraz.charAt(i));
        }
        return wynik.toString();
    }

    /**
     * Sprawdza, czy podany wyraz jest palindromem.
     *
     * @param wyraz wyraz do sprawdzenia
     * @return true, jeśli wyraz jest palindromem, false w przeciwnym razie
     */
    public static boolean czy_palindrom(String wyraz) {
        return wyraz.equals(wspak(wyraz));
    }

    /**
     * Sprawdza, czy litery w podanym wyrazie są w kolejności alfabetycznej.
     *
     * @param wyraz wyraz do sprawdzenia
     * @return true, jeśli litery są w kolejności alfabetycznej, false w przeciwnym razie
     */
    public static boolean czy_abecadlowe(String wyraz) {
        for (int i = 0; i < wyraz.length() - 2; i++) {
            if (wyraz.charAt(i) > wyraz.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Koduje podany wyraz za pomocą szyfru ROT13.
     *
     * @param wyraz wyraz do zakodowania
     * @return zakodowany wyraz
     */
    public static String rot13(String wyraz) {
        StringBuilder wynik = new StringBuilder();
        for(int i = 0; i < wyraz.length(); ++i) {
            char znak = wyraz.charAt(i);
            if (znak >= 'a' && znak <= 'z') {
                znak = (char)('a' + (znak - 'a' + 13) % 26);
            } else if (znak >= 'A' && znak <= 'Z') {
                znak = (char)('A' + (znak - 'A' + 13) % 26);
            }
            wynik.append(znak);
        }
        return wynik.toString();
    }

}


public class lab3
{
    public static void main(String[] args)
    {
        double punkty = 0.0;

        String s1 = "banan";
        String s2 = "truskawka";

        // 1 punkt
        int dlugosc = lab3string.dlugosc(s1);
        if (dlugosc == 5) punkty = punkty + 0.5;
        System.out.println("Slowo '" + s1 + "' ma " + dlugosc + " liter. (5)");

        dlugosc = lab3string.dlugosc(s2);
        if (dlugosc == 9) punkty = punkty + 0.5;
        System.out.println("Slowo '" + s2 + "' ma " + dlugosc + " liter. (9)");

        // 1 punkt

        int ile_razy = lab3string.ile_razy_literka_wystepuje(s1,'a');
        if (ile_razy == 2) punkty = punkty + 0.5;
        System.out.println("W slowie '" + s1 + "' literka 'a' pojawia sie " + ile_razy + " razy. (2)");

        ile_razy = lab3string.ile_razy_literka_wystepuje(s2,'u');
        if (ile_razy == 1) punkty = punkty + 0.5;
        System.out.println("W slowie '" + s2 + "' literka 'u' pojawia sie " + ile_razy + " raz. (1)");


        // 1 punkt

        boolean takie_same = lab3string.czy_takie_same("test1","test1");
        if (takie_same == true) punkty = punkty + 0.5;
        System.out.println("czy_takie_same(\"test1\",\"test1\") = " + takie_same);

        takie_same = lab3string.czy_takie_same("blabla","test1");
        if (takie_same == false) punkty = punkty + 0.5;
        System.out.println("czy_takie_same(\"blabla\",\"test1\") = " + takie_same);

        // 1 punkt

        String t1 = lab3string.wspak("to bedzie wspak");
        if (t1.equals("kapsw eizdeb ot") == true) punkty = punkty + 1.0;
        System.out.println("wspak(\"to bedzie wspak\") = \"" + t1 + "\" (\"kapsw eizdeb ot\")");

        // 1 punkt

        //palindrom to słowo które czytane wspak jest takie samo
        boolean palindrom = lab3string.czy_palindrom("otto");
        if (palindrom == true) punkty = punkty + 0.5;
        System.out.println("czy_plaindrom(\"otto\") = " + palindrom);

        palindrom = lab3string.czy_palindrom("kot");
        if (palindrom == false) punkty = punkty + 0.5;
        System.out.println("czy_plaindrom(\"kot\") = " + palindrom);

        // 1 punkt

        //słowo - nazwijmy je "abecadłowe" to takie w którym litery występują w kolejności alfabetycznej
        //np "abc" czy "aceh" to słowa abecadłowe a "zda" już takim słowem nie jest
        boolean abecadlowe = lab3string.czy_abecadlowe("abcdef");
        if (abecadlowe == true) punkty = punkty + 0.5;
        System.out.println("czy_abecadlowe(\"abcdef\") = " + abecadlowe);

        abecadlowe = lab3string.czy_abecadlowe("zebra");
        if (abecadlowe == false) punkty = punkty + 0.5;
        System.out.println("czy_abecadlowe(\"zebra\") = " + abecadlowe);

        //2 punkty
        // ROT13 to metoda kodowania polegająca na tym, ze przesuwamy litery o 13 do przodu w alfabecie czyli:
        // A staje się N, B przechodzi w O, i tak dalej aż do M, które przechodzi w Z, potem się to "zawija" czyli:
        // N przechodzi w A, O przechodzi w B, i tak dalej aż do Z, które przechodzi w M.
        // ponieważ w alfabecie jest 26 (bez polskich znaków!) liter to:
        // ROT13(ROT13(x)) = x
        // znaki specjalne nie zostają zmieniane
        System.out.println(lab3string.rot13("Why did the chicken cross the road?"));
        System.out.println(lab3string.rot13("Gb trg gb gur bgure fvqr!"));


        System.out.println("\nPunkty: " + punkty + " (max 6, potem dodam 2 pkt za rot13, reszta za komentarze w javadoc).");
    }
}