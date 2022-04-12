package de.kaiguenster.javaintro.ggt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Programm zur Berechnung des größten gemeinsamen Teilers (GGT) zweier Zahlen.
 * @author Kai
 */
public class GGT {

    public static void main(String[] args) throws IOException {
        //Zwei Zahlen von der Kommandozeile lesen
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie die erste Zahl ein: ");
        int zahl1 = Integer.parseInt(in.readLine());
        System.out.println("Geben Sie die zweite Zahl ein: ");
        int zahl2 = Integer.parseInt(in.readLine());
        //Den GGT berechnen
        int ggt = ggt(zahl1, zahl2);
        //Das Ergebnis ausgeben.
        System.out.println("Der größte gemeinsame Teiler ist: " + ggt);
    }

    /**
     * Berechnung des GGT
     * @param zahl1 eine Zahl
     * @param zahl2 eine weitere Zahl
     * @return den GGT
     * @throws IllegalArgumentException wenn eine der Zahlen negativ ist oder beide Zahlen 0 sind
     */
    public static int ggt(int zahl1, int zahl2) {
        //Prüfung der Argumente
        if (zahl1 < 0 || zahl2 < 0 ) throw new IllegalArgumentException("Keine negativen Zahlen erlaubt.");
        if (zahl1 == 0 && zahl2 == 0) throw new IllegalArgumentException("Mindestens eine Zahl muss größer 0 sein.");
        //Ist zahl1 0, dann ist zahl2 bereits das Ergebnis.
        if (zahl1 == 0) return zahl2;
        //Solange zahl2 nicht 0 ist, ziehe wiederholt die kleinere Zahl von der größeren ab.
        while (zahl2 != 0){
            if (zahl1 > zahl2){
                zahl1 = zahl1 - zahl2;
            } else {
                zahl2 = zahl2 - zahl1;
            }
        }
        //Sobald zahl2 0 ist ist zahl1 das Ergebnis. 
        return zahl1;
    }
    
    
}
