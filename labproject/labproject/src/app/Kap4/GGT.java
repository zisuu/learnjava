package app.Kap4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Programm zur Ermittlung des grössten gemeinsamen Teilers (GGT) zweier Zahlen.
 *
 * @author zisuu
 */
public class GGT {

    public static void main(String[] args) throws IOException {
        // Zwei Zahlen von der Kommandozeile lesen.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie die erste Zahl ein: ");
        int zahl1 = Integer.parseInt(in.readLine());
        System.out.println("Geben Sie die zweite Zahl ein: ");
        int zahl2 = Integer.parseInt(in.readLine());
        // Den GGT berechnen
        int ggt = ggt(zahl1, zahl2);
        // Ausgeben
        System.out.println("Der grösste gemeinsame Teiler ist: " + ggt);
    }

    /**
     * Diese Methode ermittelt den GGT zweier Zahlen
     * 
     * @param zahl1 die eine Zahl
     * @param zahl2 die andere Zahl.
     * @return den GGT
     */
    public static int ggt(int zahl1, int zahl2) {
        // Prüfen, ob beide Zahlen positiv sind, sonst Fehler.
        if (zahl1 < 0 || zahl2 < 0) {
            throw new IllegalArgumentException("Beide Zahlen müssen >0 sein.");
        }
        // Prüfe, ob nicht beide Zahlen 0 sind, sonst Fehler
        if (zahl1 == 0 && zahl2 == 0)
            throw new IllegalArgumentException("Mindestens eine Zahl muss grösser 0 sein.");
        // Ist zahl1 0, dann ist zahl2 bereits das Ergebnis.
        if (zahl1 == 0)
            return zahl2;
        /**
         * Der grösste gemeinsame Teiler zweier Zahlen a und b wird wie folgt berechnet:
         * Ist a = 0, so ist b der grösste gemeinsame Teiler.
         * Andernfalls führen Sie, solange b ungleich 0 ist, die folgenden Schritte
         * durch:
         * Ist a > b, dann ziehen Sie b von a ab, um den neuen Wert von a zu berechnen.
         * Anderenfalls ziehen Sie a von b ab, um den neuen Wert von b zu berechnen.
         * Der nun in a gespeicherte Wert ist der grösste gemeinsame Teiler.
         */
        // Ist zahl1 0, dann ist zahl2 bereits das Ergebnis.
        if (zahl1 == 0) {
            return zahl2;
        }
        //Solange zahl2 nicht 0 ist, ziehe wiederholt die kleinere Zahl von der grösseren ab.
        while (zahl2 != 0) {
            if (zahl1 > zahl2) {
                zahl1 = zahl1 - zahl2;
            } else
                zahl2 = zahl2 - zahl1;

        }
        return zahl1;
    }
}
