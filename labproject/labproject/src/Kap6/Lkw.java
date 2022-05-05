package Kap6;

import Kap6.Fahrzeug.Motorisiert;
import Kap6.Fahrzeug.Transporter;

public class Lkw extends Fahrzeug implements Motorisiert, Transporter {
    /**
    * Konstruktor für LKW
    *
    * @param markeUndModell des LKW
    * @param maxGeschwindigkeit des LKW, in km/h
    * @param sitzplaetze des LKW
    */
    public Lkw(String markeUndModell, Double maxGeschwindigkeit, int sitzplaetze) {
        super(markeUndModell, maxGeschwindigkeit, sitzplaetze);
    }
}
