package Kap6;

import Kap6.Fahrzeug.Motorisiert;

public class Motorrad extends Fahrzeug implements Motorisiert {
    /**
    * Konstruktor für Motorrad
    *
    * @param markeUndModell des Motorrads
    * @param maxGeschwindigkeit des Motorrads, in km/h
    * @param sitzplaetze des Motorrads
    */
    public Motorrad(String markeUndModell, Double maxGeschwindigkeit, int sitzplaetze) {
        super(markeUndModell, maxGeschwindigkeit, sitzplaetze);
    }
}
