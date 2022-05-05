package Kap6;

/**
 * Klasse Fahrzeug
 * 
 * Ihre Aufgabe in dieser größeren Übung besteht darin, die Domäne Fahrzeuge zu
 * modellieren. Alle Fahrzeuge haben die
 * folgenden Eigenschaften und Methoden:
 * OK: - Modell, Eigenschaft, String: Marke und Modell des Fahrzeugs, zum
 * Beispiel "VW Polo"
 * OK: - Höchstgeschwindigkeit, Eigenschaft, double: Die maximale
 * Geschwindigkeit des Fahrzeugs in km/h. Es sind Werte
 * zwischen 0 und 320 erlaubt, auch wenn hoffentlich niemand so schnell fährt.
 * OK: - Sitzplätze, Eigenschaft, int: wie viele Personen finden in diesem
 * Fahrzeug Platz?
 * OK: - fahreNach, Methode(String, double), void: Die Parameter sind der Name des
 * Ziels und die Entfernung in Kilometern.
 * Die Methode soll eine Ausgabe auf der Kommandozeile machen, die den Namen des
 * Zielortes und die Fahrzeit in Minuten, Stunden und, falls nötig, Tagen
 * enthält.
 * 
 * OK: Es gibt verschiedene Arten von Fahrzeugen: Motorräder, Fahrräder, PKWs
 * und LKWs. 
 * OK: Fahrräder haben eine maximale Höchstgeschwindigkeit von 135 km/h, das entspricht dem Geschwindigkeitsrekord
 * auf ebener Strecke.
 * OK: Einige dieser Fahrzeuge sind motorisiert. Das bringt keine zusätzlichen
 * Eigenschaften oder Fähigkeiten mit sich,
 * soll aber markiert werden. Außerdem sind LKWs und Lieferwagen eine spezielle
 * Art von PKW, nämlich Transporter.
 * Transporter haben zusätzlich folgende Methoden:
 * - lade, Methode(String), void: Im String-Parameter steht die Ladung, die in
 * den Transporter geladen wird.
 * - pruefeLadung, Methode(), String: Gibt die aktuelle Ladung zurück.
 * - entlade, Methode(), String: Gibt die aktuelle Ladung zurück und leert den
 * Transporter.
 * 
 * @author zisuu
 * @version 1.0
 */
public class Fahrzeug {
    private String markeUndModell;
    private double maxGeschwindigkeit; // in km/h
    private int sitzplaetze;

    public String getMarkeUndModell() {
        return this.markeUndModell;
    }

    public void setMarkeUndModell(String markeUndModell) {
        this.markeUndModell = markeUndModell;
    }

    public double getMaxGeschwindigkeit() {
        return this.maxGeschwindigkeit;
    }

    public void setMaxGeschwindigkeit(double maxGeschwindigkeit) {

        this.maxGeschwindigkeit = maxGeschwindigkeit;
    }

    public int getSitzplaetze() {
        return this.sitzplaetze;
    }

    public void setSitzplaetze(int sitzplaetze) {
        this.sitzplaetze = sitzplaetze;
    }

    /**
     * toString-Methode soll die Werte der Felder zurückgeben.
     * 
     * @return die String-Darstellung dieses Objekts.
     */
    public String toString() {
        return this.getClass().getName() + " Marke und Modell: " + this.markeUndModell + ", Max.Geschwindigkeit: "
                + this.maxGeschwindigkeit + "km/h" + ", Sitzplätze: " + this.getSitzplaetze();
    }

    /**
     * Methode die die Daten des Fahrzeugs auf die Kommandozeile ausgibt
     */
    public void print() {
        System.out.println(this);
    }

    /**
     * Methode für Fahrzeitberechnung
     * 
     * fahreNach, Methode(String, double), void: Die Parameter sind der Name des
     * Ziels und die Entfernung in Kilometern.
     * Die Methode soll eine Ausgabe auf der Kommandozeile machen, die den Namen des
     * Zielortes und die Fahrzeit in
     * Minuten, Stunden und, falls nötig, Tagen enthält.
     * 
     * @param zielName
     * @param zielEntfernung in km
     * @return fahrzeit Minuten, Stunden und falls nötig, Tagen
     */
    public void fahreNach(String zielName, double zielEntfernung) {
        Double fahrzeit = zielEntfernung / this.getMaxGeschwindigkeit() ;
        int fahrzeitInStunden = fahrzeit.intValue() % 24;
        Double fahrzeitInMinuten = (fahrzeit * 60) % 60;
        int fahrzeitInTage = fahrzeit.intValue() / 24;

        System.out.println("Fahrzeit nach " + zielName + " : " + fahrzeitInTage + " days, " + fahrzeitInStunden
                + " hours, " + fahrzeitInMinuten + " minutes");
    }

    /**
     * Konstruktor für Fahrzeug
     *
     * @param markeUndModell     des Fahrzeugs
     * @param maxGeschwindigkeit des Fahrzeugs, in km/h
     * @param sitzplaetze        des Fahrzeugs
     */
    public Fahrzeug(String markeUndModell, Double maxGeschwindigkeit, int sitzplaetze) {
        if (maxGeschwindigkeit < 0 || maxGeschwindigkeit > 320) {
            throw new IllegalArgumentException("Max. Geschwindigkeit muss zwischen 0 und 320 sein");
        }
        this.markeUndModell = markeUndModell;
        this.maxGeschwindigkeit = maxGeschwindigkeit;
        this.sitzplaetze = sitzplaetze;
    }

    public interface Motorisiert {

    }

    public interface Transporter {
        
    }
}
