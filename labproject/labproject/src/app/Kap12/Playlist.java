package app.Kap12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Einmal mehr sollen Sie eine Playlist-Klasse schreiben. Sie hat nichts mit den Klassen aus den vorigen Kapiteln zu tun, 
 * aber in den weiteren Übungen in diesem Kapitel werden Sie sie in diese Richtung entwickeln.
 * Für den Moment soll es in der Playlist eine Liste von Strings geben, die die absoluten Pfade zu Musikdateien enthält. 
 * Eine Methode addSong soll einen neuen Pfad hinzufügen, mit getSongs soll man die ganze Liste zurückbe
 * Als Nächstes soll es durch eine statische Methode ausVerzeichnis möglich sein, eine neue Playlist zu erzeugen, die 
 * alle MP3-Dateien aus einem Verzeichnis und seinen Unterverzeichnissen enthält. Sie können dazu die Klasse Musikfinder 
 * aus der vorigen Übung weiterverwenden.
 * 
 * Eine Methode schreibe soll den Inhalt der Playlist in eine Datei schreiben, einen Pfad pro Zeile. Eine statische Methode 
 * lese soll eine solche Datei einlesen und wieder ein Playlist-Objekt daraus erzeugen.
 * 
 * Zuletzt soll eine Methode verifiziere für jeden Eintrag der Playlist prüfen, ob die Datei noch existiert, und im Negativfall 
 * den Eintrag aus der Liste entfernen.
 * 
 * PlaylistChecker erwartet eine Playlist-Datei als Parameter, liest diese ein, verifiziert sie und schreibt die bereinigte 
 * Playlist wieder in die Datei.
 */
public class Playlist {
    // OK: Playlist die eine Liste von Strings mit absoluten Pfaden zu Musikdateien enthält
    private List<String> thePlaylist = new ArrayList<>();
    
    // OK: Eine Methode addSong soll einen neuen Pfad hinzufügen
    public void addSong(String pfad) {
        thePlaylist.add(pfad);
    }

    // OK: mit getSongs soll man die ganze Liste zurückbekommen
    public List<String> getSongs() {
        return thePlaylist;
    }

    /**
     * Als Nächstes soll es durch eine statische Methode ausVerzeichnis möglich sein, eine neue Playlist zu erzeugen, die 
     * alle MP3-Dateien aus einem Verzeichnis und seinen Unterverzeichnissen enthält. Sie können dazu die Klasse Musikfinder 
     * aus der vorigen Übung weiterverwenden.
     */
    /**
     * Erzeuge eine Playlist aus allen MP3s eines Verzeichnis.
     * @param startVerzeichnis
     * @return eine Playlist mit allen MP3-Dateien im Startverzeichnis und seinen Unterverzeichnissen
     */
    public static Playlist ausVerzeichnis(File startVerzeichnis) {
        Playlist playlist = new Playlist();
        new MusicFinder(startVerzeichnis).findMusic(datei -> playlist.addSong(datei.getAbsolutePath()));
        return playlist;
    }

    /**
     * Verifizieren den Inhalt dieser Playliste, entferne nicht mehr existierende Dateien
     * @return die Anzahl entfernter Dateien
     */
    public int verifiziere(){
        int vorher = thePlaylist.size();
        thePlaylist = thePlaylist.stream()
                .filter(song -> new File(song).exists())
                .collect(Collectors.toList());
        return vorher - thePlaylist.size();
    }

    /**
     * Schreibe den Inhalt dieser Playlist in eine Datei.
     * @param ziel die Zieldatei
     * @throws IOException 
     */
    public void schreibe(File ziel) throws IOException {
        schreibe(new FileWriter(ziel));
    }

    // Eine Methode schreibe soll den Inhalt der Playlist in eine Datei schreiben, einen Pfad pro Zeile.
    /**
     * Schreibe den Inhalt dieser Playlist in einen Writer
     * @param ziel der Zielwriter
     * @throws IOException 
     */
    public void schreibe(Writer ziel) throws IOException {
        try (BufferedWriter buffWriter = new BufferedWriter(ziel)){
            for (String song : thePlaylist) {
                buffWriter.write(song);
                buffWriter.newLine();
            }
        }
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
    
    // Eine statische Methode lese soll eine solche Datei einlesen und wieder ein Playlist-Objekt daraus erzeugen.
    public static Playlist lese(Reader datei) throws FileNotFoundException, IOException {
        try (BufferedReader buffReader = new BufferedReader(datei)){
            Playlist playlist = new Playlist();
            //Lies die Datei Zeilenweise, füge jede Zeile der Playlist hinzu.
            buffReader.lines().forEach(playlist::addSong);
            return playlist;
        }
    }

}
