package de.kaiguenster.javaintro.musikfinder;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class PlaylistTest {

    @Test
    public void testAddUndGet() {
        Playlist testeMich = new Playlist();
        final Song song1 = erzeugeSong("/tmp/test1.mp3", "Titel 1", "Interpret 1", "Album 1", 1993, "", 2, (byte)1);
        final Song song2 = erzeugeSong("/tmp/test2.mp3", "Titel 2", "Interpret 2", "Album 2", 1984, "", 5, (byte)3);
        testeMich.addSong(song1);
        testeMich.addSong(song2);
        List<Song> inhalt = testeMich.getSongs();
        assertEquals(0, inhalt.indexOf(song1));
        assertEquals(1, inhalt.indexOf(song2));
    }
   
    @Test
    public void testSchreibe() throws IOException{
        Playlist testeMich = new Playlist();
        final Song song1 = erzeugeSong("/tmp/test1.mp3", "Titel 1", "Interpret 1", "Album 1", 1993, "", 2, (byte)1);
        final Song song2 = erzeugeSong("/tmp/test2.mp3", "Titel 2", "Interpret 2", "Album 2", null, "", null, (byte)3);
        testeMich.addSong(song1);
        testeMich.addSong(song2);
        StringWriter writer = new StringWriter();
        testeMich.schreibe(writer);
        assertEquals("/tmp/test1.mp3|Titel 1|Interpret 1|Album 1|1993||2|1" + System.lineSeparator() + "/tmp/test2.mp3|Titel 2|Interpret 2|Album 2||||3" + System.lineSeparator() , writer.toString());
    }
    
    @Test
    public void testAusVerzeichnis() throws IOException{
        File verzeichnis = erzeugeTempVerzeichnis(null);
        File mp3 = erzeugeTempFile(verzeichnis, ".mp3");
        File nichtMp3 = erzeugeTempFile(verzeichnis, ".txt");
        File unterverzeichnis = erzeugeTempVerzeichnis(verzeichnis);
        File mp3inUnterverzeichnis = erzeugeTempFile(unterverzeichnis, ".mp3");

        Playlist testeMich = Playlist.ausVerzeichnis(verzeichnis);
        List<Song> inhalt = testeMich.getSongs();
        assertEquals(2, inhalt.size());
        assertTrue(inhalt.contains(erzeugeSong(mp3.getAbsolutePath(), null, null, null, null, null, null, (byte)0)));
        assertTrue(inhalt.contains(erzeugeSong(mp3inUnterverzeichnis.getAbsolutePath(), null, null, null, null, null, null, (byte)0)));
    }
    
    @Test 
    public void testLese() throws IOException{
        Reader quelle = new StringReader("/tmp/test1.mp3|Titel 1|Interpret 1|Album 1|1993||2|1\n/tmp/test2.mp3|Titel 2|Interpret 2|Album 2||||3\n");
        Playlist testeMich = Playlist.lese(quelle);
        List<Song> inhalt = testeMich.getSongs();
        assertEquals(0, inhalt.indexOf(erzeugeSong("/tmp/test1.mp3", "Titel 1", "Interpret 1", "Album 1", 1993, "", 2, (byte)1)));
        assertEquals(1, inhalt.indexOf(erzeugeSong("/tmp/test2.mp3", "Titel 2", "Interpret 2", "Album 2", null, "", null, (byte)3)));
    }
    
    @Test 
    public void testVerifiziere() throws IOException{
        File verzeichnis = erzeugeTempVerzeichnis(null);
        File mp3 = erzeugeTempFile(verzeichnis, ".mp3");
        File nichtMp3 = erzeugeTempFile(verzeichnis, ".txt");
        File unterverzeichnis = erzeugeTempVerzeichnis(verzeichnis);
        File mp3inUnterverzeichnis = erzeugeTempFile(unterverzeichnis, ".mp3");

        Playlist testeMich = Playlist.ausVerzeichnis(verzeichnis);
        testeMich.addSong(erzeugeSong(new File(verzeichnis + "gibtEsNicht.mp3").getAbsolutePath(), null, null, null, null, null, null, (byte)0));
        assertEquals(1, testeMich.verifiziere());
        List<Song> inhalt = testeMich.getSongs();
        assertEquals(2, inhalt.size());
        assertTrue(inhalt.contains(erzeugeSong(mp3.getAbsolutePath(), null, null, null, null, null, null, (byte)0)));
        assertTrue(inhalt.contains(erzeugeSong(mp3inUnterverzeichnis.getAbsolutePath(), null, null, null, null, null, null, (byte)0)));
    }
    
    private File erzeugeTempVerzeichnis(File parent) throws IOException{
        File verzeichnis;
        if (parent == null){
            verzeichnis = Files.createTempDirectory(getClass().getName()).toFile();
        } else {
            verzeichnis = Files.createTempDirectory(parent.toPath(), getClass().getName()).toFile();
        }
        verzeichnis.deleteOnExit();
        return verzeichnis;
    }
    
    private File erzeugeTempFile(File parent, String endung) throws IOException{
        File datei = File.createTempFile(getClass().getName(), endung, parent);
        datei.deleteOnExit();
        return datei;
    }
    
    private Song erzeugeSong(String pfad, String titel, String interpret, String album, Integer jahr, String kommentar, Integer track, byte genre){
        Song song = new Song();
        song.setPfad(pfad);
        song.setTitel(titel);
        song.setInterpret(interpret);
        song.setAlbum(album);
        song.setJahr(jahr);
        song.setKommentar(kommentar);
        song.setTrack(track);
        song.setGenre(genre);
        return song;
    }
}
