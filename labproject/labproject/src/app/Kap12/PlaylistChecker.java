package app.Kap12;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * PlaylistChecker erwartet eine Playlist-Datei als Parameter, liest diese ein, verifiziert sie und schreibt die bereinigte 
 * Playlist wieder in die Datei.
 */
public class PlaylistChecker {

    public static void main(String[] args) throws IOException {
        // Prüfe Aufrufparameter
        if (args.length != 1) {
            endeMitFehler("Verwendung: PlaylistChecker <Playlist-Datei>");
        }
        File filename = new File(args[0]);
        if (!filename.exists() || !filename.isFile() || !filename.canRead()) {
            endeMitFehler(args[0] + " ist keine lesbare Datei");
        }
        //Die Playlist aus der Datei lesen.
        Playlist playlist = Playlist.lese(filename);
        //Verifizieren
        int entfernt = playlist.verifiziere();
        //Asugebeben, wie viele Dateien nicht mehr existierten
        System.out.println(entfernt + " Datei(en) aus Playlist entfernt");
        //Die bereinigte Playlist schreiben.
        playlist.schreibe(filename);
      
    }

    private static void endeMitFehler(String message) {
        System.err.println(message);
        System.exit(1);
    }  
}
