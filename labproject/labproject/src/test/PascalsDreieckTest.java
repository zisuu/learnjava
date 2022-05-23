package test;

import java.util.Arrays;
import java.util.Comparator;
import static org.junit.Assert.*;
import org.junit.Test;
import app.Kap10.PascalsDreieck;

public class PascalsDreieckTest {
    
    @Test
    public void test() {
        PascalsDreieck dreieck = new PascalsDreieck(10);
        assertArrayEquals(new int[]{1}, dreieck.getZeile(0));
        assertArrayEquals(new int[]{1, 1}, dreieck.getZeile(1));
        assertArrayEquals(new int[]{1, 2, 1}, dreieck.getZeile(2));
        assertArrayEquals(new int[]{1, 3, 3, 1}, dreieck.getZeile(3));
        assertArrayEquals(new int[]{1, 4, 6, 4, 1}, dreieck.getZeile(4));
        assertArrayEquals(new int[]{1, 5, 10, 10, 5, 1}, dreieck.getZeile(5));
        assertArrayEquals(new int[]{1, 6, 15, 20, 15, 6, 1}, dreieck.getZeile(6));
        assertArrayEquals(new int[]{1, 7, 21, 35, 35, 21, 7, 1}, dreieck.getZeile(7));
        assertArrayEquals(new int[]{1, 8, 28, 56, 70, 56, 28, 8, 1}, dreieck.getZeile(8));
        assertArrayEquals(new int[]{1, 9, 36, 84, 126, 126, 84, 36, 9, 1}, dreieck.getZeile(9));
        assertArrayEquals(new int[]{1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1}, dreieck.getZeile(10));
        System.out.println(dreieck.toString());
    }

}
