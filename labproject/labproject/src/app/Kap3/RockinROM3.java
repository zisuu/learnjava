package app.Kap3;

import java.io.*;

public class RockinROM3 {
    public static void main(String[] args) throws IOException {
        System.out.println("## ROCK in ROM: Dieses Tool gibt das Programm und den Preis des gewünschten Tages an ##");
        System.out.println("Bitte geben Sie den gewünschten Anreisetag an: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String startDay = reader.readLine();
        System.out.println("Bitte geben Sie den gewünschten Abreisetag an: ");
        String endDay = reader.readLine();
        System.out.println(getProgramm(startDay, endDay));

    }

    public static String getProgramm(String startDay, String endDay) {
        String headliner = "";
        double price = 0;
        double priceSum = 0;

        switch (startDay) {
            case "Montag":
                headliner += "Rage against the Compiler\n";
                price += 37.50;
                if ("Montag".equals(endDay)){
                    break;
                }
            case "Dienstag":
                price += 22.0;
                headliner += "if/else\n";
                if ("Dienstag".equals(endDay)){
                    break;
                }
            case "Mittwoch":
                price += 17.50;
                headliner += "The Falling Cases\n";
                if ("Mittwoch".equals(endDay)){
                    break;
                }
            case "Donnerstag":
                price += 21.0;
                headliner += "Blinkenlichten\n";
                if ("Donnerstag".equals(endDay)){
                    break;
                }
            case "Freitag":
                price += 32.55;
                headliner += "Compilaz\n";
                if ("Freitag".equals(endDay)){
                    break;
                }
            case "Samstag":
                price += 45.0;
                headliner += "Real Class\n";
                if ("Samstag".equals(endDay)){
                    break;
                }
            case "Sonntag":
                price += 35.0;
                headliner += "Delphi and the Oracles\n";
                if ("Sonntag".equals(endDay)){
                    break;
                }
            default:
                System.out.println(" FEHLER - Wochentag " + startDay + " unbekannt");
                System.exit(1);
        }
        return "Programm: " + headliner + "Gesamt Preis: " + price;
    }
}
