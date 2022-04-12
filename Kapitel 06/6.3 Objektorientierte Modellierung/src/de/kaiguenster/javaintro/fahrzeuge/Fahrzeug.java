package de.kaiguenster.javaintro.fahrzeuge;

/**
 * Abstrakte Oberklasse für alle Arten von Fahrzeugen. Definiert
 * allgemeingültige Attribute wie Modell, Höchstgeschwindigkeit und Anzahl der
 * Sitze.
 *
 * @author Kai Günster
 */
public abstract class Fahrzeug {

    private String modell;
    private double hoechstgeschwindigkeit;
    private int sitze;

    /**
     * Konstruktor mit allen Attributen
     *
     * @param modell Fahrzeugmodell
     * @param hoechstgeschwindigkeit Höchstgeschwindigkeit
     * @param sitze Anzahl Sitze
     */
    public Fahrzeug(String modell, double hoechstgeschwindigkeit, int sitze) {
        this.modell = modell;
        this.hoechstgeschwindigkeit = hoechstgeschwindigkeit;
        this.sitze = sitze;
    }

    /**
     * Getter für das Attribut Modell
     *
     * @return das Modell
     */
    public String getModell() {
        return modell;
    }

    /**
     * Setter für das Attribut Modell
     *
     * @param modell das neue Modell
     */
    public void setModell(String modell) {
        this.modell = modell;
    }

    /**
     * Getter für das Attribut Höchstgeschwindigkeit
     *
     * @return die Höchstgewschindigkeit in km/h
     */
    public double getHoechstgeschwindigkeit() {
        return hoechstgeschwindigkeit;
    }

    /**
     * Setter für das Attribut Höchstgeschwindigkeit
     *
     * @param hoechstgeschwindigkeit die neue Höchstgeschwindigkeit in km/h
     * @throws IllegalArgumentException wenn Höchstgeschwindigkeit nicht
     * zwischen 0 und 320 km/h
     */
    public void setHoechstgeschwindigkeit(double hoechstgeschwindigkeit) {
        if (hoechstgeschwindigkeit > 320 || hoechstgeschwindigkeit < 0) {
            throw new IllegalArgumentException("Geschwindigkeit muss zwischen 0 und 320 km/h liegen");
        }
        this.hoechstgeschwindigkeit = hoechstgeschwindigkeit;
    }

    /**
     * Getter für das Attribut Sitze
     *
     * @return die Anzahl Sitze in diesem Fahrzeug
     */
    public int getSitze() {
        return sitze;
    }

    /**
     * Setter für das Attribut Sitze
     *
     * @param sitze die neue Anzahl Sitze in diesem Fahrzeug
     */
    public void setSitze(int sitze) {
        this.sitze = sitze;
    }

    /**
     * Methode, um das Fahrzeug fahren zu lassen. Gibt Ziel und errechnete
     * Fahrzeit aus.
     *
     * @param ziel der Name des Fahrziels
     * @param entfernung die Enfernung zum Ziel in km
     * @throws IllegalArgumentException wenn Entfernung < 0
     */
    public void fahreNach(String ziel, double entfernung) {
        if (entfernung < 0) {
            throw new IllegalArgumentException("Entfernung muss größer 0 sein");
        }
        System.out.println("Fahrt nach " + ziel + ". Fahrzeit: " + berechneFahrzeitAlsString(entfernung));
    }

    /**
     * Berechnet die Fahrzeit aus der Entfernung und gibt sie als formatierten
     * String aus.
     *
     * @param entfernung die zu fahrende Entfernung in km.
     * @return die berechnete Fahrzeit als String im Format "2 Tag(e) 1
     * Stunde(n) 37 Minute(n)"
     */
    protected String berechneFahrzeitAlsString(double entfernung) {
        /*
         Aus Entfernung in km und Geschwindigkeit in km/h lässt sich die 
         Fahrzeit in Stunden berechnen. Da beide double-Werte sind ist auch das 
         Ergebnis ein double, nicht die ganzzahlige Stundenzahl.
         */
        double zeitInStunden = entfernung / hoechstgeschwindigkeit;
        //Anzahl Tage berechnen.
        int tage = (int) (zeitInStunden / 24);
        //Die für Tage "verbrauchten" Stunden wegnehmen
        zeitInStunden %= 24;
        //Ganzzahlige Stunden werden durch cast nach int ermittelt
        int stunden = (int) zeitInStunden;
        //Minuten ergeben sich aus der Differenz zwischen genauer und ganzzahliger Stundenzahlö
        int minuten = (int) ((zeitInStunden - stunden) * 60);
        //Ergebnisstring zusammensetzen. Tage und Stunden werden ausgelassen, wenn an dieser Stelle eine 0 steht
        String ergebnis = "";
        if (tage > 0) {
            ergebnis += tage + " Tag(e) ";
        }
        if (stunden > 0) {
            ergebnis += stunden + " Stunde(n) ";
        }
        ergebnis += minuten + " Minute(n)";
        return ergebnis;
    }

}
