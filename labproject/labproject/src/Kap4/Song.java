package Kap4;

// Erweitern Sie die Klasse Song um das oben gezeigte Feld gesamtLaenge und die zugehörige Zugriffsmethode 
// getGesamtLaenge. Das Feld soll immer die Länge aller erzeugten Songs enthalten. Achten Sie vor allem darauf,
//  diesen Wert anzupassen, sobald die Länge eines Songs nachträglich geändert wird.

/**
 * Klasse Song, mit zwei String-Feldern interpret und titel und einem int-Feld
 * laengeInSekunden.
 * 
 * @author zisuu
 * @version 1.4
 */
public class Song {

    private String interpret;
    private String titel;
    private Integer laengeInSekunden;
    private static long gesamtLaenge;
    public static long getGesamtLaenge(){
        return Song.gesamtLaenge;
    }


    /**
     * Konstruktor für Songs mit titel, interpret und laengeInSekunden
     * 
     * @param titel des Songs
     * @param interpret des Songs
     * @param laengeInSekunden des Songs
     */
    public Song(String titel, String interpret, int laengeInSekunden) {
        this.setTitel(titel);
        this.setInterpret(interpret);
        this.setLaengeInSekunden(laengeInSekunden);
    }

    /**
     * Konstruktor für Songs mit titel und laengeInSekunden, aber ohne Angabe des Interprets
     * 
     * @param titel des Songs
     * @param laengeInSekunden des Songs
     */
    public Song(String titel, int laengeInSekunden) {
        this(titel, "Unbekannter Künstler", laengeInSekunden);
    }

    /**
     * Konstruktor für Songs mit titel und laengeInSekunden, aber ohne Angabe des Interprets
     * 
     * @param titel des Songs
     * @param interpret des Songs
     * @param stunden des Songs
     * @param minuten des Songs
     * @param sekunden des Songs
     */
    public Song(String titel, String interpret,  Integer stunden, Integer minuten, Integer sekunden) {
        int laengeInSekunden = sekunden + (minuten * 60) + (stunden * 3600);
        this.setTitel(titel);
        this.setInterpret(interpret);
        this.setLaengeInSekunden(laengeInSekunden);
    }

    /**
     * Methode die die Daten des Songs auf die Kommandozeile ausgibt
     */
    public void print() {
        System.out.println(this);
    }

    /**
     * toString-Methode soll aus dem Feld laengeInSekunden eine Zeitangabe im Format
     * Minuten:Sekunden berechnen und
     * diese zurückgeben.
     * 
     * @return die String-Darstellung dieses Objekts.
     */
    public String toString() {
        return "Interpret: " + this.interpret + ", Titel: " + this.titel + ", Dauer: " + this.formatTime();
    }

    /**
     * Getter für das Feld Interpret
     * 
     * @return den Interpret
     */
    public String getInterpret() {
        return interpret;
    }

    /**
     * Getter für das Feld Titel
     * 
     * @return den Titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Getter für das Feld Laenge
     * 
     * @return die Laenge
     */
    public Integer getLaenge() {
        return laengeInSekunden;
    }

    /**
     * Getter für Stunden
     * 
     * @return die Länge dieses Songs in Stunden
     */
    public Integer getStunden() {
        return this.laengeInSekunden / 3600;
    }

    /**
     * Getter für Minuten
     * 
     * @return die Länge dieses Songs in Minuten
     */
    public Integer getMinuten() {
        return (this.laengeInSekunden % 3600) / 60;
    }

    /**
     * Getter für die Länge in Sekunden
     * 
     * @return die Länge dieses Songs in Sekunden
     */
    public Integer getSekunden() {
        return this.laengeInSekunden % 60;
    }

    /**
     * Setter für das Feld Interpret
     * 
     * @param interpret den neuen Interpreten
     */
    public void setInterpret(String interpret) {
        if (interpret == null) {
            throw new IllegalArgumentException("Interpret ist null");
        }
        this.interpret = interpret;
    }

    /**
     * Setter für das Feld Titel
     * 
     * @param titel den neuen Titel
     */
    public void setTitel(String titel) {
        if (titel == null) {
            throw new IllegalArgumentException("Titel ist null");
        }
        this.titel = titel;
    }

    /**
     * Setter für das Feld Länge in Sekunden
     * 
     * @param laengeInSekunden die länge des neuen Titel
     */
    public void setLaengeInSekunden(Integer laengeInSekunden) {
        if (laengeInSekunden < 0) {
            throw new IllegalArgumentException("Sekunden können nicht negativ sein.");
        }
        this.laengeInSekunden = laengeInSekunden;
    }

    /**
     * Setter für die Länge in Stunden, Minuten und Sekunden
     * 
     * @param stunden  Stundenanteil der Länge
     * @param minuten  Minutenanteil der Länge
     * @param sekunden Sekundenanteil der Länge
     */
    public void setLaenge(Integer stunden, Integer minuten, Integer sekunden) {
        /*
         * aus den übergebenen Werten wird die Gesamtlänge in Sekunden berechnet und
         * diese gesetzt. Von außen ist das aber nicht sichtbar, einem Benutzer dieser
         * Klasse ist egal, in welcher Form die Länge intern gespeichert wird. Das ist
         * "implementation hiding".
         */
        int laengeInSekunden = sekunden + (minuten * 60) + (stunden * 3600);
        this.setLaengeInSekunden(laengeInSekunden);
    }

    /**
     * formatTime-Methode soll aus dem Feld laengeInSekunden eine Zeitangabe im
     * Format
     * Minuten:Sekunden berechnen und diese zurückgeben.
     * 
     * @param laengeInSekunden - Dauer des Songs in Sekunden als
     *                         <code>Integer</code>
     * @return laengeInMinutenSekunden - Dauer des Songs im Format minuten:sekunden
     *         als <code>Integer</code>
     */
    public String formatTime() {
        Integer hours = this.getStunden();
        Integer seconds = this.getSekunden();
        Integer minutes = this.getMinuten();
        String duration = "";
        if (hours > 0) {
            duration += leadingZeros(hours) + ":";
        }
        duration += leadingZeros(minutes) + ":" + leadingZeros(seconds);
        return duration;
    }

    /**
     * Hilfsmethode, um Zahlen zu "polstern": bei einstelligen Zahlen wird eine
     * führende null eingefügt.
     * 
     * @param number - die zu formatierende Zahl
     * @return die Zahl als String, mit führender 0 falls nötig.
     */
    private static String leadingZeros(Integer number) {
        return number < 10 ? "0" + number : Integer.toString(number);
    }

}
