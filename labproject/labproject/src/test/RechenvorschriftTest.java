package test;

import app.Kap11.Rechenvorschrift;
import static org.junit.Assert.*;


import org.junit.Test;

/**
 * Verwenden Sie diese Methode, um:
 * - alle Werte der Eingabe zu verdoppeln,
 * - alle Werte der Eingabe zu quadrieren,
 * - den Betrag aller Werte der Eingabe zu berechnen und
 * - alle Werte auf den nächsten Zehner zu runden.
 */
public class RechenvorschriftTest {

    @Test
    public void testVerdopple() {
        int[] test = new int[]{1,2,3,4};
        assertArrayEquals(new int[]{2, 4, 6, 8}, Rechenvorschrift.findeErgebnisse(test, i -> 2*i));
    }

    @Test
    public void testQuadriere() {
        int[] test = new int[]{1,2,3,4};
        assertArrayEquals(new int[]{1, 4, 9, 16}, Rechenvorschrift.findeErgebnisse(test, i -> i*i));
    }

    @Test
    public void testSummiere() {
        int[] test = new int[]{-1,2,-4};
        assertArrayEquals(new int[]{1, 2, 4}, Rechenvorschrift.findeErgebnisse(test, Math::abs));
    }

    @Test 
    public void testNächsterZehner(){
        //Runde alle Zahlen auf den nächsten Zehner
        assertArrayEquals(new int[]{-20, -10, -10, 10, 20, 90, 170}, Rechenvorschrift.findeErgebnisse(new int[]{-17, -13, -6, 13, 17, 94, 166}, i -> {
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
