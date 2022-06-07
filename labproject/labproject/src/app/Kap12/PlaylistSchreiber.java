package app.Kap12;

import java.io.File;
import java.io.IOException;

/**
 * PlaylistSchreiber erwartet ein Verzeichnis und einen Dateinamen als Aufrufparameter, erzeugt 
 * eine Playlist aus dem Verzeichnis und speichert sie in der benannten Datei. 
 */
public class PlaylistSchreiber {
    public static void main(String[] args) throws IOException {
        // Prüfe Aufrufparameter
        if (args.length != 2) {
            endeMitFehler("Verwendung: PlaylistSchreiber <Musikverzeichnis> <Playlistdatei>");
        }
        File verzeichnis = new File(args[0]);
        if (!verzeichnis.exists() || !verzeichnis.isDirectory()) {
            endeMitFehler(args[0] + " ist kein gültiges Verzeichnis");
        }
        File filename = new File(args[1]);
        if (filename.exists()) {
            endeMitFehler(args[1] + " existiert bereits.");
        }
        //Erzeuge ein Playlist-Objekt aus allen Musikdateien des Verzeichnis
        Playlist myList = Playlist.ausVerzeichnis(verzeichnis);
        if (myList.getSongs().size() == 0) {
            //Keine MP3s gefunden, Meldung ausgeben aber keine Datei schreiben.
            System.out.println("Keine MP3-Dateien gefunden in " + args[0]);
        } else {
            //MP3s gefunden, Playlist schreiben
            System.out.println(myList.getSongs().size() + " MP3-Dateien gefunden in " + args[0]);
            myList.schreibe(filename);
        }
    }

    private static void endeMitFehler(String message) {
        System.err.println(message);
        System.exit(1);
    }


}
