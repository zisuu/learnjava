package de.kaiguenster.javaintro.musikfinder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Playlistklasse, deren Inhalt im Dateisystem gespeichert und von dort wieder gelesen werden kann.
 * @author Kai Günster
 */
public class Playlist {

    private List<String> songs = new ArrayList<>();

    /**
     * Füge einen Song hinzu 
     * @param pfad der absolute Pfad der Musikdatei
     */
    public void addSong(String pfad) {
        songs.add(pfad);
    }

    /**
     * Lies den Inhalt der Playlist
     * @return eine unveränderliche Liste von absoluten Dateipfaden.
     */
    public List<String> getSongs() {
        return Collections.unmodifiableList(songs);
    }

    /**
     * Schreibe den Inhalt dieser Playlist in eine Datei.
     * @param ziel die Zieldatei
     * @throws IOException 
     */
    public void schreibe(File ziel) throws IOException {
        schreibe(new FileWriter(ziel));
    }

    /**
     * Schreibe den Inhalt dieser Playlist in einen Writer
     * @param ziel der Zielwriter
     * @throws IOException 
     */
    public void schreibe(Writer ziel) throws IOException {
        try (BufferedWriter buffered = new BufferedWriter(ziel)) {
            for (String song : songs) {
                //Der absolute PFad jeder Datei wird in einer eigenen Zeile ausgegeben
                buffered.write(song);
                buffered.newLine();
            }
        }
    }
    
    /**
     * Verifizieren den Inhalt dieser Playliste, entferne nicht mehr existierende Dateien
     * @return die Anzahl entfernter Dateien
     */
    public int verifiziere(){
        int vorher = songs.size();
        songs = songs.stream()
                .filter(song -> new File(song).exists())
                .collect(Collectors.toList());
        return vorher - songs.size();
    }
    
    /**
     * Lesen einer Playlist aus einer Datei
     * @param quelle die Quelldatei
     * @return ein Playlist-Objekt
     * @throws IOException 
     */
    public static Playlist lese(File quelle) throws IOException{
        return lese(new FileReader(quelle));
    }
    
    /**
     * Lesen einer Playlist aus einem Reader
     * @param quelle der Quellreader
     * @return ein Playlist-Objekt
     * @throws IOException 
     */    
    public static Playlist lese(Reader quelle) throws IOException{
        try (BufferedReader reader = new BufferedReader(quelle)){
            Playlist playlist = new Playlist();
            //Lies die Datei Zeilenweise, füge jede Zeile der Playlist hinzu.
            reader.lines().forEach(playlist::addSong);
            return playlist;
        }
    }

    /**
     * Erzeuge eine Playlist aus allen MP3s eines Verzeichnis.
     * @param startVerzeichnis
     * @return eine Playlist mit allen MP3-Dateien im Startverzeichnis und seinen Unterverzeichnissen
     */
    public static Playlist ausVerzeichnis(File startVerzeichnis) {
        Playlist playlist = new Playlist();
        new Musikfinder(startVerzeichnis).findeMusik(datei -> playlist.addSong(datei.getAbsolutePath()));
        return playlist;
    }
}
