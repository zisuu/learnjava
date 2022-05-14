package test;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Kap8.Fakultaet;

public class FakultaetTest {

    @Test
    public void TestLongNormal() {
        assertEquals(6L, Fakultaet.berechneFakultaetLong(3), 0.000001);
    }

    @Test
    public void TestLongLimit() {
        assertEquals(2432902008176640000L, Fakultaet.berechneFakultaetLong(20), 0.000001);
    }

        @Test(expected = IllegalArgumentException.class)
    public void TestLongNull() {
        Fakultaet.berechneFakultaetLong(0);
    }

    // @Test()
    // public void notANumber() {
    //     assertEquals(Double.NaN, Pythagoras.getHypotenuse(4, Double.NaN), 0.000001);
    // }


    
    // @Test(expected = IllegalArgumentException.class)
    // public void zahl2Null() {
    //     Pythagoras.getHypotenuse(12,0);
    // }
    
    // @Test(expected = ArithmeticException.class)
    // public void testUeberlauf(){
    //     //Überlauf-Szenario
    //     Pythagoras.getHypotenuse(Double.MAX_VALUE, Double.MAX_VALUE);
    // }
}
