package de.kaiguenster.javaintro.fahrzeuge;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AutoTest {
    
    private PKW testeMich;
    
    @Before
    public void baueAuto(){
        testeMich = new PKW("Testwagen", 100, 4);
    }
    
    @Test
    public void berechneFahrzeitNurMinuten() {
        assertEquals("45 Minute(n)", testeMich.berechneFahrzeitAlsString(75));
        assertEquals("30 Minute(n)", testeMich.berechneFahrzeitAlsString(50));
        assertEquals("1 Minute(n)", testeMich.berechneFahrzeitAlsString(100d/60));
        assertEquals("0 Minute(n)", testeMich.berechneFahrzeitAlsString(0));
    }

    @Test
    public void berechneFahrzeitStundenUndMinuten() {
        assertEquals("1 Stunde(n) 0 Minute(n)", testeMich.berechneFahrzeitAlsString(100));
        assertEquals("2 Stunde(n) 30 Minute(n)", testeMich.berechneFahrzeitAlsString(250));
        assertEquals("23 Stunde(n) 45 Minute(n)", testeMich.berechneFahrzeitAlsString(2375));
    }    

    @Test
    public void berechneFahrzeitTageStundenUndMinuten() {
        assertEquals("2 Tag(e) 6 Stunde(n) 30 Minute(n)", testeMich.berechneFahrzeitAlsString(5450));
    }     
    
}
