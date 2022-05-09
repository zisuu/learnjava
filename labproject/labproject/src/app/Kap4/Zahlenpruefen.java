package app.Kap4;

import java.io.*;

 /**
 * Programm das den Benutzer einen String eingeben lässt, das prüft, ob dieser String eine gültige Zahl ist, 
 * und das eine entsprechende Meldung ausgibt. 
 * @author Dave
 * @version 1.0
 */
public class Zahlenpruefen {
    public static void main(String[] args) throws IOException {
        System.out.println("Bitte geben Sie den gewünschten Text ein, um zu überprüfen ob dieser Text aus gültigen Zahlen besteht: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String eingabe = reader.readLine();
        pruefeEingabe(eingabe);
    }

    public static void pruefeEingabe(String eingabe) {
        for (int i = 0; i < eingabe.length(); i++) {
            System.out.println(Character.isDigit(eingabe.charAt(i)) ? eingabe.charAt(i) + " ist eine Zahl" : eingabe.charAt(i) + " ist ein Buchstaben");
        }
    }
}
