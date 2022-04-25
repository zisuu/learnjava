package Kap3;

import java.io.*;

public class RockinROM2 {
    public static void main(String[] args) throws IOException {
        System.out.println("## ROCK in ROM: Dieses Tool gibt das Programm und den Preis des gewünschten Tages an ##");
        System.out.println("Bitte geben Sie den gewünschten Anreisetag an: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String day = reader.readLine();
        System.out.println(getProgramm(day));


    }

    public static String getProgramm(String day) {
        double price = 0;
        double priceSum = 0;

        switch (day) {
            case "Montag":
                price = 37.50;
                System.out.println("Rage against the Compiler" + ", Preis: " + price);
                priceSum = priceSum + price;
            case "Dienstag":
                price = 22.0;
                System.out.println("if/else" + ", Preis: " + price);
                priceSum = priceSum + price;
            case "Mittwoch":
                price = 17.50;
                System.out.println("The Falling Cases" + ", Preis: " + price);
                priceSum = priceSum + price;
            case "Donnerstag":
                price = 21.0;
                System.out.println("Blinkenlichten" + ", Preis: " + price);
                priceSum = priceSum + price;
            case "Freitag":
                price = 32.55;
                System.out.println("Compilaz" + ", Preis: " + price);
                priceSum = priceSum + price;
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
