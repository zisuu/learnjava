package test;

import static org.junit.Assert.*;

import java.math.BigInteger;

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

    @Test
    public void TestBigIntNormal() {
        assertEquals(BigInteger.valueOf(39916800), Fakultaet.berechneFakultaetBigInt(BigInteger.valueOf(11)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestBigIntNull() {
        Fakultaet.berechneFakultaetBigInt(BigInteger.ZERO);
    }
}
