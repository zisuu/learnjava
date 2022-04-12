package de.kaiguenster.javaintro.musikfinder;

import java.io.File;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Programm, um das Dateisystem nach Musikdateien im MP3-Format zu durchsuchen
 *
 * @author Kai
 */
public class Musikfinder {

    final private File start;

    public static void main(String[] args) {
        //Prüfe Aufrufparameter. 
        if (args.length != 1) {
            System.out.println("Benutzung: java de.kaiguenster.javaintro.musikfinder.Musikfinder <Startverzeichnis>");
            System.exit(1);
        }
        //Erzeuge einen neuen Musikfinder, gib gefundene Dateien auf die Kommandozeile aus.
        new Musikfinder(args[0]).findeMusik(System.out::println);
    }

    /**
     * Erzeuge einen neuen Musikfinder
     *
     * @param start das Startverzeichnis
     * @throws IllegalArgumentException wenn start kein lesbares Verzeichnis
     * ist.
     */
    public Musikfinder(String start) {
        this(new File(start));
    }

    /**
     * Erzeuge einen neuen Musikfinder
     *
     * @param start das Startverzeichnis
     * @throws IllegalArgumentException wenn start kein lesbares Verzeichnis
     * ist.
     */
    public Musikfinder(File start) {
        if (!start.exists() || !start.isDirectory() || !start.canRead()) {
            throw new IllegalArgumentException("Startverzeichnis muss ein lesbares Verzeichnis sein");
        }
        this.start = start;

    }

    /**
     * Finde Musikdateien im Startverzeichnis und seinen Unterverzeichnissen, 
     * verarbeite Ergebnisse mit dem Consumer c
     * @param c Consumer, um Ergebnisse zu verarbeiten.
     */
    public void findeMusik(Consumer<File> c) {
        findeMusik(start, c);
    }

    /**
     * Rekursive Methode, um Musikdateien zu finden
     * @param verzeichnis zu durchsuchendes Verzeichnis
     * @param c Consumer, um Ergebnisse zu verarbeiten
     */
    private void findeMusik(File verzeichnis, Consumer<File> c) {
        //Finde alle lesbaren Unterverzeichnisse
        File[] unterverzeichnisse = verzeichnis.listFiles(f -> f.isDirectory() && f.canRead());
        if (unterverzeichnisse != null) {
            //Durchsuche zuerst alle Unterverzeichnisse durch rekursiven Aufruf der Methode
            Arrays.stream(unterverzeichnisse).forEach(f -> this.findeMusik(f, c));
        }
        //Finde Dateien mit Endung .mp3
        File[] musikDateien = verzeichnis.listFiles(f -> f.getName().endsWith(".mp3"));
        if (musikDateien != null) {
            //Wende den consumer auf jede Datei an
            Arrays.stream(musikDateien).forEach(c);
        }
    }

}
