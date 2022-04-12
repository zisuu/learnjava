package de.kaiguenster.javaintro.pythagoras;

import org.junit.Test;
import static org.junit.Assert.*;

public class PythagorasTest {
    
    public PythagorasTest() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void katheteAGleich0() {
        Pythagoras.berechneHypotenuse(0, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void katheteBGleich0() {
        Pythagoras.berechneHypotenuse(3, 0);
    }

    @Test
    public void ganzzahligesErgebnis() {
        //double-Werte können nicht exakt verglichen werden, deswegen wird geprüft, ob das Ergebnis mit ein wenig Toleranz richtig ist
        assertEquals(5d, Pythagoras.berechneHypotenuse(3, 4), 0.000001);
    }

    @Test
    public void fliesskommaErgebnis() {
        assertEquals(6.40312, Pythagoras.berechneHypotenuse(4, 5), 0.00001);
    }

    @Test()
    public void notANumber() {
        assertEquals(Double.NaN, Pythagoras.berechneHypotenuse(4, Double.NaN), 0.000001);
    }
    
}
