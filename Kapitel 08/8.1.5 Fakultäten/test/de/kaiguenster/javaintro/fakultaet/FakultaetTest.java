package de.kaiguenster.javaintro.fakultaet;

import java.math.BigInteger;
import static org.junit.Assert.*;
import org.junit.Test;

public class FakultaetTest {

    @Test(expected = IllegalArgumentException.class)
    public void long0() {
        Fakultaet.fakultaetLong(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bigInt0() {
        Fakultaet.fakultaetBigInteger(BigInteger.ZERO);
    }
    
    @Test
    public void long6() {
        assertEquals(720, Fakultaet.fakultaetLong(6));
    }

    @Test
    public void bigInt6() {
        assertEquals(BigInteger.valueOf(720), Fakultaet.fakultaetBigInteger(BigInteger.valueOf(6)));
    }
    
}
