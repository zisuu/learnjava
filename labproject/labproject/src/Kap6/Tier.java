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

    private String name;
    private int gewichtGr; // in Gramm
    private char geschlecht;

    /**
     * toString-Methode soll die Werte der Felder zurückgeben.
     * 
     * @return die String-Darstellung dieses Objekts.
     */
    public String toString() {
        return "Name: " + this.name + ", Gewicht: " + this.gewichtGr +"g" + ", Geschlecht: " + this.getGeschlecht();
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
     * Setter für das Feld name
     * 
     * @param name des Tiers
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter für das Feld gewichtGr
     * 
     * @return gewicht des Tiers in Gramm
     */
    public int getGewichtGr() {
        if (gewichtGr <= 0) {
            throw new IllegalArgumentException("Gewicht muss grösser 0 sein");
        }
        return this.gewichtGr;
    }

    /**
     * Setter für das Feld gewichtGr
     * 
     * @param gewichtGr des Tiers in Gramm
     */
    public void setGewichtGr(int gewichtGr) {
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
     * Setter für das Feld geschlecht
     * 
     * @param geschlecht des Tiers, 'm' oder 'w'
     */
    public void setGeschlecht(char geschlecht) {
        if (geschlecht != MAENNLICH && geschlecht != WEIBLICH) {
            throw new IllegalArgumentException("Geschlecht muss m oder w sein.");
        }
        this.geschlecht = geschlecht;
    }

    /**
     * Methode die die Daten des Songs auf die Kommandozeile ausgibt
     */
    public void print() {
        System.out.println(this);
    }

    // /**
    //  * Konstruktor für Tiere
    //  * 
    //  * @param name des tieres
    //  * @param interpret des Songs
    //  * @param stunden des Songs
    //  * @param minuten des Songs
    //  * @param sekunden des Songs
    //  */
    // public Tier(String name, int getGewichtGr,  char[] geschlecht) {
    //     this.setName(name);
    //     this.setGewichtGr(gewichtGr);
    //     this.setGeschlecht(geschlecht);
    // }
}
