package de.kaiguenster.javaintro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ein sehr nützliches Programm, das Ihnen sagen kann, welche Star-Trek-Filme sehenswert sind
 * @author Kai Günster
 */
public class StarTrek {

    public static void main(String[] args) throws IOException {
        //Eine Zahl wird von der Kommandozeile gelesen
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welchen Star Trek Film willst du anschauen?");
        int film = Integer.parseInt(reader.readLine());
        //Es wird geprüft, ob die Zahl gerade ist (ob der Rest bei Division durch zwei 0 ist).
        if (film % 2 == 0){
            //Gerade Zahl? Toller Film!
            System.out.println("Cool! Los geht's.");
        } else {
            //Ungerade Zahl? Finger weg!
            System.out.println("Nein, tu es nicht!");
        }
    }
}
