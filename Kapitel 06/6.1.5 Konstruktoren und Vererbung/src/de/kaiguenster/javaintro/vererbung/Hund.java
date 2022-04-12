package de.kaiguenster.javaintro.vererbung;

/**
 * Spezialisierung von {@link Tier} für Hunde
 *
 * @author Kai Günster
 */
public class Hund extends Tier {

    public Hund(String name, char geschlecht, int gewicht) {
        super(name, geschlecht, gewicht);
    }

}
