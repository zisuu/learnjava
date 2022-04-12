package de.kaiguenster.javaintro.rockimrom;

import java.io.*;

/**
 * Programm, um Ticketpreis und Showprogramm für das Rock Im ROM-Festival zu berechnen.
 * Diese Version fragt nur den Wochentag ab, und nimmt an, dass der Besucher nur für einen Tag kommt.
 * @author Kai Günster
 */
public class RockImROM {

    public static void main(String[] args) throws IOException {
        //Es wird ein Wochentag von der Kommandozeile gelesen.
        System.out.println("An welchem Tag kommst du?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String wochentag = in.readLine();
        //Variablen werden deklariert, Werte werden ihnen erst unten zugewiesen.
        String headliner = null;
        double preis = 0;
        //Mit dem eingegebenen Wochentag wird geswitcht, und dann genau einer der case-Blöcke ausgeführt
        switch(wochentag){
            case "Montag": 
                //Headliner und Preis werden gesetzt
                headliner = "Rage against the Compiler"; 
                preis = 37.5;
                //Der switch-Block wird abgebrochen, die Ausführung wird nach seiner schließenden Klammer fortgesetzt.
                break;
            case "Dienstag": 
                headliner = "if/else"; 
                preis = 22;
                break;
            case "Mittwoch": 
                headliner = "The Falling Cases"; 
                preis = 17.50;
                break;
            case "Donnerstag": 
                headliner = "Blinkenlichten"; 
                preis = 21;
                break;
            case "Freitag": 
                headliner = "Compilaz"; 
                preis = 32.55;
                break;
            case "Samstag": 
                headliner = "Real Class"; 
                preis = 45;
                break;
            case "Sonntag": 
                headliner = "Delphi and the Oracles"; 
                preis = 35;
                break;
            default:
                /*Falls kein gültiger Wochentag eingegeben wurde, wird der 
                  default-Block ausgeführt. Er gibt eine entsprechende Fehlermeldung aus. */
                System.out.println("Den Tag kenn ich nicht: " + wochentag);
                System.exit(1);
        }
        //Headliner und Preis werden ausgegeben.
        System.out.println("Der Headliner am " + wochentag + " ist " + headliner);
        System.out.println("Kartenpreis: " + preis + "€");
    }
    
}
