package de.kaiguenster.javaintro.eratosthenes;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class SiebDesEratosthenesTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void negativ() {
        SiebDesEratosthenes.findePrimzahlen(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zuGross() {
        SiebDesEratosthenes.findePrimzahlen(100001);
    }
    
    @Test
    public void keineTreffer(){
        assertEquals(0, SiebDesEratosthenes.findePrimzahlen(0).length);
        assertEquals(0, SiebDesEratosthenes.findePrimzahlen(1).length);
    }

    @Test
    public void einTreffer(){
        int[] ergebnis = SiebDesEratosthenes.findePrimzahlen(2);
        assertEquals(1, ergebnis.length);
        assertEquals(2, ergebnis[0]);
    }

    @Test
    public void limit10(){
        int[] ergebnis = SiebDesEratosthenes.findePrimzahlen(10);
        assertArrayEquals(new int[]{2, 3, 5, 7}, ergebnis);
    }

    @Test
    public void limit100(){
        int[] ergebnis = SiebDesEratosthenes.findePrimzahlen(100);
        assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 
            41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97}, ergebnis);
    }    
    
    @Test
    public void limit100000(){
        int[] ergebnis = SiebDesEratosthenes.findePrimzahlen(100000);
        assertEquals(9592 ,ergebnis.length);
    }     
    
}
