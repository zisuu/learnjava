package test;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Kap8.Flugnummern;

public class FlugnummernTest {


    @Test
    public void keineFlugnummer() {
        String[] testArray = new String[]{"Hier ist keine Nummer", "Hier auch nicht", "Und hier schon gar nicht"};
        assertNull(Flugnummern.findFlightNumber(testArray));
    }

    @Test
    public void eineFlugnummer() {
        String[] testArray = new String[]{"Hier ist keine Nummer", "Hier auch nicht", "Aber LH-1234 hier"};
        assertEquals("LH-1234", Flugnummern.findFlightNumber(testArray));

    }
}
