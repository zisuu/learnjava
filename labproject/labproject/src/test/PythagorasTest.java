package test;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Kap8.Pythagoras;

public class PythagorasTest {

    @Test
    public void ganzahligesErgebnis() {
        assertEquals(5d, Pythagoras.getHypotenuse(3, 4), 0.000001);
    }

    @Test
    public void fliesskommaErgebnis() {
        assertEquals(6.40312, Pythagoras.getHypotenuse(4, 5), 0.00001);
    }

    @Test()
    public void notANumber() {
        assertEquals(Double.NaN, Pythagoras.getHypotenuse(4, Double.NaN), 0.000001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zahl1Null() {
        Pythagoras.getHypotenuse(0,12);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void zahl2Null() {
        Pythagoras.getHypotenuse(12,0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testUeberlauf(){
        //Überlauf-Szenario
        Pythagoras.getHypotenuse(Double.MAX_VALUE, Double.MAX_VALUE);
    }
}