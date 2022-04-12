package de.kaiguenster.javaintro.pythagoras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Programm zur Berechnung der Hypotenuse nach dem Satz des Pythagoras.
 *
 * @author Kai Günster
 */
public class Pythagoras {

    public static void main(String[] args) throws IOException {
        //Die Länge der beiden Katheten vom Benutzer abfragen
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie die Länge von Kathete a ein: ");
        double katheteA = Double.parseDouble(reader.readLine());
        System.out.println("Geben Sie die Länge von Kathete b ein: ");
        double katheteB = Double.parseDouble(reader.readLine());
        //Die Hypotenuse berechnen
        double hypotenuse = berechneHypotenuse(katheteA, katheteB);
        //Das Ergebnis ausgeben
        System.out.println("Länge der Hypotenuse: " + hypotenuse);

    }

    /**
     * Berechnet die Länge der Hypotenuse aus den Längen der Katheten nach Pythagoras: a² + b² = c².
     *
     * @param katheteA Länge der Kathete a
     * @param katheteB Länge der Kathete b
     * @return Länge der Hypotenuse c
     * @throws IllegalArgumentException wenn eine der Katheten <= 0
     */
    public static double berechneHypotenuse(double katheteA, double katheteB) {
        //Argumente prüfen
        if (katheteA <= 0 || katheteB <= 0) {
            throw new IllegalArgumentException("Beide Katheten müssen Längen > 0 haben.");
        }
        //Beide Katheten quadrieren
        double aQuadrat = Math.pow(katheteA, 2);
        double bQuadrat = Math.pow(katheteB, 2);
        //Die Wurzel aus der Summe ziehen.
        return Math.sqrt(aQuadrat + bQuadrat);
    }

}
