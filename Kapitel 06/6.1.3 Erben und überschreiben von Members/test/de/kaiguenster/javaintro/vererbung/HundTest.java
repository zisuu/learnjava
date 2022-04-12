package de.kaiguenster.javaintro.vererbung;

import org.junit.Test;
import static org.junit.Assert.*;

public class HundTest {
    
    @Test
    public void testDackel() {
        Hund killer = new Dackel();
        assertEquals("Wuff!", killer.belle());
    }

    @Test
    public void testDobermann() {
        Hund princess = new Dobermann();
        assertEquals("Wuff!", princess.belle());
    }    
    
    @Test
    public void testChihuaha() {
        Hund fusshupe = new Chihuaha();
        assertEquals("Yip! Yip! Yip!", fusshupe.belle());
    }        
}
