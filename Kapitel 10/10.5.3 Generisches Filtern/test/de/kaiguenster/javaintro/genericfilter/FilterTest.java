package de.kaiguenster.javaintro.genericfilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import static org.junit.Assert.*;
import org.junit.Test;

public class FilterTest {
    
    @Test
    public void testUngeradeZahlenFilter() {
        Collection<Integer> zahlen= new HashSet<>();
        zahlen.add(3);
        zahlen.add(4);
        zahlen.add(18);
        zahlen.add(37);
        Filter.wendeFilterAn(zahlen, new UngeradeZahlenFilter());
        assertEquals(2, zahlen.size());
        assertTrue(zahlen.contains(4));
        assertTrue(zahlen.contains(18));
    }

    @Test
    public void testKurzeStringsFilter() {
        Collection<String> strings = new ArrayList<>();
        strings.add("1234567890AB");
        strings.add("123");
        strings.add("1234567890ABCDE");
        strings.add("123456");
        Filter.wendeFilterAn(strings, new KurzeStringsFilter());
        assertEquals(2, strings.size());
        assertTrue(strings.contains("1234567890AB"));
        assertTrue(strings.contains("1234567890ABCDE"));
    }    
    
}
