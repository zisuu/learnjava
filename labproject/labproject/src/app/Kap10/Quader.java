package app.Kap10;

/**
 * Der Kasten »Sortieren in mehreren Threads« behauptet, dass parallele Sortierung auf Maschinen mit mehreren 
 * Kernen wesentlich schneller ist als sequenzielle Sortierung. Zeit, das auf die Probe zu stellen.
 * 
 * OK: Schreiben Sie eine Klasse Quader, die drei int-Felder enthält: Länge, Breite und Höhe des Quaders. 
 * OK: Außerdem soll die Klasse eine Methode getVolumen haben, die das Volumen des Quaders berechnet. 
 * OK: Quader sollen durch ihr Volumen eine natürliche Ordnung haben.
 * 
 */
public class Quader implements Comparable{
    private final int quaderLaenge, quaderBreite, quaderHoehe;

    /**
     * Erzeugt ein neues Quader mit gegebener Länge, Breite und Höhe. Negative 
     * Angaben werden in positive umgesetzt, da negative Längenangaben keinen 
     * Sinn haben.
     * @param quaderLaenge
     * @param quaderBreite
     * @param quaderHoehe 
     */
    public Quader(int quaderLaenge, int quaderBreite, int quaderHoehe) {
        this.quaderLaenge = Math.abs(quaderLaenge);
        this.quaderBreite = Math.abs(quaderBreite);
        this.quaderHoehe = Math.abs(quaderHoehe);
    }

    /**
     * Berechnet das Volumen des Quaders.
     * @return das Volumen
     */
    public int getVolumen() {
        return quaderLaenge * quaderBreite * quaderHoehe;
    }
    

    /**
     * Quader werden nach Volumen sortiert.
     * @param o ein anderes Quader
     * @return eine negative Zahl wenn <code>o</code> größer ist als 
     * <code>this</code>, eine positive Zahl wenn es kleiner ist, 0 wenn beide gleich sind. 
     * @throws ClassCastException wenn <code>o</code> kein Quader ist.
     */
    @Override
    public int compareTo(Object o) {
        Quader other = (Quader)o;
        return getVolumen() - other.getVolumen();
    }
}
