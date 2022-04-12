package de.kaiguenster.javaintro.fahrzeuge;

/**
 * Spezialisierung von {@link Fahrzeug} für LKWs. Ein LKW ist ein
 * {@link Transporter}.
 *
 * @author Kai Günster
 */
public class LKW extends Fahrzeug implements Motorisiert, Transporter {

    private String ladung;

    public LKW(String modell, double hoechstgeschwindigkeit, int sitze) {
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
