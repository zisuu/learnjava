package de.kaiguenster.javaintro.ggt;

import org.junit.Test;
import static org.junit.Assert.*;

public class GGTTest {

    @Test
    public void keinTeiler() {
        //Es gibt keinen gemeinsamen Teiler
        assertEquals(1, GGT.ggt(13, 17));
    }

    @Test
    public void teilerIstParam1() {
        //Zahl 1 ist bereits der GGT
        assertEquals(7, GGT.ggt(7, 42));
    }
    
    @Test
    public void teilerIstParam2() {
        //Zahl 2 ist bereits der GGT
        assertEquals(7, GGT.ggt(42, 7));
    }    
    
    @Test
    public void teilerExistiert() {
        //Es gibt einen gemeinsamen Teiler.
        assertEquals(14, GGT.ggt(42, 28));
    }    
    
    @Test
    public void param1Ist0() {
        //Zahl 1 ist 0
        assertEquals(3, GGT.ggt(0, 3));
    }      

    @Test
    public void param2Ist0() {
        //Zahl 2 ist 0
        assertEquals(3, GGT.ggt(3, 0));
    }      
    
    @Test
    public void beideZahlenGleich() {
        //Beide Zahlen sind gleich
        assertEquals(5, GGT.ggt(5, 5));
    }      
    
    
}
