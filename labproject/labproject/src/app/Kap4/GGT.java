package app.Kap4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Programm zur Ermittlung des größten gemeinsamen Teilers (GGT) zweier Zahlen.
 *
 * @author Kai Günster
 */
public class GGT {

    public static void main(String[] args) throws IOException {
        //Zwei Zahlen von der Kommandozeile lesen.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie die erste Zahl ein: ");
        int zahl1 = Integer.parseInt(in.readLine());
        System.out.println("Geben Sie die zweite Zahl ein: ");
        int zahl2 = Integer.parseInt(in.readLine());
        //Den GGT berechnen
        int ggt = ggt(zahl1, zahl2);
        //Ausgeben
        System.out.println("Der größte gemeinsame Teiler ist: " + ggt);
    }

    /**
     * Diese Methode ermittelt den GGT zweier Zahlen
     * @param zahl1 die eine Zahl
     * @param zahl2 die andere Zahl.
     * @return den GGT
     */
    public static int ggt(int zahl1, int zahl2) {
        //Prüfen, ob beide Zahlen positiv sind, sonst Fehler.
        if (zahl1 <= 0 || zahl2 <= 0) {
            throw new IllegalArgumentException("Beide Zahlen müssen >0 sein.");
        }
        /*
        Der GGT kann nicht größer sein als die kleinere der beiden Zahlen. Es werden, 
        angefangen mit der kleineren Zahl, Zahlen absteigend geprüft, bis ein 
        gemeinsamer Teiler gefunden wurde. Dieser muss dann der GGT sein, denn gäbe
        es einen größeren Teiler, wäre dieser vorher schon gefunden worden. Die 
        Schleife endet spätestens bei 1.
        */
        int kandidat = zahl1 < zahl2 ? zahl1 : zahl2;
        while (zahl1 % kandidat != 0 || zahl2 % kandidat != 0) {
            kandidat--;
        }
        return kandidat;
    }

}
