package de.kaiguenster.javaintro.zahlenselektor;

import org.junit.Test;
import static org.junit.Assert.*;

public class ZahlenSelektorTest {

    @Test
    public void erste30Zahlen() {
        //Dieser Selektor akzeptiert alle Zahlen
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, ZahlenSelektor.findeErsteN(zahl -> true, 10));
    }

    @Test
    public void testDurchSiebenTeilbar() {
        //Dieser Selektor akzeptiert Zahlen, die durch 7 teilbar sind
        assertArrayEquals(new int[]{7, 14, 21, 28, 35, 42, 49, 56, 63, 70}, ZahlenSelektor.findeErsteN(zahl -> zahl % 7 == 0, 10));
    }

    @Test
    public void testPrimzahlen() {
        /*
        Dieser Selektor akzeptiert Primzahlen. Da Lambda-Ausdrücke keinen Zustand 
        halten können, wird hier nicht das Sieb des Erastosthenes eingesetzt - für 
        produktiven Code wäre diese Lösung besser, würde aber dann keinen Lambda-Ausdruck
        demonstrieren.
        */
        assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29}, ZahlenSelektor.findeErsteN(zahl -> {
            if (zahl < 2) {
                return false;
            }
            //Für alle kleineren Zahlen prüfen, ob sie zahl teilen.
            for (int i = 2; i < zahl; i++) {
                if (zahl % i == 0) {
                    return false;
                }
            }
            return true;
        }, 10));
    }

    @Test
    public void testZuWenigErgebnisse() {
        assertArrayEquals(new int[]{1}, ZahlenSelektor.findeErsteN(zahl -> zahl == 1, 3));
    }
}
