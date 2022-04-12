package de.kaiguenster.javaintro.zahlenraten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Ein einfaches Ratespiel: das Programm wählt eine zufällige Zahl aus, die der 
 * Spieler erraten soll. Nach jedem Tipp wird ausgegeben, ob die gesuchte Zahl 
 * kleiner oder größer ist.
 * @author Kai Günster
 */
public class Zahlenraten {
    public static void main(String[] args) throws IOException {
        //Eine Zufallszahl im Bereich 1-100 wird ermittelt.
        Random wuerfel = new Random();
        int rateMich = wuerfel.nextInt(100) + 1;
        //Eingabe wird vorbereitet, aber es wird noch keine Zahl gelesesn.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tipp = 0;
        do {
            //In dieser Schleife werden Zahlen gelesen, und mit der gesuchten Zahl verglichen.
            System.out.println("Geben Sie einen Tipp ab");
            tipp = Integer.parseInt(in.readLine());
            /*
            Ausgabe, ob die gesuchte Zahl kleiner oder größer als die Eingabe ist.
            Beachten Sie, dass es keinen einfachen else-Fall gibt: wurde die richtige 
            Zahl eingegeben, wird keiner der Zweige dieses if-Statements durchlaufen!
            */
            if (tipp > rateMich) {
                System.out.println("Das ist zu hoch");
            } else if (tipp < rateMich){
                System.out.println("Das ist zu niedrig");
            }
        } while (tipp != rateMich); //die Schleife endet, wenn die Zahl erraten wurde. 
        //Die Auusgabe, dass die Zahl erraten wurde, findet nach der Schleife statt. 
        System.out.println(tipp + " ist richtig!");
    }
}
