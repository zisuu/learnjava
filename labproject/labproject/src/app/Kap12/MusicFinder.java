package app.Kap12;

import java.io.File;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Schreiben Sie eine Klasse Musikfinder, die von einem angegebenen
 * Startverzeichnis aus alle Unterverzeichnisse
 * durchsucht und alle MP3-Dateien findet, also solche Dateien, die die Endung
 * .mp3 haben. Als Consumer
 * soll dem Musikfinder mitgegeben werden, was er mit den gefundenen Dateien tun
 * soll.
 * 
 * Aufgrund der Problematik mit lesegeschützten Verzeichnissen verwenden Sie
 * bitte nicht die Hilfsmethoden aus
 * Files, sondern File.listFile und realisieren die Rekursion in die
 * Unterverzeichnisse selbst.
 * 
 * Schreiben Sie eine main-Methode, die das Startverzeichnis als Aufrufparameter
 * erwartet und mit dem Musikfinder
 * den Pfad aller gefundenen Dateien ausgibt.
 */
public class MusicFinder {

    final private File start;

    public static void main(String[] args) throws Exception {
        // Prüfe Aufrufparameter.
        if (args.length != 1) {
            System.out.println("Bitte Startverzeichnis angeben!");
            System.exit(1);
        }
        // Erzeuge einen neuen Musikfinder, gib gefundene Dateien auf die Kommandozeile
        // aus.
        new MusicFinder(args[0]).findMusic(System.out::println);
    }

    /**
     * Erzeuge einen neuen Musikfinder
     *
     * @param start das Startverzeichnis
     * @throws IllegalArgumentException wenn start kein lesbares Verzeichnis
     *                                  ist.
     */
    public MusicFinder(String start) {
        this(new File(start));
    }

    /**
     * Erzeuge einen neuen Musikfinder
     *
     * @param start das Startverzeichnis
     * @throws IllegalArgumentException wenn start kein lesbares Verzeichnis
     *                                  ist.
     */
    public MusicFinder(File start) {
        if (!start.exists() || !start.isDirectory() || !start.canRead()) {
            throw new IllegalArgumentException("Startverzeichnis muss ein lesbares Verzeichnis sein");
        }
        this.start = start;

    }

    /**
     * Finde Musikdateien im Startverzeichnis und seinen Unterverzeichnissen,
     * verarbeite Ergebnisse mit dem Consumer c
     * 
     * @param c Consumer, um Ergebnisse zu verarbeiten.
     */
    public void findMusic(Consumer<File> c) {
        findMusic(start, c);
    }

    /**
     * Rekursive Methode, um Musikdateien zu finden
     * 
     * @param verzeichnis zu durchsuchendes Verzeichnis
     * @param c           Consumer, um Ergebnisse zu verarbeiten
     */
    private void findMusic(File verzeichnis, Consumer<File> c) {
        // Finde alle lesbaren Unterverzeichnisse
        File[] unterverzeichnisse = verzeichnis.listFiles(f -> f.isDirectory() && f.canRead());
        if (unterverzeichnisse != null) {
            // Durchsuche zuerst alle Unterverzeichnisse durch rekursiven Aufruf der Methode
            Arrays.stream(unterverzeichnisse).forEach(f -> this.findMusic(f, c));
        }
        // Finde Dateien mit Endung .mp3
        File[] musikDateien = verzeichnis.listFiles(f -> f.getName().endsWith(".mp3"));
        if (musikDateien != null) {
            // Wende den consumer auf jede Datei an
            Arrays.stream(musikDateien).forEach(c);
        }
    }
}
