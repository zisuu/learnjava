package app.Kap8;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Datenklasse für eine Folge eine Fernsehserie. Enthält den Namen der Serie,
 * die Zahl der Episode und die Ausstrahlungszeit in lokaler Zeit.
 *
 */
public class Folge {

    public final String serie;
    public final int folgeNr;
    public final ZonedDateTime ausstrahlung;

    public Folge(String serie, int folgeNr, ZonedDateTime ausstrahlung) {
        this.serie = serie;
        this.folgeNr = folgeNr;
        this.ausstrahlung = ausstrahlung;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.serie);
        hash = 97 * hash + this.folgeNr;
        hash = 97 * hash + Objects.hashCode(this.ausstrahlung);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Folge other = (Folge) obj;
        if (!Objects.equals(this.serie, other.serie)) {
            return false;
        }
        if (this.folgeNr != other.folgeNr) {
            return false;
        }
        if (!Objects.equals(this.ausstrahlung, other.ausstrahlung)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Folge{" + "serie=" + serie + ", folgeNr=" + folgeNr + ", ausstrahlung=" + ausstrahlung + '}';
    }

}
