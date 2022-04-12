package de.kaiguenster.javaintro.vererbung;

/**
 * Spezialisierung von {@link Hund} für Chihuahuas.
 *
 * @author Kai Günster
 */
public class Chihuaha extends Hund {

    /**
     * Laut geben für Chihuahuas.
     *
     * @return das ganz eigene Gebell kleiner Hunde
     */
    @Override
    public String belle() {
        return "Yip! Yip! Yip!";
    }

}
