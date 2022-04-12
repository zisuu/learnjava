package de.kaiguenster.javaintro.rockimrom;

import java.io.*;

/**
 * Programm, um Ticketpreis und Showprogramm für das Rock Im ROM-Festival zu berechnen.
 * Diese Version fragt den Anreisetag ab, und nimmt an, dass der Besucher bis zum Ende bleibt.
 * @author Kai Günster
 */
public class RockImROM {

    public static void main(String[] args) throws IOException {
        //Es wird ein Wochentag von der Kommandozeile gelesen.
        System.out.println("An welchem Tag kommst du?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String wochentag = in.readLine();
        /*Variablen werden deklariert, Werte werden ihnen erst unten zugewiesen.
        Headliner wird nun mit einem Leerstring initialisiert (im Gegensatz 
        zur vorigen Version des Programms), weil im switch-Block weitere Werte 
        angehangen werden sollen.
        */
        String headliner = "";
        double preis = 0;
        //Mit dem eingegebenen Wochentag wird geswitcht
        switch(wochentag){
            case "Montag": 
                /*Headliner und Preis werden nicht mehr den entsprechenden Variablen
                zugewiesen, sondern konkateniert bzw. addiert, um bereits vorhandene
                Werte zu erhalten. 
                */
                headliner += "Rage against the Compiler\n"; 
                preis += 37.5;
                //es gibt kein break mehr, die Fälle "fallen durch" und alle weiteren Tage werden ebenfalls ausgeführt.
            case "Dienstag": 
                headliner += "if/else\n"; 
                preis += 22;
            case "Mittwoch": 
                headliner += "The Falling Cases\n"; 
                preis += 17.50;
            case "Donnerstag": 
                headliner += "Blinkenlichten\n"; 
                preis += 21;
            case "Freitag": 
                headliner += "Compilaz\n"; 
                preis += 32.55;
            case "Samstag": 
                headliner += "Real Class\n"; 
                preis += 45;
            case "Sonntag": 
                headliner += "Delphi and the Oracles\n"; 
                preis += 35;
                break;
            default:
                /*Falls kein gültiger Wochentag eingegeben wurde, wird der 
                  default-Block ausgeführt. Er gibt eine entsprechende Fehlermeldung aus. */
                System.out.println("Den Tag kenn ich nicht: " + wochentag);
                System.exit(1);
        }
        //Gesammelte Headliner und Gesamtpreis werden ausgegeben.
        System.out.println("Die Headliner sind:\n" + headliner);
        System.out.println("Kartenpreis: " + preis + "€");
    }

}

