package Kap6;

/**
 * Klasse TestProgramm
 * 
 * @author zisuu
 * @version 1.0
 */
public class TestProgramm {
    public static void main(String[] args) {
        testeFahrrad();
        testeLkw();
    }

    private static void testeFahrrad() {
        Fahrrad fahrrad1 = new Fahrrad("Price - AM v8", 10.0, 1);
        fahrrad1.fahreNach("Münsingen BHF", 354);
    }

    private static void testeLkw() {
        Lkw lkw1 = new Lkw("Mercedes XY", 120.0, 2);
        lkw1.fahreNach("Münsingen BHF", 354);
        lkw1.lade("Bananennen");
        lkw1.pruefeLadung();
        lkw1.entlade();
        lkw1.pruefeLadung();
    }

}
