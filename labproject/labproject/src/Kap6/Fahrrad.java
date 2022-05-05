package Kap6;

public class Fahrrad extends Fahrzeug {
    @Override
    public void setMaxGeschwindigkeit(double maxGeschwindigkeit) {
        if (maxGeschwindigkeit > 135)
            throw new IllegalArgumentException("Fahrräder haben eine maximale Höchstgeschwindigkeit von 135 km/h, das entspricht dem Geschwindigkeitsrekord auf ebener Strecke.");
        super.setMaxGeschwindigkeit(maxGeschwindigkeit);
    }

    /**
    * Konstruktor für Fahrrad
    *
    * @param markeUndModell des Fahrrads
    * @param maxGeschwindigkeit des Fahrrads, in km/h
    * @param sitzplaetze des Fahrrads
    */
    public Fahrrad(String markeUndModell, Double maxGeschwindigkeit, int sitzplaetze) {
        super(markeUndModell, maxGeschwindigkeit, sitzplaetze);
    }

}
