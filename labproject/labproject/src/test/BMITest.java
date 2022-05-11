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
    public void BMICalcUntrText() {
        assertEquals("Untergewicht", BMI.bmiZuKategorie(1));
    }

    @Test
    public void BMICalcNormText() {
        assertEquals("Normalgewicht", BMI.bmiZuKategorie(22));
    }

    @Test
    public void BMICalcUeberText() {
        assertEquals("Übergewicht", BMI.bmiZuKategorie(29));
    }

    @Test
    public void BMICalcStUeText() {
        assertEquals("starkes Übergewicht", BMI.bmiZuKategorie(80));
    }

    @Test(expected = IllegalArgumentException.class)
    public void BMIGewichtNull() {
        assertEquals(BMI.bmiZuKategorie(0));
    }
}