package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;

import org.junit.Test;
import app.Kap12.DateiLeser;

public class DateiTester {

    @Test
    public void testMitDatei() throws IOException {
        File tempDatei = File.createTempFile(getClass().getName(), ".mp3");
        tempDatei.deleteOnExit();
        // Test durchführen
    }

    @Test
    public void testMitVerzeichnis() throws IOException {
        File tempVerzeichnis = Files.createTempDirectory("mp3test").toFile();
        tempVerzeichnis.deleteOnExit();
        File tempDatei = File.createTempFile(getClass().getName(), ".mp3",
                tempVerzeichnis);
        tempDatei.deleteOnExit();
        // Test durchführen
    }
}
