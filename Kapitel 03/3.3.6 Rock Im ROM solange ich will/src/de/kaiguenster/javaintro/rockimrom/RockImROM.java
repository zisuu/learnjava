package de.kaiguenster.javaintro.rockimrom;

import java.io.*;

/**
 * Programm, um Ticketpreis und Showprogramm für das Rock Im ROM-Festival zu
 * berechnen. Diese Version fragt An- und Abreisetag ab, und berechnet das
 * Programm und den Preis für den genauen Zeitraum..
 *
 * @author Kai Günster
 */
public class RockImROM {

    public static void main(String[] args) throws IOException {
        //Es werden an- und Abreisetag von der Kommandozeile gelesen.
        System.out.println("An welchem Tag kommst du?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String starttag = in.readLine();
        System.out.println("Und bis wann bleibst du?");
        String endtag = in.readLine();
        String headliner = "";
        double preis = 0;
        //Mit dem eingegebenen Anreisetag wird geswitcht
        switch (starttag) {
            case "Montag":
                //Headliner und Preis werden wie in der Vorversion auch konkateniert bzw. addiert.
                headliner += "Rage against the Compiler\n";
                preis += 37.5;
                /*
                 * Die Ausführung von switch wird nur abgebrochen, wenn der aktuelle Wochentag
                 * dem Endtag entspricht. Sonst fällt die Ausführung durch. 
                 */
                if ("Montag".equals(endtag)) {
                    break;
                }
            case "Dienstag":
                headliner += "if/else\n";
                preis += 22;
                if ("Dienstag".equals(endtag)) {
                    break;
                }
            case "Mittwoch":
                headliner += "The Falling Cases\n";
                preis += 17.50;
                if ("Mittwoch".equals(endtag)) {
                    break;
                }
            case "Donnerstag":
                headliner += "Blinkenlichten\n";
                preis += 21;
                if ("Donnerstag".equals(endtag)) {
                    break;
                }
            case "Freitag":
                headliner += "Compilaz\n";
                preis += 32.55;
                if ("Freitag".equals(endtag)) {
                    break;
                }
            case "Samstag":
                headliner += "Real Class\n";
                preis += 45;
                if ("Samstag".equals(endtag)) {
                    break;
                }
            case "Sonntag":
                headliner += "Delphi and the Oracles\n";
                preis += 35;
                if ("Sonntag".equals(endtag)) {
                    break;
                }
            default:
                /*Falls ungültiger Start- oder Endtag eingegeben wurden, wird der 
                default-Block ausgeführt. Er gibt eine entsprechende Fehlermeldung aus. 
                Im Falle eines ungültigen Endtages landen wir hier, weil die Ausführung aus 
                case "Sonntag" durchfällt.
                */
                System.out.println("Unbekannter Tag oder Endtag liegt vor Starttag: " + starttag + " - " + endtag);
                System.exit(1);
        }
        //Gesammelte Headliner und Gesamtpreis werden ausgegeben.
        System.out.println("Die Headliner sind:\n" + headliner);
        System.out.println("Kartenpreis: " + preis + "€");
    }

}
