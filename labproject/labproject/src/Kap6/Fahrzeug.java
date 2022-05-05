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
 * - fahreNach, Methode(String, double), void: Die Parameter sind der Name des
 * Ziels und die Entfernung in Kilometern.
 * Die Methode soll eine Ausgabe auf der Kommandozeile machen, die den Namen des
 * Zielortes und die Fahrzeit in
 * Minuten, Stunden und, falls nötig, Tagen enthält.
 * 
 * OK: Es gibt verschiedene Arten von Fahrzeugen: Motorräder, Fahrräder, PKWs
 * und LKWs. Fahrräder haben eine maximale
 * Höchstgeschwindigkeit von 135 km/h, das entspricht dem Geschwindigkeitsrekord
 * auf ebener Strecke.
 * Einige dieser Fahrzeuge sind motorisiert. Das bringt keine zusätzlichen
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
        if (maxGeschwindigkeit < 0 || maxGeschwindigkeit > 320) {
            throw new IllegalArgumentException("Max. Geschwindigkeit muss zwischen 0 und 320 sein");
        }
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
     * @param zielEntfernung
     * @return fahrzeit Minuten, Stunden und, falls nötig, Tagen
     */
    public void fahreNach(String zielName, double zielEntfernung) {
        Double fahrzeitInStunden = this.getMaxGeschwindigkeit() / zielEntfernung;
        System.out.println("Fahrzeit nach " + zielName + " : " + fahrzeitInStunden +"h");
    }

    // /**
    //  * formatTime-Methode soll aus dem Feld laengeInSekunden eine Zeitangabe im
    //  * Format
    //  * Minuten:Sekunden berechnen und diese zurückgeben.
    //  * 
    //  * @param laengeInSekunden - Dauer des Songs in Sekunden als
    //  *                         <code>Integer</code>
    //  * @return laengeInMinutenSekunden - Dauer des Songs im Format minuten:sekunden
    //  *         als <code>Integer</code>
    //  */
    // public String formatTime() {
    //     Integer hours = this.getStunden();
    //     Integer minutes = this.getMinuten();
    //     String duration = "";
    //     if (hours > 0) {
    //         duration += leadingZeros(hours) + ":";
    //     }
    //     duration += leadingZeros(minutes) + ":" + leadingZeros(seconds);
    //     return duration;
    // }
}
