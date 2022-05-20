package app.Kap8;

import java.time.ZonedDateTime;

/**
 * Datenklasse für eine Fensehserie: enthält Name, Ausstrahlungszeit der ersten
 * Folge in lokaler Zeit und die Anzahl Folgen
 *
 * @author Kai Günster
 */
public class Fernsehserie {

    public final String name;
    public final ZonedDateTime ersteFolge;
    public final int folgen;

    public Fernsehserie(String name, ZonedDateTime ersteFolge, int folgen) {
        this.name = name;
        this.ersteFolge = ersteFolge;
        this.folgen = folgen;
    }

}
