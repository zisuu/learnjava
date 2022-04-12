package de.kaiguenster.javaintro.fahrzeuge;

/**
 * Spezialisierung von {@link Fahrzeug} für Motorräder
 *
 * @author Kai Günster
 */
public class Motorrad extends Fahrzeug implements Motorisiert{

    public Motorrad(String modell, double hoechstgeschwindigkeit, int sitze) {
        super(modell, hoechstgeschwindigkeit, sitze);
    }
    
}
