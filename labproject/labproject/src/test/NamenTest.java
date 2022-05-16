package test;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Kap8.Namen;

public class NamenTest {
    @Test(expected = IllegalArgumentException.class)
    public void keineEingabe() {
        Namen.validateName("");
        Namen.validateName("Hans Fischer");
        Namen.validateName("Hans, Fischer,");
        Namen.validateName("Fischer,Hans");
    }

    @Test
    public void Normal() {
        assertEquals("Hans Fischer", Namen.validateName("Fischer, Hans"));
    }

    @Test
    public void DoppelNamen() {
        assertEquals("Hans Peter Fischer", Namen.validateName("Fischer, Hans Peter"));
    }

    
}
