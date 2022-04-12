package de.kaiguenster.javaintro.vererbung;

/**
 * Spezialisierung von {@link Hund} für Dobermänner
 *
 * @author Kai Günster
 */
public class Dobermann extends Hund{

    public Dobermann(String name, char geschlecht, int gewicht) {
        super(name, geschlecht, gewicht);
    }
    
}
