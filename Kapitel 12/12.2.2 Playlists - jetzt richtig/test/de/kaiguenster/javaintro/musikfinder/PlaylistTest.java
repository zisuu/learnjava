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
    
    public PlaylistTest() {
    }

    @Test
    public void testAddUndGet() {
        Playlist testeMich = new Playlist();
        testeMich.addSong("/tmp/test1.mp3");
        testeMich.addSong("/tmp/test2.mp3");
        List<String> inhalt = testeMich.getSongs();
        assertEquals(0, inhalt.indexOf("/tmp/test1.mp3"));
        assertEquals(1, inhalt.indexOf("/tmp/test2.mp3"));
    }
   
    @Test
    public void testSchreibe() throws IOException{
        Playlist testeMich = new Playlist();
        testeMich.addSong("/tmp/test1.mp3");
        testeMich.addSong("/tmp/test2.mp3");
        StringWriter writer = new StringWriter();
        testeMich.schreibe(writer);
        assertEquals("/tmp/test1.mp3\r\n/tmp/test2.mp3\r\n", writer.toString());
    }
    
    @Test
    public void testAusVerzeichnis() throws IOException{
        File verzeichnis = erzeugeTempVerzeichnis(null);
        File mp3 = erzeugeTempFile(verzeichnis, ".mp3");
        File nichtMp3 = erzeugeTempFile(verzeichnis, ".txt");
        File unterverzeichnis = erzeugeTempVerzeichnis(verzeichnis);
        File mp3inUnterverzeichnis = erzeugeTempFile(unterverzeichnis, ".mp3");

        Playlist testeMich = Playlist.ausVerzeichnis(verzeichnis);
        List<String> inhalt = testeMich.getSongs();
        assertEquals(2, inhalt.size());
        assertTrue(inhalt.contains(mp3.getAbsolutePath()));
        assertTrue(inhalt.contains(mp3inUnterverzeichnis.getAbsolutePath()));
    }
    
    @Test 
    public void testLese() throws IOException{
        Reader quelle = new StringReader("/tmp/test1.mp3\n/tmp/test2.mp3\n");
        Playlist testeMich = Playlist.lese(quelle);
        List<String> inhalt = testeMich.getSongs();
        assertEquals(0, inhalt.indexOf("/tmp/test1.mp3"));
        assertEquals(1, inhalt.indexOf("/tmp/test2.mp3"));
    }
    
    @Test 
    public void testVerifiziere() throws IOException{
        File verzeichnis = erzeugeTempVerzeichnis(null);
        File mp3 = erzeugeTempFile(verzeichnis, ".mp3");
        File nichtMp3 = erzeugeTempFile(verzeichnis, ".txt");
        File unterverzeichnis = erzeugeTempVerzeichnis(verzeichnis);
        File mp3inUnterverzeichnis = erzeugeTempFile(unterverzeichnis, ".mp3");

        Playlist testeMich = Playlist.ausVerzeichnis(verzeichnis);
        testeMich.addSong(new File(verzeichnis + "gibtEsNicht.mp3").getAbsolutePath());
        assertEquals(1, testeMich.verifiziere());
        List<String> inhalt = testeMich.getSongs();
        assertEquals(2, inhalt.size());
        assertTrue(inhalt.contains(mp3.getAbsolutePath()));
        assertTrue(inhalt.contains(mp3inUnterverzeichnis.getAbsolutePath()));
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
}
