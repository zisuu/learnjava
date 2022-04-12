package de.kaiguenster.javaintro.fahrzeuge;

/**
 * Spezialisierung von {@link Fahrzeug} für Fahrräder
 *
 * @author Kai
 */
public class Fahrrad extends Fahrzeug {

    public Fahrrad(String modell, double hoechstgeschwindigkeit, int sitze) {
        super(modell, hoechstgeschwindigkeit, sitze);
    }

    /**
     * Setter für das Attribut Höchstgeschwindigkeit
     *
     * @param hoechstgeschwindigkeit die neue Höchstgeschwindigkeit in km/h
     * @throws IllegalArgumentException wenn Höchstgeschwindigkeit nicht
     * zwischen 0 und 135 km/h
     */
    @Override
    public void setHoechstgeschwindigkeit(double hoechstgeschwindigkeit) {
        if (hoechstgeschwindigkeit > 135) {
            throw new IllegalArgumentException("Geschwindigkeit für ein Fahrrad darf höchstens 135 km/h sein.");
        }
        super.setHoechstgeschwindigkeit(hoechstgeschwindigkeit);
    }

}
