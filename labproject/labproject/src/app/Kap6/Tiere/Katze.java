package app.Kap6.Tiere;

public class Katze extends Tier {
    @Override
    public void setGewichtGr(int gewicht) {
        if (gewicht > 10000)
            throw new IllegalArgumentException("Katzen können nicht mehr als 10 kg wiegen");
        super.setGewichtGr(gewicht);
    }

    /**
    * Konstruktor für Katze
    *
    * @param name der Katze
    * @param gewichtGr der Katze, in Gramm
    * @param geschlecht der Katze
    */
    public Katze(String name, int gewichtGr, char geschlecht) {
        super(name, gewichtGr, geschlecht);
    }
}
