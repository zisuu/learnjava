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
}