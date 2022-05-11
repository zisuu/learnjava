package test;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Kap4.GGT;

public class GGTTest {

    @Test
    public void keinTeiler() {
        assertEquals(1, GGT.ggt(13, 17));
    }

    @Test
    public void teilerIstParam1() {
        assertEquals(7, GGT.ggt(7, 42));
    }
    
    @Test
    public void teilerIstParam2() {
        assertEquals(7, GGT.ggt(42, 7));
    }    
    
    @Test
    public void teilerExistiert() {
        assertEquals(14, GGT.ggt(42, 28));
    }

    @Test
    public void param1istNull() {
        assertEquals(8, GGT.ggt(0, 8));
    }

    @Test
    public void param2istNull() {
        assertEquals(3, GGT.ggt(3, 0));
    } 

    @Test
    public void beideZahlenGleich() {
        assertEquals(5, GGT.ggt(5, 5));
    }      
}