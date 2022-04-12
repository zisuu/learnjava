package de.kaiguenster.javaintro.funktionen;

import org.junit.Test;
import static org.junit.Assert.*;

public class FunktionenTest {
    
    public FunktionenTest() {
    }

    @Test
    public void testVerdoppeln() {
        //Verdopple alle Zahlen
        assertArrayEquals(new int[]{2, 4, 6}, Funktionen.berechne(new int[]{1, 2, 3}, i -> 2*i));
    }
    
    @Test 
    public void testQuadrieren(){
        //Quadriere alle Zahlen
        assertArrayEquals(new int[]{1, 4, 9}, Funktionen.berechne(new int[]{1, 2, 3}, i -> i*i));
    }
    
    @Test 
    public void testBetrag(){
        //Bilde den Betrag aller Zahlen
        assertArrayEquals(new int[]{1, 2, 3}, Funktionen.berechne(new int[]{-1, 2, -3}, Math::abs));
    }
    
    @Test 
    public void testNächsterZehner(){
        //Runde alle Zahlen auf den nächsten Zehner
        assertArrayEquals(new int[]{-20, -10, -10, 10, 20, 90, 170}, Funktionen.berechne(new int[]{-17, -13, -6, 13, 17, 94, 166}, i -> {
            int letzteZiffer = i % 10;
            if (letzteZiffer < 0){
                //Durch diese Anweisung funktioniert der Algorithmus auch für negative Zahlen
                letzteZiffer += 10;
            }
            if (letzteZiffer < 5) return i - letzteZiffer;
            else return i + (10 - letzteZiffer);
        }));
    }

    
    
}
