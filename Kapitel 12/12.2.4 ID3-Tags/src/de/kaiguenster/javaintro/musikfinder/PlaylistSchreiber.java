package de.kaiguenster.javaintro.musikfinder;

import java.io.File;
import java.io.IOException;

public class PlaylistSchreiber {
    
    public static void main(String[] args) throws IOException{
        if (args.length != 2)
            endeMitFehler("Verwendung: java de.kaiguenster.javaintro.musikfinder.PlaylistSchreiber <Musikverzeichnis> <Playlistdatei>");
        File musikverzeichnis = new File(args[0]);
        if (!musikverzeichnis.exists() || !musikverzeichnis.isDirectory())
            endeMitFehler(args[0] + " ist kein gültiges Verzeichnis");
        File ausgabeDatei = new File(args[1]);
        if (ausgabeDatei.exists())
            endeMitFehler(args[1 ] + " existiert bereits.");
        Playlist gefunden = Playlist.ausVerzeichnis(musikverzeichnis);
        System.out.println(gefunden);
        if (gefunden.getSongs().size() == 0){
            System.out.println("Keine MP3-Dateien gefunden in " + args[0]);
        } else {
            System.out.println(gefunden.getSongs().size() + " MP3-Dateien gefunden in " + args[0]);
            gefunden.schreibe(ausgabeDatei);
        }
                
    }
    
    private static void endeMitFehler(String message){
        System.err.println(message);
        System.exit(1);
    }
    
}
