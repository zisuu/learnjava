package de.kaiguenster.javaintro.music;

/**
 * Datenklasse für Songs, mit Titel, Interpret und Länge. 
 * @author Kai Günster
 */
public class Song {
    public String titel;
    public String interpret;
    public int laengeInSekunden;
    
    /**
     * Gibt diesen Song mit allen seinen Daten auf der Kommandozeile aus. 
     */
    public void drucke(){
        System.out.println(this.titel + " (" + this.interpret + ") " + this.laengeInSekunden);
    }
}
