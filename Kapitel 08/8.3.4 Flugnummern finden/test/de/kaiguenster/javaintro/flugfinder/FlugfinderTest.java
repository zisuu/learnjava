package de.kaiguenster.javaintro.flugfinder;

import org.junit.Test;
import static org.junit.Assert.*;

public class FlugfinderTest {
    
    @Test
    public void keineFlugnummer() {
        String[] testArray = new String[]{"Hier ist keine Nummer", "Hier auch nicht", "Und hier schon gar nicht"};
        assertNull(Flugfinder.findeFlugnummer(testArray));
    }

    @Test
    public void eineFlugnummer() {
        String[] testArray = new String[]{"Hier ist keine Nummer", "Hier auch nicht", "Aber LH-1234 hier"};
        assertEquals("LH-1234", Flugfinder.findeFlugnummer(testArray));
    }

    
}
