package de.kaiguenster.javaintro.musiksammlung;

import java.util.Objects;

/**
 * Datenklasse für Songs, mit Titel, Interpret und Länge. 
 * Jetzt mit statischem Feld und Methode, um die Gesamtlänge aller Songs zu berechnen.
 * @author Kai Günster
 */
public class Song {

    private static long gesamtLaenge;
    
    /**
     * Liest die Gesamtlänge aller Songs, die in diesem Javaprozess erzeugt wurden.
     * @return 
     */
    public static long getGesamtLaenge(){
        return Song.gesamtLaenge;
    }

    
    private String titel;
    private String interpret;
    private int laengeInSekunden;

    /**
     * Konstruktor mit allen Feldern
     * @param titel der Songtitel
     * @param interpret der Interpret
     * @param laengeInSekunden Länge des Songs in Sekunden
     */
    public Song(String titel, String interpret, int laengeInSekunden) {
        this.setTitel(titel);
        this.setInterpret(interpret);
        this.setLaengeInSekunden(laengeInSekunden);
    }

    /**
     * Konstruktor ohne Interpret. Interpret wird auf "Unbekannter Künstler" gesetzt.
     * @param titel der Songtitel
     * @param laengeInSekunden Länge des Songs in Sekunden
     */
    public Song(String titel, int laengeInSekunden) {
        this(titel, "Unbekannter Künstler", laengeInSekunden);
    }

    /**
     * Konstruktor mit Längenangabe in Stunden, Minuten und Sekunden
     * @param titel der Songtitel
     * @param interpret der Interpret
     * @param stunden Stundenanteil der Länge
     * @param minuten Minutenanteil der Länge
     * @param sekunden Sekundenanteil der Länge
     */
    public Song(String titel, String interpret, int stunden, int minuten, int sekunden) {
        this(titel, interpret, sekunden + 60 * minuten + 3600 * stunden);
    }
    
    /**
     * Gibt diesen Song mit allen seinen Daten auf der Kommandozeile aus. 
     */     
    public void drucke() {
        System.out.println(this);
    }

    /**
     * toString-Methode von Song. Diese spezielle Methode wird von Java immer 
     * dann gerufen, wenn eine String-Repräsentation eines Objekts benötigt wird. 
     * @return die String-Darstellung dieses Objekts.
     */    
    public String toString() {
        return this.titel + " (" + this.interpret + ") " + this.formatiereZeit();
    }

    /**
     * Getter für das Feld Titel
     * @return den Titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Setter für das Feld Titel
     * @param titel der neue Titel
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }

    /**
     * Getter für das Feld Interpret
     * @return den Interpreten
     */
    public String getInterpret() {
        return interpret;
    }

    /**
     * Setter für das Feld Interpret
     * @param interpret den neuen Interpreten
     */
    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    /**
     * Getter für die Länge in Sekunden
     * @return die Länge dieses Songs in Sekunden
     */
    public int getLaengeInSekunden() {
        return laengeInSekunden;
    }

    /**
     * Setter für die Länge in Sekunden
     * @param laengeInSekunden die neue Länge in Sekunden
     */
    public void setLaengeInSekunden(int laengeInSekunden) {
        //Zunächst die alte Länge von der Gesamtlänge abziehen
        Song.gesamtLaenge -= this.laengeInSekunden;
        //Dann die neue Länge wieder hinzuaddieren
        Song.gesamtLaenge += laengeInSekunden;
        this.laengeInSekunden = laengeInSekunden;
    }

    /**
     * Setter für die Länge in Stunden, Minuten und Sekunden
     * @param stunden Stundenanteil der Länge
     * @param minuten Minutenanteil der Länge
     * @param sekunden Sekundenanteil der Länge
     */
    public void setLaenge(int stunden, int minuten, int sekunden) {
        /*
        aus den übergebenen Werten wird die Gesamtlänge in Sekunden berechnet und 
        diese gesetzt. Von außen ist das aber nicht sichtbar, einem Benutzer dieser 
        Klasse ist egal, in welcher Form die Länge intern gespeichert wird. Das ist 
        "implementation hiding".
        */
        int laengeSekunden = sekunden + 60 * minuten + 3600 * stunden;
        this.setLaengeInSekunden(laengeSekunden);
    }

    /**
     * Getter für den Stundenanteil der Zeit
     * @return Stundenanteil der Zeit
     */
    public int getStunden() {
        return this.laengeInSekunden / 3600;
    }

    /**
     * Getter für den Minutenanteil der Zeit
     * @return Minutenanteil der Zeit.
     */
    public int getMinuten() {
        return (this.laengeInSekunden % 3600) / 60;
    }

    /**
     * Getter für den Sekundenateil der Zeit
     * @return Sekundenanteil der Zeit.
     */
    public int getSekunden() {
        return this.laengeInSekunden % 60;
    }

    /**
     * Diese Methode formatiert die Zeit, die im Objekt als Sekundenzahl gespeichert ist, 
     * in ein lesbarerer Format, zum Beispiel "2:37"
     * @return die lesbar formatierte Zeit als String
     */    
    public String formatiereZeit() {
        /*
        Die einzelnen Zeitkomponenten werden durch die entsprechenden Getter 
        ausgelesen, anstatt die die Berechnung hier noch einmal zu implementieren.
        */
        int stunden = this.getStunden();
        int minuten = this.getMinuten();
        int sekunden = this.getSekunden();
        String zeit = "";
        //Nur falls der Song länger als eine Stunde ist, werden Stunden ausgegeben,
        if (stunden > 0) {
            zeit += polstereZahl(stunden) + ":";
        }
        //Minuten und Sekunden anhängen
        zeit += polstereZahl(minuten) + ":";
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.titel);
        hash = 59 * hash + Objects.hashCode(this.interpret);
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
        final Song other = (Song) obj;
        if (!Objects.equals(this.titel, other.titel)) {
            return false;
        }
        if (!Objects.equals(this.interpret, other.interpret)) {
            return false;
        }
        if (this.laengeInSekunden != other.laengeInSekunden) {
            return false;
        }
        return true;
    }
    
    
}
