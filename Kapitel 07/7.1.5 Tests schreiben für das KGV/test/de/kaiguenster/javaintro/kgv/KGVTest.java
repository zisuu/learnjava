package de.kaiguenster.javaintro.kgv;

import org.junit.Test;
import static org.junit.Assert.*;

public class KGVTest {

    @Test
    public void zahl1Ist1() {
        //Zahl 1 ist 1
        assertEquals(17, KGV.kgv(1, 17));
    }

    @Test
    public void zahl2Ist1() {
        //Zahl 2 ist 1
        assertEquals(13, KGV.kgv(13, 1));
    }
    
    @Test
    public void zahl1IstVielfaches() {
        //Zahl 1 ist ein Vielfaches von Zahl 2
        assertEquals(24, KGV.kgv(24, 6));
    }

    @Test
    public void zahl2IstVielfaches() {
        //Zahl 2 ist ein Vielfaches von Zahl 1
        assertEquals(24, KGV.kgv(4, 24));
    }

    @Test
    public void gemeinsamerTeiler() {
        //beide Zahlen haben einen gemeinsamen Teiler
        assertEquals(36, KGV.kgv(9, 12));
    }    
    
    @Test
    public void teilferfremdeZahlen() {
        //beide Zahlen haben keine gemeinsamen Teiler
        assertEquals(221, KGV.kgv(17, 13));
    }
    
    @Test
    public void gleicheZahlen() {
        //Zahlen sind gleich
        assertEquals(17, KGV.kgv(17, 17));
    }    
    
    @Test(expected = ArithmeticException.class)
    public void testUeberlauf(){
        //Überlauf-Szenario
        KGV.kgv(Integer.MAX_VALUE, Integer.MAX_VALUE - 1);
    }
}
