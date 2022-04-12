/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.kaiguenster.javaintro.reverse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kai
 */
public class ReverseTest {
    
    /**
     * Test of reverse method, of class Reverse.
     */
    @Test
    public void testReverse() {
        assertEquals("!tleW ,ollaH", Reverse.reverse("Hallo, Welt!"));
    }
}
