package app.Kap4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Programm zur Berechnung des kleinsten gemeinsamen Vielfachen (KGV) zweier
 * Zahlen
 *
 */
public class KGV {

    public static void main(String[] args) throws IOException {
        //Zwei Zahlen einlesen
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie die erste Zahl ein: ");
        int zahl1 = Integer.parseInt(in.readLine());
        System.out.println("Geben Sie die zweite Zahl ein: ");
        int zahl2 = Integer.parseInt(in.readLine());
        //Das KGV berechnen
        int kgv = kgv(zahl1, zahl2);
        //Das Ergebnis ausgeben.
        System.out.println("Das kleinste gemeinsame Vielfache ist: " + kgv);

    }

    /**
     * Methode zur Berechnung des KGV
     *
     * @param zahl1 die erste Zahl
     * @param zahl2 die zweite Zahl
     * @return das KGV der beiden Zahlen
     * @throws IllegalArgumentException wenn nicht beide Zahlen >0 sind.
     * @throws ArithmeticException wenn bei der Berechnung ein Überlauf
     * eintritt.
     */
    public static int kgv(int zahl1, int zahl2) {
        //Parameter prüfen
        if (zahl1 <= 0 || zahl2 <= 0) {
            throw new IllegalArgumentException("Beide Zahlen müssen >0 sein.");
        }
        //Sicherstellen, dass zahl1 die grössere ist.
        if (zahl1 < zahl2) {
            int temp = zahl1;
            zahl1 = zahl2;
            zahl2 = temp;
        }
        int multiplikator = 1;
        //Vielfache der grösseren Zahl in einer Schleife testen, ob sie auch Vielfache der kleineren Zahl sind.
        while ((zahl1 * multiplikator) % zahl2 != 0) {
            //Prüfen, ob bei der nächsten Multiplikation ein Überlauf eintreten würde. Falls ja: Fehler!
            if (Integer.MAX_VALUE - zahl1 < zahl1 * multiplikator) {
                throw new ArithmeticException("KGV ist grösser als Wertebereich.");
            }
            multiplikator++;
        }
        return zahl1 * multiplikator;
    }

}
