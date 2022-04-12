package de.kaiguenster.javaintro.durchschnittstemperatur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Programm zur Auswertung von Temperaturdaten aus Dateien im CSV-Format.
 *
 * @author Kai Günster
 */
public class Durchschnittstemperatur {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Bitte übergeben Sie einen Dateinamen");
            System.exit(1);
        }
        String dateiname = args[0];
        findeHeissestenMonat(dateiname);
        findeHeissestesJahr(dateiname);
        findeHeissestesJahrUndMonat(dateiname);
    }

    /**
     * Findet die heißeste Monatstemperatur.
     * @param dateiname Name der Datendatei
     * @throws IOException wenn die Datei nicht gelesen werden kann
     */
    private static void findeHeissestenMonat(String dateiname) throws IOException {
        //Die Datendatei einlesen
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))) {
            reader
                    //Für jede Zeile der Datei
                    .lines()
                    //Für die dort gefundenen Zahlen zu einem Stream von Temperaturwerten zusammen
                    .flatMapToDouble(line -> Arrays.stream(line.split("\\s+"))
                            //Überspringe den ersten Eintrag jeder Zeile, es ist die Jahreszahl
                            .skip(1)
                            //Parse alle Zahlen einer Zeile
                            .mapToDouble(Double::parseDouble))
                    //Finde den maximalen Gesamtwert
                    .reduce(Math::max)
                    //Wenn es einen Wert gab - sollte immer der Fall sein - gib ihn aus.
                    .ifPresent(t -> System.out.println("Der heißeste Monat der letzten 50 Jahre hatte " + t + " Grad."));
        }
    }

    /**
     * Findet die höchste Jahresdurchschnittstemperatur.
     * @param dateiname Name der Datendatei
     * @throws IOException wenn die Datei nicht gelesen werden kann
     */
    private static void findeHeissestesJahr(String dateiname) throws IOException {
        //Die Datendatei einlesen
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))) {
            reader
                    //Für jede Zeile der Datei
                    .lines()
                    //Berechne den Durchschnitt dieser Zeile
                    .mapToDouble(line -> Arrays.stream(line.split("\\s+"))
                            //Überspringe den ersten Eintrag jeder Zeile, es ist die Jahreszahl
                            .skip(1)
                            //Parse den Rest als Zahlen
                            .mapToDouble(Double::parseDouble)
                            //Berechne den Durchschnitt
                            .average()
                            .getAsDouble())
                    //Finde den höchsten Durchschnittswert
                    .reduce(Math::max)
                    //Und gib ihn aus.
                    .ifPresent(t -> System.out.println("Das heißeste Jahr der letzten 50 Jahre hatte im Schnitt " + t + " Grad."));
        }
    }

    /**
     * Findet den heißesten Monat.
     * @param dateiname Name der Datendatei
     * @throws IOException wenn die Datei nicht gelesen werden kann
     */
    private static void findeHeissestesJahrUndMonat(String dateiname) throws IOException {
        //Die Datendatei einlesen
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))) {
            //Erzeuge einen Stream von Monatswert-Objekten, um Monat und Jahr zu Temperatur zuordnen zu können.
            erzeugeMonatswertStream(reader)
                    //Finde den heißesten Monatswert
                    .reduce((x, y) -> x.getTemperatur() > y.getTemperatur() ? x : y)
                    //Gib Monat, Jahr und Temperatur aus.
                    .ifPresent(t -> System.out.println("Der heißeste Monat der letzten 50 Jahre war " + t.getMonat() + "/" + t.getJahr() + " mit " + t.getTemperatur() + " Grad."));
        }
    }

    /**
     * Erzeuge einen Stream von Monatswertobjekten
     * @param reader der Reader der Datendatei
     */
    private static Stream<Monatswert> erzeugeMonatswertStream(final BufferedReader reader) {
        return reader.lines()
                .flatMap(zeile -> parseZeile(zeile));
    }

    /**
     * Parse eine einzelne Zeile 
     * @param zeile die Datenzeile
     * @return einen Stream von Monatswerten
     * @throws NumberFormatException 
     */
    private static Stream<Monatswert> parseZeile(String zeile) throws NumberFormatException {
        String[] spalten = zeile.split("\\s+");
        //An erster Stelle steht die Jahreszahl
        int jahr = Integer.parseInt(spalten[0]);
        //Erzeuge für jeden Monat einen Monatswert. 
        //Das würde auch klassisch mit for funktionieren, aber es gheht ja gerade um Streams
        return IntStream.
                rangeClosed(1, 12).
                mapToObj(i -> new Monatswert(i, jahr, Double.parseDouble(spalten[i])));
    }

    /**
     * Datenklasse, die die Temperatur je Jahr/Monat speichert.
     */
    private static class Monatswert {

        private final int monat;
        private final int jahr;
        private final double temperatur;

        public Monatswert(int monat, int jahr, double temperatur) {
            this.monat = monat;
            this.jahr = jahr;
            this.temperatur = temperatur;
        }

        public int getMonat() {
            return monat;
        }

        public int getJahr() {
            return jahr;
        }

        public double getTemperatur() {
            return temperatur;
        }
    }
}
