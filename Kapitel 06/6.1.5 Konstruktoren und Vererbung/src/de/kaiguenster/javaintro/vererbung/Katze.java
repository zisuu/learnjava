package de.kaiguenster.javaintro.vererbung;

/**
 * Spezialisierung von {@link Tier} für Katzen
 *
 * @author Kai Günster
 */
public class Katze extends Tier{

    public Katze(String name, char geschlecht, int gewicht) {
        super(name, geschlecht, gewicht);
    }
}
