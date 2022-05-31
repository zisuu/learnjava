package app.Kap11;

import java.util.function.IntUnaryOperator;

/**
 * Schreiben Sie eine Methode, die mathematische Funktionen auf int[]-Arrays
 * anwendet.
 * Das heißt, Ihre Methode soll ein int[] und eine Rechenvorschrift als
 * Parameter annehmen
 * und ein Array zurückgeben, das die Ergebnisse der Rechenvorschrift angewendet
 * auf die
 * Elemente des übergebenen Arrays enthält.
 */
public interface Rechenvorschrift {
    /**
     * 
     * @param operator definiert wie die Zahlen verarbeitet werden sollen
     * @param eingabe die Zahlen die verarbeitet werden sollen
     * @return ausgabe als int[]
     */
    public static int[] findeErgebnisse(int[] eingabe, IntUnaryOperator operator) {
        // Parameterprüfung
        if (operator == null || eingabe.length < 1) {
            throw new IllegalArgumentException("Operator darf nicht null und eingabe muss mindestens eine Zahl enthalten.");
        }
        // Erstelle das ausgabe int Array in der richtigen Länge
        int[] ausgabe = new int[eingabe.length];
        // für jeden Wert im Eingabe Array wende den Operator an und schreibe das ergebnis ins ausgabe Array
        for (int i = 0; i < eingabe.length; i++) {
            ausgabe[i] = operator.applyAsInt(eingabe[i]); // den ersten Wert des Arrays schreiben
        }
        return ausgabe;
    }
}
