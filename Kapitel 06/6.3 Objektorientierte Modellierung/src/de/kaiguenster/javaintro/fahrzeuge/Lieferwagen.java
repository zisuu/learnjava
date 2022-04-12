package de.kaiguenster.javaintro.fahrzeuge;

/**
 * Spezialisierung von {@link PKW} für Lieferwagen. Ein Lieferwagen ist ein
 * {@link Transporter}.
 *
 * @author Kai Günster
 */
public class Lieferwagen extends PKW implements Transporter {

    private String ladung;

    public Lieferwagen(String modell, double hoechstgeschwindigkeit, int sitze) {
        super(modell, hoechstgeschwindigkeit, sitze);
    }

    @Override
    public void lade(String ladung) {
        this.ladung = ladung;
    }

    @Override
    public String pruefeLadung() {
        return this.ladung;
    }

}
