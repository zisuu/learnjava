package de.kaiguenster.javaintro.vererbung;

/**
 * Spezialisierung von {@link Tier} für Hunde
 *
 * @author Kai Günster
 */
public class Hund extends Tier {

    /**
     * Laut geben für Hunde.
     *
     * @return des Hundes Gebell
     */
    public String belle() {
        return "Wuff!";
    }
}
