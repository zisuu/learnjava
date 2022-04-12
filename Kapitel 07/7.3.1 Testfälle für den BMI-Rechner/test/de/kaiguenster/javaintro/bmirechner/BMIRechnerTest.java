package de.kaiguenster.javaintro.bmirechner;

import org.junit.Test;
import static org.junit.Assert.*;

public class BMIRechnerTest {

    @Test(expected = IllegalArgumentException.class)
    public void kategorieUngueltig() {
        BMIRechner.bmiZuKategorie(0);
    }

    @Test
    public void kategorieUntergewicht() {
        assertEquals("Untergewicht", BMIRechner.bmiZuKategorie(0.1));
        assertEquals("Untergewicht", BMIRechner.bmiZuKategorie(18.49));
    }

    @Test
    public void kategorieNormalgewicht() {
        assertEquals("Normalgewicht", BMIRechner.bmiZuKategorie(18.5));
        assertEquals("Normalgewicht", BMIRechner.bmiZuKategorie(24.99));
    }

    @Test
    public void kategorieUebergewicht() {
        assertEquals("Übergewicht", BMIRechner.bmiZuKategorie(25));
        assertEquals("Übergewicht", BMIRechner.bmiZuKategorie(29.99));
    }

    @Test
    public void kategorieSchweresUebergewicht() {
        assertEquals("schweres Übergewicht", BMIRechner.bmiZuKategorie(30));
    }

    @Test(expected = IllegalArgumentException.class)
    public void berechnungGroesseUngueltig() {
        BMIRechner.berechneBMI(0, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void berechnungGewichtUngueltig() {
        BMIRechner.berechneBMI(180, 0);
    }

    @Test
    public void berechnungNormal() {
        assertEquals(30.86, BMIRechner.berechneBMI(180, 100), 0.01);
    }

    @Test
    public void berechnungExtraschwer() {
        assertEquals(185.54, BMIRechner.berechneBMI(185, 635), 0.01);
    }

    @Test
    public void berechnungExtrasgross() {
        assertEquals(27.03, BMIRechner.berechneBMI(272, 200), 0.01);
    }

}
