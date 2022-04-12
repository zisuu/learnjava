package de.kaiguenster.javaintro.roemischezahlen;

import org.junit.Test;
import static org.junit.Assert.*;

public class RoemischeZahlTest {
    
    @Test
    public void ohneSubtraktion() {
        assertEquals(1666, RoemischeZahl.zuZahl("MDCLXVI"));
    }

    @Test
    public void einerMitSubtraktion() {
        assertEquals(999, RoemischeZahl.zuZahl("CMXCIX"));
    }

    @Test
    public void fuenferMitSubtraktion() {
        assertEquals(444, RoemischeZahl.zuZahl("CDXLIV"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void falscheReihenfolge() {
        RoemischeZahl.zuZahl("MMIC");
    }

    @Test(expected = IllegalArgumentException.class)
    public void zuVieleWiederholungen() {
        RoemischeZahl.zuZahl("CCCC");
    }

    @Test
    public void nichtZuVieleWiederholungenTausender() {
        assertEquals(4000, RoemischeZahl.zuZahl("MMMM"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void zuVieleWiederholungenFuenfer() {
        RoemischeZahl.zuZahl("VV");
    }

    @Test(expected = IllegalArgumentException.class)
    public void zuVieleWiederholungenSubtraktion() {
        RoemischeZahl.zuZahl("IVIV");
    }

    @Test(expected = IllegalArgumentException.class)
    public void neunerUndFuenfer() {
        RoemischeZahl.zuZahl("IXV");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void neunerUndEiner() {
        RoemischeZahl.zuZahl("IXI");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void fuenferUndEiner() {
        RoemischeZahl.zuZahl("IVI");
    }
    
}
