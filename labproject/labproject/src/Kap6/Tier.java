package Kap6;

/**
 * Klasse Tier
 * 
 * Hat drei Felder:
 * - name vom Typ String
 * - gewicht vom Typ int. Das Gewicht wird in Gramm angegeben.
 * - geschlecht vom Typ char. Hier wird entweder das Zeichen 'm' für
 * männlich oder 'w' für weiblich gespeichert.
 * 
 * Ausserdem zwei Konstanten für die Werte: MAENNLICH und WEIBLICH.
 * 
 * Alle drei Felder sind von aussen nur über Zugriffsmethoden zugänglich.
 * 
 * Beinhaltet eine toString-Methode, die diese drei Werte ausgibt.
 * 
 * @author zisuu
 * @version 1.0
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
    private int gewichtGr; // in Gramm
    private final char geschlecht;

    /**
     * toString-Methode soll die Werte der Felder zurückgeben.
     * 
     * @return die String-Darstellung dieses Objekts.
     */
    public String toString() {
        return this.getClass().getName() +" Name: " + this.name + ", Gewicht: " + this.gewichtGr + "g" + ", Geschlecht: " + this.getGeschlecht();
    }

    /**
     * Getter für das Feld name
     * 
     * @return name des Tiers
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter für das Feld gewichtGr
     * 
     * @return gewicht des Tiers in Gramm
     */
    public int getGewichtGr() {
        return this.gewichtGr;
    }

    /**
     * Setter für das Feld gewichtGr
     * 
     * @param gewichtGr des Tiers in Gramm
     */
    public void setGewichtGr(int gewichtGr) {
        if (gewichtGr <= 0) {
            throw new IllegalArgumentException("Gewicht muss grösser 0 sein");
        }
        this.gewichtGr = gewichtGr;
    }

    /**
     * Getter für das Feld geschlecht
     * 
     * @return geschlecht des Tiers, 'm' oder 'w'
     */
    public char getGeschlecht() {
        return this.geschlecht;
    }

    /**
     * Methode die die Daten des Songs auf die Kommandozeile ausgibt
     */
    public void print() {
        System.out.println(this);
    }

    /**
    * Konstruktor für Tiere
    *
    * @param name des tieres
    * @param gewichtGr des tieres, in Gramm
    * @param geschlecht des tieres
    */
    public Tier(String name, int gewichtGr, char geschlecht) {
        if (geschlecht != MAENNLICH && geschlecht != WEIBLICH) {
            throw new IllegalArgumentException("Geschlecht muss m oder w sein.");
        }
        if (gewichtGr <= 0) {
            throw new IllegalArgumentException("Gewicht muss grösser 0 sein");
        }
        this.name = name;
        this.gewichtGr = gewichtGr;
        this.geschlecht = geschlecht;
    }
}
