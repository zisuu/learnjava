package Kap3;

import java.io.*;

public class rockinROM2 {
    public static void main(String[] args) throws IOException {
        System.out.println("## ROCK in ROM: Dieses Tool gibt das Programm und den Preis des gewünschten Tages an ##");
        System.out.println("Bitte geben Sie den gewünschten Anreisetag an: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String day = reader.readLine();
        System.out.println(getProgramm(day));


    }

    public static String getProgramm(String day) {
        String headliner = "";
        double price = 0;
        double priceSum = 0;

        switch (day) {
            // skip Montag bis Freitag
            case "Samstag":
                price = 45.0;
                System.out.println("Real Class" + ", Preis: " + price);
                priceSum = priceSum + price;
            case "Sonntag":
                price = 35.0;
                System.out.println("Delphi and the Oracles" + ", Preis: " + price);
                priceSum = priceSum + price;
                break;
            default:
                System.out.println(" FEHLER - Wochentag " + day + " unbekannt");
                System.exit(1);
        }
        return "Gesamt Preis: " + priceSum;
    }
}
