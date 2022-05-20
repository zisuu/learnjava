package test;

import static org.junit.Assert.*;

import java.time.*;

import org.junit.Test;
import app.Kap8.*;

public class FernsehkalenderTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void serienNull() {
        Fernsehkalender.erzeugeKalender(null, ZoneId.systemDefault());
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeitzoneNull() {
        Fernsehkalender.erzeugeKalender(new Fernsehserie[0], null);
    }
    
    @Test
    public void serienLeer() {
        Folge[] ergebnis = Fernsehkalender.erzeugeKalender(new Fernsehserie[0], ZoneId.systemDefault());
        assertNotNull(ergebnis);
        assertEquals(0, ergebnis.length);
    }

    @Test
    public void eineSerieEineFolge() {
        final Fernsehserie[] serien = new Fernsehserie[]{
            new Fernsehserie("Doktor WHAT", ZonedDateTime.of(2014, 12, 13, 20, 0, 0, 0, ZoneId.of("Europe/London")), 1)
        };
        Folge[] ergebnis = Fernsehkalender.erzeugeKalender(serien, ZoneId.of("Europe/Berlin"));
        assertNotNull(ergebnis);
        assertEquals(1, ergebnis.length);
        assertEquals(new Folge("Doktor WHAT", 1, ZonedDateTime.of(2014, 12, 13, 21, 0, 0, 0, ZoneId.of("Europe/Berlin"))), ergebnis[0]);
    }
    
    @Test
    public void eineSerieVierFolgen() {
        final Fernsehserie[] serien = new Fernsehserie[]{
            new Fernsehserie("Doktor WHAT", ZonedDateTime.of(2014, 12, 13, 20, 0, 0, 0, ZoneId.of("Europe/London")), 4)
        };
        Folge[] ergebnis = Fernsehkalender.erzeugeKalender(serien, ZoneId.of("Europe/Berlin"));
        assertNotNull(ergebnis);
        assertEquals(4, ergebnis.length);
        assertEquals(new Folge("Doktor WHAT", 1, ZonedDateTime.of(2014, 12, 13, 21, 0, 0, 0, ZoneId.of("Europe/Berlin"))), ergebnis[0]);
        assertEquals(new Folge("Doktor WHAT", 2, ZonedDateTime.of(2014, 12, 20, 21, 0, 0, 0, ZoneId.of("Europe/Berlin"))), ergebnis[1]);
        assertEquals(new Folge("Doktor WHAT", 3, ZonedDateTime.of(2014, 12, 27, 21, 0, 0, 0, ZoneId.of("Europe/Berlin"))), ergebnis[2]);
        assertEquals(new Folge("Doktor WHAT", 4, ZonedDateTime.of(2015, 1, 3, 21, 0, 0, 0, ZoneId.of("Europe/Berlin"))), ergebnis[3]);
    }    

    @Test
    public void zweiSerienZweiFolgen() {
        final Fernsehserie[] serien = new Fernsehserie[]{
            new Fernsehserie("Doktor WHAT", ZonedDateTime.of(2014, 12, 13, 20, 0, 0, 0, ZoneId.of("Europe/London")), 2),
            new Fernsehserie("Breaking Code", ZonedDateTime.of(2014, 12, 15, 20, 0, 0, 0, ZoneId.of("America/Chicago")), 2)
        };
        Folge[] ergebnis = Fernsehkalender.erzeugeKalender(serien, ZoneId.of("Europe/Berlin"));
        assertNotNull(ergebnis);
        assertEquals(4, ergebnis.length);
        assertEquals(new Folge("Doktor WHAT", 1, ZonedDateTime.of(2014, 12, 13, 21, 0, 0, 0, ZoneId.of("Europe/Berlin"))), ergebnis[0]);
        assertEquals(new Folge("Breaking Code", 1, ZonedDateTime.of(2014, 12, 16, 3, 0, 0, 0, ZoneId.of("Europe/Berlin"))), ergebnis[1]);
        assertEquals(new Folge("Doktor WHAT", 2, ZonedDateTime.of(2014, 12, 20, 21, 0, 0, 0, ZoneId.of("Europe/Berlin"))), ergebnis[2]);
        assertEquals(new Folge("Breaking Code", 2, ZonedDateTime.of(2014, 12, 23, 3, 0, 0, 0, ZoneId.of("Europe/Berlin"))), ergebnis[3]);
    }  
    
    @Test
    public void mitSommerzeitUmstellung(){
        //Zeitumstellung in den USA 2014: 9. März
        //Zeitumstelling in Deutschland 2014: 30. März
        final Fernsehserie[] serien = new Fernsehserie[]{
            new Fernsehserie("Breaking Code", ZonedDateTime.of(2014, 3, 5, 20, 0, 0, 0, ZoneId.of("America/Chicago")), 5)
        };
        Folge[] ergebnis = Fernsehkalender.erzeugeKalender(serien, ZoneId.of("Europe/Berlin"));
        assertNotNull(ergebnis);
        assertEquals(5, ergebnis.length);
        assertEquals(new Folge("Breaking Code", 1, ZonedDateTime.of(2014, 3, 6, 3, 0, 0, 0, ZoneId.of("Europe/Berlin"))), ergebnis[0]);
        assertEquals(new Folge("Breaking Code", 2, ZonedDateTime.of(2014, 3, 13, 2, 0, 0, 0, ZoneId.of("Europe/Berlin"))), ergebnis[1]);
        assertEquals(new Folge("Breaking Code", 3, ZonedDateTime.of(2014, 3, 20, 2, 0, 0, 0, ZoneId.of("Europe/Berlin"))), ergebnis[2]);
        assertEquals(new Folge("Breaking Code", 4, ZonedDateTime.of(2014, 3, 27, 2, 0, 0, 0, ZoneId.of("Europe/Berlin"))), ergebnis[3]);
        assertEquals(new Folge("Breaking Code", 5, ZonedDateTime.of(2014, 4, 3, 3, 0, 0, 0, ZoneId.of("Europe/Berlin"))), ergebnis[4]);
    }
    
}
