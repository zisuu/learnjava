package Kap3;

import java.io.*;


public class rockinROM {
    public static void main(String[] args) throws IOException {
        System.out.println("## ROCK in ROM: Dieses Tool gibt das Programm und den Preis des gewünschten Tages an ##");
        System.out.println("Bitte geben Sie den gewünschten Tag an: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String day = reader.readLine();
        System.out.println("Programm und Preis vom " + day + getProgramm(day));
    
    }

    public static String getProgramm(String day){
        String programm = null;
        switch(day){
            case "Montag":
                programm = " Headliner: Rage against the Compiler, Preis: 37.50 EUR";
                break;
            case "Dienstag":
                programm = " Headliner: if/else, Preis: 22.00 EUR";
                break;
            case "Mittwoch":
                programm = " Headliner: The Falling Cases, Preis: 17.50 EUR";
                break;
            case "Donnerstag":
                programm = " Headliner: Blinkenlichten, Preis: 21.00 EUR";
               break;
            case "Freitag":
                programm = " Headliner: Compilaz, Preis: 32.55 EUR";
                 break;
            case "Samstag":
                programm = " Headliner: Real Class, Preis: 45 EUR";
                break;
            case "Sonntag":
                programm = " Headliner: Delphi and the Oracles, Preis: 35 EUR";
                 break;
        default:
            return programm = " FEHLER - Wochentag " + day + " unbekannt";
    }
    return programm;
}
}
