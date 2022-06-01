package app.Kap11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Jede Zeile der Datei enthält die Daten für ein Jahr: In der ersten Spalte steht die Jahreszahl, in den zwölf weiteren Spalten 
 * jeweils die Durchschnittstemperatur eines Monats. Spalten sind durch Tabulatoren, in Java-Strings \t, getrennt.
 * 
 * Schreiben Sie ein Programm, das die Datei wie gezeigt einliest und nur unter der Verwendung von Streams das Folgende findet:
 *     die Temperatur des heissesten Monats des Messzeitraums, nur die Temperatur, nicht den zugehörigen Monat
 *     die Temperatur des im Durchschnitt heissesten Jahres
 *     Jahr und Monat mit der heissesten Temperatur, also die Jahreszahl und den Namen des Monats
 * 
 * Betrachten Sie die drei Aufgaben getrennt. Das heisst auch, dass die Datei dreimal gelesen wird. Implementieren Sie die drei 
 * Aufgaben als drei Methoden, die nacheinander ausgeführt werden. Die Lösung zu dieser Übung finden Sie im Anhang.
 */
public class Durchschnittstemperaturen {
    
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Bitte übergeben Sie einen Dateinamen");
            System.exit(1);
        }
        String dateiname = args[0];
        findeHeissestenMonat(dateiname);
        //findeHeissestesJahr(dateiname);
        //findeHeissestesJahrUndMonat(dateiname);
    }
    private static void findeHeissestenMonat(String dateiname) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))){
            reader
                //Für jede Zeile der Datei
                .lines()
                //Berechne den Durchschnitt dieser Zeile
                .flatMapToDouble(line -> Arrays.stream(line.split("\\s+"))
                    //Überspringe die erste Zeile, weil uns das Jahr nicht interessiert
                    .skip(1)
                    //Parse den Rest als Zahlen
                    .mapToDouble(Double::parseDouble))
                //Finde den höchsten Durchschnittswert
                .reduce(Math::max)
                //und gibt ihn aus
                .ifPresent(t -> System.out.println("Der heisseste Monat hatte " + t + " Grad."));
            }

    }

}
