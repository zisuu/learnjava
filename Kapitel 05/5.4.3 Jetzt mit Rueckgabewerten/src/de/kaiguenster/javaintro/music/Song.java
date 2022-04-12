package de.kaiguenster.javaintro.music;

import java.io.Serializable;

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
        /*
        Hier wird ausgenutzt, dass automatisch toString gerufen wird,
        wenn eine Stringrepärsentation eines Objekt benötigt wird-
        */
        System.out.println(this);
    }
    
    /**
     * Diese Methode formatiert die Zeit, die im Objekt als Sekundenzahl gespeichert ist, 
     * in ein lesbarerer Format, zum Beispiel "2:37"
     * @return die lesbar formatierte Zeit als String
     */
    public String formatiereZeit(){
        //Berechne zunächst die Stunden (vor allem nötig für "Yes"-Songs) und die danach verbleibenden Sekunden
        int stunden = this.laengeInSekunden / 3600;
        int rest = this.laengeInSekunden % 3600;
        //Berechne aus dem Rest Minuten und Sekunden.
        int minuten = rest / 60;
        int sekunden = rest % 60;
        String zeit = "";
        //Nur falls der Song länger als eine Stunde ist, werden Stunden ausgegeben,
        if (stunden > 0){
            zeit += polstereZahl(stunden) + ":";
        }
        //Minuten und Sekunden anhängen
        zeit += polstereZahl(minuten)+ ":";
        zeit += polstereZahl(sekunden);
        return zeit;
    }

    /**
     * Hilfsmethode, um Zahlen zu "polstern": bei einstelligen Zahlen wird eine führende null eingefügt.
     * @param zahl - die zu formatierende Zahl
     * @return die Zahl als String, mit führender 0 falls nötig.
     */
    private static String polstereZahl(int zahl) {
        return zahl < 10 ? "0" + zahl : Integer.toString(zahl);
    }
    
    /**
     * toString-Methode von Song. Diese spezielle Methode wird von Java immer 
     * dann gerufen, wenn eine String-Repräsentation eines Objekts benötigt wird. 
     * @return die String-Darstellung dieses Objekts.
     */
    @Override
    public String toString(){
        return this.titel + " (" + this.interpret + ") " + this.formatiereZeit();
    }
}
