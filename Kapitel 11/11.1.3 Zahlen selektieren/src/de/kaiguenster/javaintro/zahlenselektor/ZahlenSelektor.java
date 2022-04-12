package de.kaiguenster.javaintro.zahlenselektor;

import java.util.Arrays;

/**
 * Funktionales Inferface, um int-Werte zu filtern.
 *
 * @author Kai Günster
 */
@FunctionalInterface
public interface ZahlenSelektor {

    /**
     * Findet die ersten n positiven Zahlen kleiner 1.000.000, die von einem Selektor akzeptiert
     * werden-
     *
     * @param selektor der Selektor
     * @param n Anzahl zu findender Zahlen
     * @return alle gefundenen Zahlen
     * @throws IllegalArgumentException wenn kein Selektor übergeben wurde oder
     * n negativ ist.
     */
    public static int[] findeErsteN(ZahlenSelektor selektor, int n) {
        //Parameterprüfung
        if (n < 0 || selektor == null) {
            throw new IllegalArgumentException("Selektor darf nicht null und n nicht <0 sein.");
        }
        int[] ergebnis = new int[n];
        int index = 0;
        //Prüfe Zahlen kleiner als 1.000.000, oder bis n Zahlen gefunden wurden
        for (int i = 1; i <= 1000000 && index < n; i++) {
            if (selektor.pruefe(i)) {
                //Wenn der Selektor die Zahl akzeptiert, hänge sie am Ende des Arrays an
                ergebnis[index++] = i;
            }
        }
        //Wurden weniger Zahlen gefunden als gefordert, werden sie in ein neues Array der passenden Größe kopiert.
        if (index < ergebnis.length) {
            ergebnis = Arrays.copyOf(ergebnis, index);
        }
        return ergebnis;
    }

    /**
     * Prüft die übergebene Zahl, ob sie den Anforderungen dieses Selektors
     * entspricht.
     *
     * @param zahl die Zahl
     * @return true wenn der Selektor sie akzeptiert, sonst false.
     */
    public boolean pruefe(int zahl);
}
