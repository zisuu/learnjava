package Kap6;

/**
 * Spezialisierung von {@link Fahrzeug} für Fahrrad
 *
 */
public class Fahrrad extends Fahrzeug {

    public Fahrrad(String markeUndModell, Double maxGeschwindigkeit, int sitzplaetze) {
        super(markeUndModell, maxGeschwindigkeit, sitzplaetze);
    }

    /**
     * Setter für Attribut maxGeschwindigkeit
     *
     * @param maxGeschwindigkeit die neue Höchstgeschwindigkeit in km/h
     * @throws IllegalArgumentException wenn Höchstgeschwindigkeit nicht
     *                                  zwischen 0 und 135 km/h
     */
    @Override
    public void setMaxGeschwindigkeit(double maxGeschwindigkeit) {
        if (maxGeschwindigkeit > 135) {
            throw new IllegalArgumentException(
                    "Fahrräder haben eine maximale Höchstgeschwindigkeit von 135 km/h, das entspricht dem Geschwindigkeitsrekord auf ebener Strecke.");
        }
        super.setMaxGeschwindigkeit(maxGeschwindigkeit);
    }

}
