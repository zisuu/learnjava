package test;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Kap8.RoemischeZahlen02;

public class RoemischeZahlen02Test {

    @Test
    public void ohneSubtraktion() {
        assertEquals(1666, RoemischeZahlen02.validateRomanString("MDCLXVI"));
    }

    @Test
    public void einerMitSubtraktion() {
        assertEquals(999, RoemischeZahlen02.validateRomanString("CMXCIX"));
    }

    @Test
    public void fuenferMitSubtraktion() {
        assertEquals(444, RoemischeZahlen02.validateRomanString("CDXLIV"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void falscheReihenfolge() {
        RoemischeZahlen02.validateRomanString("MMIC");
    }

    @Test(expected = IllegalArgumentException.class)
    public void zuVieleWiederholungen() {
        RoemischeZahlen02.validateRomanString("CCCC");
    }

    @Test
    public void nichtZuVieleWiederholungenTausender() {
        assertEquals(4000, RoemischeZahlen02.validateRomanString("MMMM"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void zuVieleWiederholungenFuenfer() {
        RoemischeZahlen02.validateRomanString("VV");
    }

    @Test(expected = IllegalArgumentException.class)
    public void zuVieleWiederholungenSubtraktion() {
        RoemischeZahlen02.validateRomanString("IVIV");
    }

    @Test(expected = IllegalArgumentException.class)
    public void neunerUndFuenfer() {
        RoemischeZahlen02.validateRomanString("IXV");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void neunerUndEiner() {
        RoemischeZahlen02.validateRomanString("IXI");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void fuenferUndEiner() {
        RoemischeZahlen02.validateRomanString("IVI");
    }
    
}
