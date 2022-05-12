package test;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Kap7.BMI;

public class BMITest {

    @Test
    public void BMICalcNormNumber() {
        assertEquals(22, BMI.getBMI(178, 70), 0.1);
    }

    @Test
    public void extremGross() {
        assertEquals(10.42, BMI.getBMI(480, 240), 0.1);
    }

    @Test
    public void extremSchwer() {
        assertEquals(214.62, BMI.getBMI(178, 680), 0.1);
    }

    @Test
    public void BMICalcUntrText() {
        assertEquals("Untergewicht", BMI.bmiZuKategorie(0.1));
        assertEquals("Untergewicht", BMI.bmiZuKategorie(18.49));
    }

    @Test
    public void BMICalcNormText() {
        assertEquals("Normalgewicht", BMI.bmiZuKategorie(18.5));
        assertEquals("Normalgewicht", BMI.bmiZuKategorie(24.99));
    }

    @Test
    public void BMICalcUeberText() {
        assertEquals("Übergewicht", BMI.bmiZuKategorie(25));
        assertEquals("Übergewicht", BMI.bmiZuKategorie(29.99));
    }

    @Test
    public void BMICalcStUeText() {
        assertEquals("starkes Übergewicht", BMI.bmiZuKategorie(80));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ungueligeWert1() {
        BMI.bmiZuKategorie(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ungueligeWert2() {
        BMI.getBMI(0, 70);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ungueligeWert3() {
        BMI.getBMI(178, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ungueligeWert4() {
        BMI.getBMI(0, 0);
    }
}