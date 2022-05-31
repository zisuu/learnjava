package test;

import app.Kap10.Lieblingslieder;
import app.Kap10.Musiksammlung;
import app.Kap10.Song;
import static org.junit.Assert.*;
import org.junit.Test;

public class LieblingsliederTest {

    @Test
    public void testLieblingslieder() {
        Song song1 = new Song("Titel1", "Interpret1", 120);
        Lieblingslieder songs = new Lieblingslieder();
        songs.fuegeHinzu("Hans", song1);
        for (Song s : songs.getList("Hans")) {
            assertEquals(song1, s);
        }
        songs.leereListe("Hans");
        Song song2 = new Song("Titel2", "Interpret2", 240);
        songs.fuegeHinzu("Hans", song2);
        for (Song s : songs.getList("Hans")) {
                assertEquals(song2, s);
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
