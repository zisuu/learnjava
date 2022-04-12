package de.kaiguenster.javaintro.playlist;

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

    private List<Song> songs = new ArrayList<>();

    /**
     * Füge einen Song hinzu 
     * @param song ein Song-Objekt
     */
    public void addSong(Song song) {
        songs.add(song);
    }

    /**
     * Lies den Inhalt der Playlist
     * @return eine unveränderliche Liste von absoluten Song-Objekten.
     */    
    public List<Song> getSongs() {
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
            for (Song song : songs) {
                //Feldinhalte werden durch | getrennt geschrieben, jeder Song in eine Zeile
                buffered.write(song.getPfad());
                buffered.write("|");
                buffered.write(song.getTitel());
                buffered.write("|");
                buffered.write(song.getInterpret());
                buffered.write("|");
                buffered.write(song.getAlbum());
                buffered.write("|");
                buffered.write(song.getJahr() == null ? "" : song.getJahr().toString());
                buffered.write("|");
                buffered.write(song.getKommentar());
                buffered.write("|");
                buffered.write(song.getTrack() == null ? "" : song.getTrack().toString());
                buffered.write("|");
                buffered.write(Byte.toString(song.getGenre()));
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
                .filter(song -> new File(song.getPfad()).exists())
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
            reader.lines()
                    .map(Playlist::ausDateiZeile)
                    .forEach(playlist::addSong);
            return playlist;
        }
    }

    /**
     * Erzeuge einen Song aus einer Zeile der Playlistdatei
     * @param zeile
     * @return 
     */
    private static Song ausDateiZeile(String zeile){
        Song song = new Song();
        //trenne die Zeile am |-Symbol (mit Backslash escaped weil | ein Sonderzeichen in regulären Ausdrücken ist)
        String[] felder = zeile.split("\\|");
        song.setPfad(felder[0]);
        song.setTitel(felder[1]);
        song.setInterpret(felder[2]);
        song.setAlbum(felder[3]);
        song.setJahr(felder[4].length() == 4 ? Integer.parseInt(felder[4]) : null);
        song.setKommentar(felder[5]);
        song.setTrack(felder[6].length() == 1 ? Integer.parseInt(felder[6]) : null);
        song.setGenre(Byte.parseByte(felder[7]));
        return song;
    }

    @Override
    public String toString() {
        return "Playlist{" + "songs=" + songs.stream().map(Song::toString).collect(Collectors.joining("\n")) + '}';
    }
    
    
}
