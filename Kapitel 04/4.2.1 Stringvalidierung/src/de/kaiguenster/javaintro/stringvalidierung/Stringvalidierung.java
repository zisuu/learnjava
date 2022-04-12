package de.kaiguenster.javaintro.stringvalidierung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Programm zur Eingabevalidierung: es prüft, ob die eingegebe Zeichenkette eine
 * Zahl ist
 *
 * @author Kai Günster
 */
public class Stringvalidierung {

    public static void main(String[] args) throws IOException {
        //Eingabe von der Kommandozeile lesen.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Bitte geben Sie eine Zahl ein.");
        String zahl = in.readLine();
        //Die Eingabe prüfen und das Ergebnis ausgeben.
        if (validiereZahl(zahl)) {
            System.out.println("Das ist eine Zahl");
        } else {
            System.out.println("Das ist keine Zahl");
        }
    }

    /**
     * Diese Methode prüft, ob der übergebene String eine Zahl enthält. Dazu
     * wird geprüft, ob jedes Zeichen des Strings eine Ziffer ist, Sonderfälle
     * wie Gruppierungszeichen oder vorangestellte +/- werden nicht
     * berücksichtigt.
     *
     * @param zahl die zu prüfende Zeichenkette
     * @return true, wenn es sich um eine Zahl handelt, sonst false
     */
    private static boolean validiereZahl(String zahl) {
        //Die Schleife läuft von 0 bis zur Länge des Strings.
        for (int i = 0; i < zahl.length(); i++) {
            //Das Zeichen an der aktuellen Stelle wird extrahiert.
            char ziffer = zahl.charAt(i);
            //Anschließend wird geprüft, ob es sich dabei um eine Ziffer handelt. 
            if (ziffer != '0' && ziffer != '1' && ziffer != '2' && ziffer != '3' && ziffer != '4'
                    && ziffer != '5' && ziffer != '6' && ziffer != '7' && ziffer != '8' && ziffer != '9') {
                /*Wird ein Zeichen gefunden, das keine Ziffer ist, wird sofort mit einem
                 "early return" false zurückgegeben, die weiteren Zeichen werden nicht mehr geprüft.
                 */
                return false;
            }
        }
        return true;
    }

}
