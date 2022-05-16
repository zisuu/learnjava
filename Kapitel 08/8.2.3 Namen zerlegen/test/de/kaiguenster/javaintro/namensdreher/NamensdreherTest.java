package de.kaiguenster.javaintro.namensdreher;

import org.junit.Test;
import static org.junit.Assert.*;

public class NamensdreherTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void dreheNull() {
        Namensdreher.dreheNamen(null);
    }
    
    @Test
    public void einKomma(){
        assertEquals("Sherlock Holmes", Namensdreher.dreheNamen("Holmes, Sherlock"));
    }
    
    @Test
    public void keinKomma(){
        assertEquals("Mycroft Holmes", Namensdreher.dreheNamen("Mycroft Holmes"));
    }
    
    @Test
    public void zweiKommas(){
        assertEquals("Dr. John Watson", Namensdreher.dreheNamen("Watson, John, Dr."));
    }

}
