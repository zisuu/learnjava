package de.kaiguenster.javaintro.durchschnittstemperatur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Month;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Programm, um Durschnittstemparaturen eines Jahres und eines Monats über
 * mehrere Jahre zu berechnen.
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
        monatsdurchschnitt(dateiname);
        jahresdurchschnitt(dateiname);
    }

    /**
     * Berechne die durchschnittliche Temperatur eines Monats über mehrere Jahre
     *
     * @param dateiname - Name der Datendatei
     * @throws IOException wenn die Datei nicht gelesen werden kann.
     */
    private static void monatsdurchschnitt(String dateiname) throws IOException {
        System.out.println("Temperaturen im Monatsdurchschnitt");
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))) {
            //Erzeuge einen Stream von Monatswerten
            Map<Month, Double> statistik = erzeugeMonatswertStream(reader)
                    //Erzeuge eine Map von Monat nach Durchschnittswert
                    .collect(Collectors.groupingBy(mw -> Month.of(mw.monat + 1), //Gruppiere die Werte nach Monat
                                    TreeMap::new, //Sammle die Wete in einer neuen TreeMap
                                    Collectors.averagingDouble(mw -> mw.temperatur))); //berechne für jede Gruppe den Durchschnitt
            for (Map.Entry<Month, Double> entry : statistik.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " Grad");
            }
        }
    }

    /**
     * Berechne Jahresdurchschnitt
     *
     * @param dateiname - Name der Datendatei
     * @throws IOException wenn die Datei nicht gelesen werden kann.
     */
    private static void jahresdurchschnitt(String dateiname) throws IOException {
        System.out.println("Temperaturen im Jahresdurchschnitt");
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))) {
            //Erzeuge einen Stream von Monatswerten
            Map<Integer, Double> statistik = erzeugeMonatswertStream(reader)
                    //Erzeuge eine Map von Jahr nach Durchschnittswert
                    .collect(Collectors.groupingBy(mw -> mw.jahr, //Gruppiere die Werte nach Jahr
                                    TreeMap::new, //Sammle die Wete in einer neuen TreeMap
                                    Collectors.averagingDouble(mw -> mw.temperatur))); //berechne für jede Gruppe den Durchschnitt
            for (Map.Entry<Integer, Double> entry : statistik.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " Grad");
            }
        }
    }

    private static Stream<Monatswert> erzeugeMonatswertStream(final BufferedReader reader) {
        return reader.lines()
                .flatMap(zeile -> parseZeile(zeile));
    }

    private static Stream<Monatswert> parseZeile(String zeile) throws NumberFormatException {
        String[] spalten = zeile.split("\\s+");
        int jahr = Integer.parseInt(spalten[0]);
        return IntStream.
                rangeClosed(1, 12).
                mapToObj(i -> new Monatswert(i - 1, jahr, Double.parseDouble(spalten[i])));
    }

    private static class Monatswert {

        final int monat;
        final int jahr;
        final double temperatur;

        public Monatswert(int monat, int jahr, double temperatur) {
            this.monat = monat;
            this.jahr = jahr;
            this.temperatur = temperatur;
        }
    }

}
