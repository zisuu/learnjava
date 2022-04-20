package Kap3;

import java.io.*;

public class rockinROM {
    public static void main(String[] args) throws IOException {
        System.out.println("## ROCK in ROM: Dieses Tool gibt das Programm und den Preis des gewünschten Tages an ##");
        System.out.println("Bitte geben Sie den gewünschten Tag an: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String day = reader.readLine();
        System.out.println(getProgramm(day));


    }

    public static String getProgramm(String day) {
        String headliner = "";
        double price = 0;
        switch (day) {
            case "Montag":
                headliner = "Rage against the Compiler";
                price = 37.50;
                break;
            case "Dienstag":
                headliner = "if/else";
                price = 22.0;
                break;
            case "Mittwoch":
                headliner = "The Falling Cases";
                price = 17.50;
                break;
            case "Donnerstag":
                headliner = "Blinkenlichten";
                price = 21.0;
                break;
            case "Freitag":
                headliner = "Compilaz";
                price = 32.55;
                break;
            case "Samstag":
                headliner = "Real Class";
                price = 45.0;
                break;
            case "Sonntag":
                headliner = "Delphi and the Oracles";
                price = 35.0;
                break;
            default:
                System.out.println(" FEHLER - Wochentag " + day + " unbekannt");
                System.exit(1);
        }
        return day + " Headliner: " + headliner + " Preis: " + price;
    }
}
