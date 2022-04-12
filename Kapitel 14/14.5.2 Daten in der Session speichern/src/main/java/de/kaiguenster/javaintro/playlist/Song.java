package de.kaiguenster.javaintro.playlist;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;

/**
 * Eine Java-Klasse, um die im ID3v1 Tag einer MP3-Datei gespeicherten
 * Informationen aufzunehmen
 *
 * @author Kai Günster
 */
public class Song {

    /**
     * Standard-Encoding des ID3-Tags
     */
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    /**
     * Die Start-Sequenz des ID3v1 Tags als byte[]
     */
    private static final byte[] TAG = "TAG".getBytes(ISO_8859_1);

    private String pfad;
    private String titel;
    private String interpret;
    private String album;
    private Integer jahr;
    private String kommentar;
    private Integer track;
    private byte genre;

    public String getPfad() {
        return pfad;
    }

    public void setPfad(String pfad) {
        this.pfad = pfad;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getJahr() {
        return jahr;
    }

    public void setJahr(Integer jahr) {
        this.jahr = jahr;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public Integer getTrack() {
        return track;
    }

    public void setTrack(Integer track) {
        this.track = track;
    }

    public byte getGenre() {
        return genre;
    }

    public void setGenre(byte genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        //Annahme: wenn weder Titel noch interpret gesetzt waren, dann gab es keine Tagdaten
        if (titel != null || interpret != null) {
            return "Song{" + "titel=" + titel + ", interpret=" + interpret + ", album=" + album + ", jahr=" + jahr + ", kommentar=" + kommentar + ", track=" + track + ", genre=" + genre + '}';
        } else {
            return "Song{pfad=" + pfad + "}";
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.pfad);
        hash = 29 * hash + Objects.hashCode(this.titel);
        hash = 29 * hash + Objects.hashCode(this.interpret);
        hash = 29 * hash + Objects.hashCode(this.album);
        hash = 29 * hash + Objects.hashCode(this.jahr);
        hash = 29 * hash + Objects.hashCode(this.kommentar);
        hash = 29 * hash + Objects.hashCode(this.track);
        hash = 29 * hash + this.genre;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Song other = (Song) obj;
        if (!Objects.equals(this.pfad, other.pfad)) {
            return false;
        }
        if (!Objects.equals(this.titel, other.titel)) {
            return false;
        }
        if (!Objects.equals(this.interpret, other.interpret)) {
            return false;
        }
        if (!Objects.equals(this.album, other.album)) {
            return false;
        }
        if (!Objects.equals(this.jahr, other.jahr)) {
            return false;
        }
        if (!Objects.equals(this.kommentar, other.kommentar)) {
            return false;
        }
        if (!Objects.equals(this.track, other.track)) {
            return false;
        }
        if (this.genre != other.genre) {
            return false;
        }
        return true;
    }

    /**
     * Statische Methode, um ein Song-Objekt aus einer MP3-Datei zu erzeugen
     *
     * @param mp3 die MP3-Datei
     * @return ein Song-Objekt
     * @throws IOException wenn Fehler beim Lesen auftreten
     * @throws IllegalArgumentException wenn mp3 keine lesbare Datei ist
     */
    public static Song ausMP3(File mp3) throws IOException {
        if (mp3 == null || !mp3.exists() || !mp3.isFile() || !mp3.canRead()) {
            throw new IllegalArgumentException("mp3 muss eine lesbare Datei sein.");
        }
        Song song = new Song();
        song.pfad = mp3.getAbsolutePath();
        try (InputStream in = new BufferedInputStream(new FileInputStream(mp3))) {
            //Springe zu den letzten 128 Byte der Datei
            in.skip(mp3.length() - 128);
            //Lies 3 byte
            byte[] buffer = new byte[3];
            in.read(buffer);
            //Prüfe, ob die dem ID3v1-Intro entsprechen
            if (Arrays.equals(buffer, TAG)) {
                //Falls ja, das Tag lesen
                fuelleSongAusStream(song, in);
                return song;
            } else {
                //Sonst null zurückgeben
                return null;
            }
        }
    }

    /**
     * Die Daten aus dem ID3-Tag lesen. 
     * @param song das zu füllende Song-Objekt
     * @param in  ein InputStream, der nach dem TAG-Intro positioniert ist
     * @throws IOException 
     */
    private static void fuelleSongAusStream(Song song, InputStream in) throws IOException {
        byte[] buffer = new byte[30];
        //Lies den Titel (30 byte)
        in.read(buffer);
        song.setTitel(new String(buffer, ISO_8859_1).trim());
        //Lies den Interpret (30 byte)
        in.read(buffer);
        song.setInterpret(new String(buffer, ISO_8859_1).trim());
        //Lies das Album (30 byte)
        in.read(buffer);
        song.setAlbum(new String(buffer, ISO_8859_1).trim());
        //Lies die Jahreszahl (4 byte)
        in.read(buffer, 0, 4);
        String jahrAlsString = new String(buffer, 0, 4, ISO_8859_1);
        if (jahrAlsString.matches("\\d{4}")) {
            song.setJahr(Integer.parseInt(jahrAlsString));
        }
        //Lies die verbleibenden 30 Zeichen
        in.read(buffer);
        //steht an vorletzter Stelle ein 0-byte, dann steht an letzter die Track-Nummer
        if (buffer[28] == 0) {
            //Track-Nummer vorhanden
            song.setKommentar(new String(buffer, 0, 28, ISO_8859_1).trim());
            song.setTrack(Integer.valueOf(buffer[29]));
        } else {
            //Track-Nummer nicht vorhanden
            song.setKommentar(new String(buffer, ISO_8859_1).trim());
            song.setTrack(null);
        }
        //Lies das Genre (einzelnes Byte)
        song.setGenre((byte) in.read());
    }
}
