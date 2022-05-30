package test;

import app.Kap11.ZahlenSelektor;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * die ersten zehn Zahlen, die durch 7 teilbar sind
 * die ersten zehn Primzahlen
 * die Zahlen von 1 bis 10
 */
public class ZahlenSelektorTest {


    @Test
    public void erste10Zahlen() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, ZahlenSelektor.findeErsteN(zahl -> true, 10));
    }

    @Test
    public void erste10ZahlenTeilbar7() {
    assertArrayEquals(new int[]{7, 14, 21, 28, 35, 42, 49, 56, 63, 70}, ZahlenSelektor.findeErsteN(zahl -> zahl %7 == 0, 10));
    }


    @Test
    public void erste10PrimZahlen() {
    assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29}, ZahlenSelektor.findeErsteN(zahl -> {
        if (zahl<2) {
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
