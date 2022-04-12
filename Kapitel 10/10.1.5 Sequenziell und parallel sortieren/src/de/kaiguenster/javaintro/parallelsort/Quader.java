package de.kaiguenster.javaintro.parallelsort;

/**
 * Datenklasse für ein Quader, definiert durch seine Ausdehnung in drei Richtungen.
 * Alle Angaben müssen ganzzahlig erfolgen.
 * @author Kai Günster
 */
public class Quader implements Comparable{
    public final int laenge, breite, hoehe;

    /**
     * Erzeugt ein neues Quader mit gegebener Länge, Breite und Höhe. Negative 
     * Angaben werden in positive umgesetzt, da negative Längenangaben keinen 
     * Sinn haben.
     * @param laenge
     * @param breite
     * @param hoehe 
     */
    public Quader(int laenge, int breite, int hoehe) {
        this.laenge = Math.abs(laenge);
        this.breite = Math.abs(breite);
        this.hoehe = Math.abs(hoehe);
    }
    
    /**
     * Berechnet das Volumen des Quaders.
     * @return das Volumen
     */
    public int getVolumen(){
        return laenge * hoehe * breite;
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
