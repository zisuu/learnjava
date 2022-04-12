package de.kaiguenster.javaintro.musikfinder;

import java.io.File;
import java.io.IOException;

/**
 * Programm zur Verifizierung einer Playlistdatei: entfernt alle Einträge, die
 * nicht mehr existieren.
 *
 * @author Kai Günster
 */
public class PlaylistChecker {

    public static void main(String[] args) throws IOException {
        //Aufrufparameter prüfen
        if (args.length != 1) {
            endeMitFehler("Verwendung: java de.kaiguenster.javaintro.musikfinder.PlaylistChecker <Playlistdatei>");
        }
        File playlistDatei = new File(args[0]);
        if (!playlistDatei.exists() || !playlistDatei.isFile() || !playlistDatei.canRead()) {
            endeMitFehler(args[0] + " ist keine lesbare Datei");
        }
        //Die Playlist aus der Datei lesen.
        Playlist playlist = Playlist.lese(playlistDatei);
        //Verifizieren
        int entfernt = playlist.verifiziere();
        //Asugebeben, wie viele Dateien nicht mehr existierten
        System.out.println(entfernt + " Datei(en) aus Playlist entfernt");
        //Die bereinigte Playlist schreiben.
        playlist.schreibe(playlistDatei);

    }

    private static void endeMitFehler(String message) {
        System.err.println(message);
        System.exit(1);
    }
}
