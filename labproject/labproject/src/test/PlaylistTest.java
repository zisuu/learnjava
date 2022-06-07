package test;

import app.Kap12.Playlist;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

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
}
