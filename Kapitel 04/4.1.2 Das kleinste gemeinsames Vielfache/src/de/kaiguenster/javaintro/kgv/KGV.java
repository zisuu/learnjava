package de.kaiguenster.javaintro.kgv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ein Programm, dass zwei Zahlen von der Kommandozeile einliest und deren
 * kleinestes gemeinsames Vielfaches berechnet.
 *
 * @author Kai Günster
 */
public class KGV {

    public static void main(String[] args) throws IOException {
        //Zwei Zahlen von der Kommandozeile lesen
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
     * Diese Methode berechnet das KGV (kleineste gemeinsame Vielfache) zweier Ganzzahlen.
     * @param zahl1 die erste Zahl
     * @param zahl2 die zweite Zahl
     * @return das KGV
     */
    private static int kgv(int zahl1, int zahl2) {
        //Prüfen, ob beie Zahlen positiv sind. Falls nicht: Fehler.
        if (zahl1 <= 0 || zahl2 <= 0) {
            throw new IllegalArgumentException("Beide Zahlen müssen >0 sein.");
        }
        /*Sicherstellen, dass zahl1 den größeren Wert hat. 
        Das ist für die Funktion des Algorithmus nicht nötig, sorgt aber dafür, 
        dass weniger Zahlen ausprobiert werden müssen.
        */
        if (zahl1 < zahl2) {
            int temp = zahl1;
            zahl1 = zahl2;
            zahl2 = temp;
        }
        /*Es gibt schnellere Algorithmen, um das KGV zu berechnen, aber dieser 
        ist leicht verständlich: es werden Vielfache von zahl1 getestet, ob sie 
        ohne Rest durch zahl2 teilbar sind. Die erste Zahl, für die das zutrifft, 
        ist das KGV. (Es kann zu Überläufen kommen, aber dieser Fehlerfall soll 
        hier noch ignoriert werden.)
        */
        int multiplikator = 1;
        while ((zahl1 * multiplikator) % zahl2 != 0) {
            multiplikator++;
        }
        return zahl1 * multiplikator;
    }

}
