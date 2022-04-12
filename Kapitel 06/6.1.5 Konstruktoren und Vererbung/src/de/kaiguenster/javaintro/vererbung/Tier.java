package de.kaiguenster.javaintro.vererbung;

/**
 * Die gemeinsame Oberklasse für alle Tiere. Hier sind Felder und Methoden
 * definiert, die für alle Tierarten gelten: Name, Gewicht, Geschlecht.
 *
 * @author Kai Günster
 */
public class Tier {

    /**
     * Konstante für Geschlecht: Männlich
     */
    public static final char MAENNLICH = 'm';
    /**
     * Konstante für Geschlecht: Weiblich
     */
    public static final char WEIBLICH = 'w';

    private final String name;
    private int gewicht;
    private final char geschlecht;

    /**
     * Kosntruktor.
     *
     * @param name der Name des Tiers, nach Instanziierung unveränderlich
     * @param geschlecht das Geschlecht des Tiers, nach Instanziierung
     * unveränderlich
     * @param gewicht das Gewicht des Tiers
     * @throws IllegalArgumentException wenn Gewicht kleiner oder gleich 0 und
     * wenn Geschlecht nicht {@link #MAENNLICH} oder {@link #WEIBLICH}
     */
    public Tier(String name, char geschlecht, int gewicht) {
        if (geschlecht != MAENNLICH && geschlecht != WEIBLICH) {
            throw new IllegalArgumentException("Geschlecht muss m oder w sein.");
        }
        if (gewicht <= 0) {
            throw new IllegalArgumentException("Gewicht muss >0 sein.");
        }
        this.name = name;
        this.geschlecht = geschlecht;
        this.gewicht = gewicht;
    }

    /**
     * Getter für das Attribut Name
     *
     * @return den Namen
     */
    public String getName() {
        return name;
    }

    /**
     * Getter für das Attribut Gewicht
     *
     * @return das Gewicht in Kilogramm
     */
    public double getGewicht() {
        return gewicht;
    }

    /**
     * Setter für das Attribut Gewicht
     *
     * @param gewicht das Gewicht in Kilogramm
     * @throws IllegalArgumentException wenn Gewicht kleiner oder gleich 0
     */
    public void setGewicht(int gewicht) {
        if (gewicht <= 0) {
            throw new IllegalArgumentException("Gewicht muss größer 0 sein");
        }
        this.gewicht = gewicht;
    }

    /**
     * Getter für das Attribut Geschlecht
     *
     * @return {@link #MAENNLICH} oder {@link #WEIBLICH}
     */
    public char getGeschlecht() {
        return geschlecht;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.geschlecht + ", " + this.gewicht + "g";
    }
}
