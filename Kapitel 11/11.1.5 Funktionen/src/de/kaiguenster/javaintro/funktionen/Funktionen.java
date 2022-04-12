package de.kaiguenster.javaintro.funktionen;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

/**
 * Hilfsklasse um ein int[] durch eine übergebene Funktion in ein neues int[]
 * umzusetzen.
 *
 * @author Kai Günster
 */
public class Funktionen {

    /**
     * Wendet eine Funktion auf jedes Element´eines int[] an und erzeugt ein
     * neues int[], so dass ausgabe[i] = f(eingabe[i]).
     *
     * @param eingabe das Eingabe-Array
     * @param rechenvorschrift die anzuwendende Funktion
     * @return das Array von Ergebnissen
     * @throws IllegalArgumentException wenn einer der Parameter null ist.
     */
    public static int[] berechne(int[] eingabe, IntUnaryOperator rechenvorschrift) {
        if (eingabe == null || rechenvorschrift == null) {
            throw new IllegalArgumentException("Keine null-Werte erlaubt");
        }
        int[] ausgabe = new int[eingabe.length];
        for (int i = 0; i < eingabe.length; i++) {
            //Wende die Rechenvorschrift auf jede Eingabezahl an.
            ausgabe[i] = rechenvorschrift.applyAsInt(eingabe[i]);
        }
        return ausgabe;
    }

}
