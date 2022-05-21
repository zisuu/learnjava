package app.Kap9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Schreiben Sie eine Methode halbiere, die eine Zahl als Parameter erwartet.
 * Ist diese Zahl gerade, dann soll die Methode die Hälfte der Zahl zurückgeben.
 * Ist die Zahl ungerade, dann soll eine IllegalArgumentException geworfen
 * werden.
 * Schreiben Sie dann eine main-Methode, die so lange Zahlen vom Benutzer
 * erfragt,
 * bis eine Eingabe halbiert werden kann. Reagieren Sie auf ungerade Eingaben,
 * indem Sie die von halbiere geworfene Exception behandeln.
 * 
 **/
public class Fehlerbehandlung {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer haelfte = null;
        do {
            System.out.println("Gib eine gerade Zahl an, damit ich sie halbieren kann: ");
            try {
                haelfte = halbiere(Integer.parseInt(reader.readLine()));
                System.out.println(haelfte);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (haelfte == null);

    }

    private static int halbiere(int zahl) {
        if (zahl % 2 != 0) {
            throw new IllegalArgumentException("Diese Zahl ist ungerade! Versuche nochmals...");
        } else {
            return (zahl / 2);
        }
    }
}
