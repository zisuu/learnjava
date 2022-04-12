package de.kaiguenster.javaintro.fahrzeuge;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LieferwagenTest {
    
    private Lieferwagen testeMich;
    
    @Before
    public void baueLieferwagen(){
        testeMich = new Lieferwagen("Testwagen", 80, 3);
    }
    
    @Test
    public void transport() {
        assertNull(testeMich.pruefeLadung());
        testeMich.lade("1 Tonne Kaffeebohnen");
        assertEquals("1 Tonne Kaffeebohnen", testeMich.pruefeLadung());
        assertEquals("1 Tonne Kaffeebohnen", testeMich.entlade());
        assertNull(testeMich.pruefeLadung());
    }
    
}
