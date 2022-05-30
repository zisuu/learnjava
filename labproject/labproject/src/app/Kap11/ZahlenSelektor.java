package app.Kap11;

import java.util.Arrays;

/**
 * OK: Schreiben Sie ein funktionales Interface mit dem Namen ZahlenSelektor,
 * OK: dessen Methode pruefe einen int-Wert als Parameter nimmt und boolean
 * zurückgibt.
 * 
 * Schreiben Sie in ZahlenSelektor eine statische Methode findeErsteN, die einen
 * ZahlenSelektor und einen int-Wert n annimmt. Die Methode soll die ersten n
 * int-Werte
 * grösser 0 und kleiner 1.000.000 finden, für die der Selektor true zurückgibt,
 * und
 * diese als int[] zurückgeben.
 * 
 * Benutzen Sie diese Methode, um Folgendes zu finden:
 * die ersten zehn Zahlen, die durch 7 teilbar sind
 * die ersten zehn Primzahlen
 * die Zahlen von 1 bis 10
 */
public interface ZahlenSelektor {


    public static int[] findeErsteN(ZahlenSelektor selektor, int n) {
        //Parameterprüfung
        if (n < 0 || selektor == null) {
            throw new IllegalArgumentException("Selektor darf nicht null und n nicht <0 sein.");
        }
        int[] ergebnis = new int[n];
        int index = 0;
        //Prüfe Zahlen kleiner als 1.000.000, oder bis n Zahlen gefunden wurden
        for (int i = 1; i < 1000000 && index < n; i++) {
            if (selektor.pruefe(i)) {
                ergebnis[index++] = i;
            }
        }
        //Wurden weniger Zahlen gefunden als gefordert, werden sie in ein neues Array der passenden Grösse kopiert.
        if (index < ergebnis.length) {
            ergebnis = Arrays.copyOf(ergebnis, index);
        }
        return ergebnis;

    }

    /**
     * Prüft, ob die übergebene Zahl den Anforderungen dieses Selektors entspricht.
     * @param zahl, die Zahl
     * @return true wenn der Selektor sie akzeptiert, sonst false.
     */
    public boolean pruefe(int zahl);
}
