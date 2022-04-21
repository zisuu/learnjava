package Kap4;

import java.util.Random;
import java.io.*;

/**
 * Ein einfaches Ratespiel: das Programm wählt eine zufällige Zahl aus, die der 
 * Spieler erraten soll. Nach jedem Tipp wird ausgegeben, ob die gesuchte Zahl 
 * kleiner oder grösser ist.
 * @author dave
 */
public class zahlraten {
    public static void main(String[] args) throws IOException {
        //Eine Zufallszahl im Bereich 1-100 wird ermittelt.
        Random wuerfel = new Random();
        Integer zufallsZahl = wuerfel.nextInt(100)+1;

        //Eingabe wird vorbereitet, aber es wird noch keine Zahl gelesen.
        System.out.println("## Ich habe mir eine Zahl zwischen 0 und 100 ausgedacht. Kannst du sie erraten? ##");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer rateZahl = 0;


        do {
            //In dieser Schleife werden Zahlen gelesen, und mit der gesuchten Zahl verglichen.
            System.out.println("gib einen Tipp ab: ");
            rateZahl = Integer.parseInt(reader.readLine());
            /*
            Ausgabe, ob die gesuchte Zahl kleiner oder grösser als die Eingabe ist.
            Beachten Sie, dass es keinen einfachen else-Fall gibt: wurde die richtige 
            Zahl eingegeben, wird keiner der Zweige dieses if-Statements durchlaufen!
            */
            if (zufallsZahl < rateZahl) {
                System.out.println("Falsch, meine Zahl ist kleiner!");
            } else
                System.out.println("Falsch, meine Zahl ist grösser!");

        } while (zufallsZahl != rateZahl); //die Schleife endet, wenn die Zahl erraten wurde. 
        //Die Auusgabe, dass die Zahl erraten wurde, findet nach der Schleife statt. 

        System.out.println("TARATATATAAAA - RICHTIG. Meine Zahl ist: " + zufallsZahl);
    }

}
