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
        Fahrrad fahrrad1 = new Fahrrad();
        fahrrad1.setMaxGeschwindigkeit(30);
        fahrrad1.setSitzplaetze(1);
        fahrrad1.setMarkeUndModell("Price - AM 8.0");
        fahrrad1.print();
        fahrrad1.fahreNach("Münsingen BHF", 30);
    }
}
