package test;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Kap10.Primzahlen;

public class PrimzahlenTest {
    @Test(expected = IllegalArgumentException.class)
    public void keineEingabe() {
        Primzahlen.calcPrim(-1);
        Primzahlen.calcPrim(100001);
    }

    @Test
    public void limit10(){
        int[] ergebnis = Primzahlen.calcPrim(10);
        assertArrayEquals(new int[]{2, 3, 5, 7}, ergebnis);
    }

    @Test
    public void limit100000(){
        int[] ergebnis = Primzahlen.calcPrim(100000);
        assertEquals(9592 ,ergebnis.length);
    }  
}
