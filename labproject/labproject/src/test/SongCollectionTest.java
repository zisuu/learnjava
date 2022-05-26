package test;

import app.Kap10.Playlist;
import app.Kap10.Musiksammlung;
import app.Kap10.Song;
import static org.junit.Assert.*;
import org.junit.Test;

public class SongCollectionTest {

    @Test
    public void testPlaylist() {
        Song song1 = new Song("Titel1", "Interpret1", 120);
        Song song2 = new Song("Titel2", "Interpret2", 240);
        Playlist testMe = new Playlist();
        assertEquals(0, testMe.size());
        testMe.addSong(song1);
        assertEquals(1, testMe.size());
        testMe.addSong(song2);
        assertEquals(2, testMe.size());
        testMe.addSong(song1);
        assertEquals(3, testMe.size());
        testMe.removeSong(song2);
        assertEquals(2, testMe.size());

        for (Song s : testMe) {
            assertEquals(song1, s);
        }
    }

    @Test
    public void testMusiksammlung() {
        Song song1 = new Song("Titel1", "Interpret1", 120);
        Song song2 = new Song("Titel2", "Interpret2", 240);
        Musiksammlung testMe = new Musiksammlung();
        assertEquals(0, testMe.size());
        assertTrue(testMe.addSong(song1));
        assertEquals(1, testMe.size());
        assertTrue(testMe.addSong(song2));
        assertEquals(2, testMe.size());
        assertFalse(testMe.addSong(song1));
        assertEquals(2, testMe.size());
        testMe.removeSong(song2);
        assertEquals(1, testMe.size());

        for (Song s : testMe) {
            assertEquals(song1, s);
        }
    }

}
