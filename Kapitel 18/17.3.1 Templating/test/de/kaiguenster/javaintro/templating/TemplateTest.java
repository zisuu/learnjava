package de.kaiguenster.javaintro.templating;

import java.io.IOException;
import java.io.StringReader;
import org.junit.Test;
import static org.junit.Assert.*;

public class TemplateTest {

    public static final String TEMPLATE = "$$vorname$$ $$nachname$$\n$$strasse$$ $$hausnummer$$\n$$plz$$ $$ort$$\n\n\nSehr geehrte(r) $$anrede$$ $$nachname$$,\n\t wir sind ein weltbekannter Anbieter von Sicherheitssystemen ...";
    
    @Test
    public void testTemplate() throws Exception {
        Template t = new Template(new StringReader(TEMPLATE));
        String ausgabe = t.wendeAn(new Adresse("Herr", "Dagobert", "Duck", "Geldspeicher", "1", "12345", "Entenhausen"));
        System.out.println(ausgabe);
        assertEquals("Dagobert Duck\nGeldspeicher 1\n12345 Entenhausen\n\n\nSehr geehrte(r) Herr Duck,\n\t wir sind ein weltbekannter Anbieter von Sicherheitssystemen ...", ausgabe);
    }

    
    public static class Adresse {
        private String anrede, vorname, nachname, strasse, hausnummer, plz, ort;

        public Adresse(String anrede, String vorname, String nachname, String strasse, String hausnummer, String plz, String ort) {
            this.anrede = anrede;
            this.vorname = vorname;
            this.nachname = nachname;
            this.strasse = strasse;
            this.hausnummer = hausnummer;
            this.plz = plz;
            this.ort = ort;
        }

        public String getAnrede() {
            return anrede;
        }

        public void setAnrede(String anrede) {
            this.anrede = anrede;
        }

        public String getVorname() {
            return vorname;
        }

        public void setVorname(String vorname) {
            this.vorname = vorname;
        }

        public String getNachname() {
            return nachname;
        }

        public void setNachname(String nachname) {
            this.nachname = nachname;
        }

        public String getStrasse() {
            return strasse;
        }

        public void setStrasse(String strasse) {
            this.strasse = strasse;
        }

        public String getHausnummer() {
            return hausnummer;
        }

        public void setHausnummer(String hausnummer) {
            this.hausnummer = hausnummer;
        }

        public String getPlz() {
            return plz;
        }

        public void setPlz(String plz) {
            this.plz = plz;
        }

        public String getOrt() {
            return ort;
        }

        public void setOrt(String ort) {
            this.ort = ort;
        }
        
        
    }
}
