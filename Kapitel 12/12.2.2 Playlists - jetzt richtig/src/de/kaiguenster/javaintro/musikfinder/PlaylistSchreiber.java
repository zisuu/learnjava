package de.kaiguenster.javaintro.musikfinder;

import java.io.File;
import java.io.IOException;

/**
 * Programm, um eine {@link Playlist} aus einem Verzeichnis zu erstellen.
 *
 * @author Kai
 */
public class PlaylistSchreiber {

    public static void main(String[] args) throws IOException {
        //Prüfe Aufrufparameter
        if (args.length != 2) {
            endeMitFehler("Verwendung: java de.kaiguenster.javaintro.musikfinder.PlaylistSchreiber <Musikverzeichnis> <Playlistdatei>");
        }
        File musikverzeichnis = new File(args[0]);
        if (!musikverzeichnis.exists() || !musikverzeichnis.isDirectory()) {
            endeMitFehler(args[0] + " ist kein gültiges Verzeichnis");
        }
        File ausgabeDatei = new File(args[1]);
        if (ausgabeDatei.exists()) {
            endeMitFehler(args[1] + " existiert bereits.");
        }
        //Erzeuge ein Playlist-Objekt aus allen Musikdateien des Verzeichnis
        Playlist gefunden = Playlist.ausVerzeichnis(musikverzeichnis);
        if (gefunden.getSongs().size() == 0) {
            //Keine MP3s gefunden, Meldung ausgeben aber keine Datei schreiben.
            System.out.println("Keine MP3-Dateien gefunden in " + args[0]);
        } else {
            //MP3s gefunden, Playlist schreiben
            System.out.println(gefunden.getSongs().size() + " MP3-Dateien gefunden in " + args[0]);
            gefunden.schreibe(ausgabeDatei);
        }

    }

    private static void endeMitFehler(String message) {
        System.err.println(message);
        System.exit(1);
    }

}
