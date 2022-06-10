package app.Kap6.Tiere;

/**
 * Klasse TierTestProgramm
 * 
* Schreiben Sie anschliessend ein Programm, das einen Dackel, einen Dobermann
* und eine Katze instanziiert, diese drei
* Felder über die Zugriffsmethoden befüllt und die Objekte auf die
* Kommandozeile ausgibt.
 * 
 * @author zisuu
 * @version 1.0
 */
public class TierTestProgramm {
    public static void main(String[] args) {
        testeDobermann();
        testeDackel();
        testeKatze();
        tierKonstruktor ();
    }

    private static void testeDackel() {
        Dackel dackel1 = new Dackel("Billy", 750, Tier.MAENNLICH);
        dackel1.print();
    }

    private static void testeDobermann() {
        Dobermann dobermann1 = new Dobermann("Frieda", 15000, Tier.WEIBLICH);
        dobermann1.print();
    }

    private static void testeKatze() {
        Katze katze1 = new Katze("Filou", 500, Tier.MAENNLICH);
        katze1.print();
    }

    private static void tierKonstruktor () {
        Tier tier1 = new Tier("Das Tier1", 10000, Tier.MAENNLICH);
        tier1.print();
    }
}
