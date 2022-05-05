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
    }
    private static void testeFahrrad() {
        Fahrrad fahrrad1 = new Fahrrad("Price - AM v8", 10.0, 1);
        fahrrad1.print();
        fahrrad1.fahreNach("Münsingen BHF", 354);
    }
}
