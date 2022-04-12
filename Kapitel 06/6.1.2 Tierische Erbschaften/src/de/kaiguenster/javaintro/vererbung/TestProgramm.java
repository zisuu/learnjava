package de.kaiguenster.javaintro.vererbung;

/**
 * Testprogramm für die verschiedenen Tier-Klassen.
 * @author Kai Günster
 */
public class TestProgramm {
    public static void main(String[] args){
        testeDobermann();
        testeDackel();
        testeKatze();
    }

    private static void testeDobermann() {
        Dobermann dobermann = new Dobermann();
        dobermann.setName("Heinrich");
        dobermann.setGeschlecht(Tier.MAENNLICH);
        dobermann.setGewicht(12);
        System.out.println(dobermann);
    }
    
    private static void testeDackel() {
        Dackel dackel = new Dackel();
        dackel.setName("Wurstfriede");
        dackel.setGeschlecht(Tier.WEIBLICH);
        dackel.setGewicht(4);
        System.out.println(dackel);
    }
    
    private static void testeKatze() {
        Katze katze = new Katze();
        katze.setName("Pixie");
        katze.setGeschlecht(Tier.WEIBLICH);
        katze.setGewicht(3);
        System.out.println(katze);
    }
}
