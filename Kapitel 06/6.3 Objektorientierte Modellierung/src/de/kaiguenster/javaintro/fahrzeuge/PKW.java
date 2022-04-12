package de.kaiguenster.javaintro.fahrzeuge;

/**
 * Spezialisierung von {@link Fahrzeug} für PKWs
 *
 * @author Kai Günster
 */
public class PKW extends Fahrzeug implements Motorisiert {

    public PKW(String modell, double hoechstgeschwindigkeit, int sitze) {
        super(modell, hoechstgeschwindigkeit, sitze);
    }
}
