package de.kaiguenster.javaintro.musikfinder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.*;
import org.junit.Test;

public class SongTest {


    @Test
    public void testAusMP3() throws IOException {
        File tempFile = File.createTempFile(getClass().getName(), ".mp3");
        tempFile.deleteOnExit();
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(tempFile))){
            out.write("Etwas Datenmüll, nur damit der Tag nicht am Anfang steht".getBytes("ISO-8859-1"));
            out.write("TAGTitel                         Interpret                     Album                         2014Kommentar                   ".getBytes("ISO-8859-1"));
            out.write(0);
            out.write(2);
            out.write(75);
        }
        Song testeMich = Song.ausMP3(tempFile);
        assertEquals(tempFile.getAbsolutePath(), testeMich.getPfad());
        assertEquals("Titel", testeMich.getTitel());
        assertEquals("Interpret", testeMich.getInterpret());
        assertEquals("Album", testeMich.getAlbum());
        assertEquals(2014, testeMich.getJahr().intValue());
        assertEquals("Kommentar", testeMich.getKommentar());
        assertEquals(2, testeMich.getTrack().intValue());
        assertEquals(75, testeMich.getGenre());
    }
    
}
