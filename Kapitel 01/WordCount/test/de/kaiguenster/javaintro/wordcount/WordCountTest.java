/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.kaiguenster.javaintro.wordcount;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Kai
 */
public class WordCountTest {
    
    @Test
    public void testCount() throws UnsupportedEncodingException {
        WordCount wc = new WordCount(new ByteArrayInputStream("wort wort wort".getBytes("UTF-8")));
        assertEquals(3, wc.getTotalCount());
        assertEquals(3, wc.getCount("wort"));
        assertEquals(0, wc.getCount("nichts"));
    }
    
}
