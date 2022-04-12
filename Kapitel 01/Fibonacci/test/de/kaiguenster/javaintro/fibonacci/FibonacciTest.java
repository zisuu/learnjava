package de.kaiguenster.javaintro.fibonacci;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kai
 */
public class FibonacciTest {
    
    /**
     * Test of fibonacci method, of class Fibonacci.
     */
    @Test
    public void testFibonacci() {
        assertEquals(0, Fibonacci.fibonacci(0));
        assertEquals(1, Fibonacci.fibonacci(1));
        assertEquals(1, Fibonacci.fibonacci(2));
        assertEquals(2, Fibonacci.fibonacci(3));
        assertEquals(3, Fibonacci.fibonacci(4));
        assertEquals(5, Fibonacci.fibonacci(5));
        assertEquals(8, Fibonacci.fibonacci(6));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumber(){
        Fibonacci.fibonacci(-1);
    }
   
}
