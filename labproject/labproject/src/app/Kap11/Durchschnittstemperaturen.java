package app.Kap11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Jede Zeile der Datei enthält die Daten für ein Jahr: In der ersten Spalte
 * steht die Jahreszahl, in den zwölf weiteren Spalten
 * jeweils die Durchschnittstemperatur eines Monats. Spalten sind durch
 * Tabulatoren, in Java-Strings \t, getrennt.
 * 
 * Schreiben Sie ein Programm, das die Datei wie gezeigt einliest und nur unter
 * der Verwendung von Streams das Folgende findet:
 * 1) die Temperatur des heissesten Monats des Messzeitraums, nur die
 * Temperatur,
 * nicht den zugehörigen Monat
 * 2) die Temperatur des im Durchschnitt heissesten Jahres
 * 3) Jahr und Monat mit der heissesten Temperatur, also die Jahreszahl und den
 * Namen des Monats
 * 
 * Betrachten Sie die drei Aufgaben getrennt. Das heisst auch, dass die Datei
 * dreimal gelesen wird. Implementieren Sie die drei
 * Aufgaben als drei Methoden, die nacheinander ausgeführt werden.
 */
public class Durchschnittstemperaturen {

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
     * Finde den Monat mit der höchsten Temperatur in den Daten der Datei und gebe diesen aus
     * @param dateiname
     * @throws IOException
     */
    private static void findeHeissestenMonat(String dateiname) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))) {
            reader
                    .lines()
                    // bringe alle Temperaturen in eine Liste
                    .flatMapToDouble(line -> Arrays.stream(line.split("\\s+"))
                            // überspringe die erste Spalte, weil uns das Jahr nicht interessiert
                            .skip(1)
                            // parse alle zahlen als Double
                            .mapToDouble(Double::parseDouble))
                    // finde die grösste Zahl
                    .reduce(Math::max)
                    // und gib diese aus
                    .ifPresent(t -> System.out.println("Der heisseste Monat hatte " + t + " Grad."));
        }
    }

    /**
     * Finde das Jahr mit der höchsten Durschnittstemperatur und gebe diese aus
     * @param dateiname
     * @throws IOException
     */
    private static void findeHeissestesJahr(String dateiname) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))) {
            reader
                    .lines()
                    // bringe alle Temperaturen pro Zeile in eine Liste
                    .mapToDouble(line -> Arrays.stream(line.split("\\s+"))
                            // überspringe die erste Spalte, weil uns das Jahr nicht interessiert
                            .skip(1)
                            // parse alle zahlen als Double
                            .mapToDouble(Double::parseDouble)
                            // berechne die avg temp pro zeile
                            .average()
                            // und nehme diese als Double
                            .getAsDouble())
                    // nehme den höchsten Durchschnittswert
                    .reduce(Math::max)
                    // und gebe diesen aus
                    .ifPresent(t -> System.out.println("Das durschnittlich heisseste Jahr hatte " + t +" Grad."));
        }

    }

    /**
     * Findet den heissesten Monat.
     * @param dateiname Name der Datendatei
     * @throws IOException wenn die Datei nicht gelesen werden kann
     */
    private static void findeHeissestesJahrUndMonat(String dateiname) throws IOException {
        //Die Datendatei einlesen
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))) {
            //Erzeuge einen Stream von Monatswert-Objekten, um Monat und Jahr zu Temperatur zuordnen zu können.
            erzeugeMonatswertStream(reader)
                    //Finde den heissesten Monatswert
                    .reduce((x, y) -> x.getTemperatur() > y.getTemperatur() ? x : y)
                    //Gib Monat, Jahr und Temperatur aus.
                    .ifPresent(t -> System.out.println("Der heisseste Monat war " + t.getMonat() + "/" + t.getJahr() + " mit " + t.getTemperatur() + " Grad."));
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
        //Das würde auch klassisch mit for funktionieren, aber es geht ja gerade um Streams
        return IntStream.rangeClosed(1, 12).mapToObj(i -> new Monatswert(i, jahr, Double.parseDouble(spalten[i])));
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
