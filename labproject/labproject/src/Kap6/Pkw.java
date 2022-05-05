package Kap6;

import Kap6.Fahrzeug.*;

public class Pkw extends Fahrzeug implements Motorisiert {
    /**
    * Konstruktor für PKW
    *
    * @param markeUndModell des PKW
    * @param maxGeschwindigkeit des PKW, in km/h
    * @param sitzplaetze des PKW
    */
    public Pkw(String markeUndModell, Double maxGeschwindigkeit, int sitzplaetze) {
        super(markeUndModell, maxGeschwindigkeit, sitzplaetze);
    }
}
