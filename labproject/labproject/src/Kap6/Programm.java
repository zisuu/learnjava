package Kap6;


/**
 * Klasse Programm
 * 
* Schreiben Sie anschließend ein Programm, das einen Dackel, einen Dobermann
* und eine Katze instanziiert, diese drei
* Felder über die Zugriffsmethoden befüllt und die Objekte auf die
* Kommandozeile ausgibt.
 * 
 * @author zisuu
 * @version 1.0
 */
public class Programm {
    public static void main(String[] args) {
        testeDobermann();
        testeDackel();
        testeKatze();
    }

    private static void testeDackel() {
        Dackel dackel1 = new Dackel();
        dackel1.setName("Billy");
        dackel1.setGewichtGr(750);
        dackel1.setGeschlecht(Tier.MAENNLICH);
        dackel1.print();
    }

    private static void testeDobermann() {
        Dobermann dobermann1 = new Dobermann();
        dobermann1.setName("Frieda");
        dobermann1.setGewichtGr(15000);
        dobermann1.setGeschlecht(Tier.WEIBLICH);
        dobermann1.print();
    }

    private static void testeKatze() {
        Katze katze1 = new Katze();
        katze1.setName("Filou");
        katze1.setGewichtGr(500);
        katze1.setGeschlecht(Tier.MAENNLICH);
        katze1.print();
    }
}
