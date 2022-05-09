package app.Kap6;

import java.util.Comparator;

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
 * OK: - fahreNach, Methode(String, double), void: Die Parameter sind der Name
 * des
 * Ziels und die Entfernung in Kilometern.
 * Die Methode soll eine Ausgabe auf der Kommandozeile machen, die den Namen des
 * Zielortes und die Fahrzeit in Minuten, Stunden und, falls nötig, Tagen
 * enthält.
 * 
 * OK: Es gibt verschiedene Arten von Fahrzeugen: Motorräder, Fahrräder, PKWs
 * und LKWs.
 * OK: Fahrräder haben eine maximale Höchstgeschwindigkeit von 135 km/h, das
 * entspricht dem Geschwindigkeitsrekord
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

    /**
     * Konstruktor für Fahrzeug
     *
     * @param markeUndModell     des Fahrzeugs
     * @param maxGeschwindigkeit des Fahrzeugs, in km/h
     * @param sitzplaetze        des Fahrzeugs
     */
    public Fahrzeug(String markeUndModell, Double maxGeschwindigkeit, int sitzplaetze) {
        this.markeUndModell = markeUndModell;
        this.maxGeschwindigkeit = maxGeschwindigkeit;
        this.sitzplaetze = sitzplaetze;
    }

    /**
     * Getter für das Attribut Modell
     *
     * @return das Modell
     */
    public String getMarkeUndModell() {
        return this.markeUndModell;
    }

    /**
     * Setter für das Attribut Modell
     *
     * @param modell das neue Modell
     */
    public void setMarkeUndModell(String markeUndModell) {
        this.markeUndModell = markeUndModell;
    }

    /**
     * Getter für das Attribut maxGeschwindigkeit
     *
     * @return die Höchstgewschindigkeit in km/h
     */
    public double getMaxGeschwindigkeit() {
        return this.maxGeschwindigkeit;
    }

    /**
     * Setter für das Attribut Höchstgeschwindigkeit
     *
     * @param hoechstgeschwindigkeit die neue Höchstgeschwindigkeit in km/h
     * @throws IllegalArgumentException wenn Höchstgeschwindigkeit nicht
     *                                  zwischen 0 und 320 km/h
     */
    public void setMaxGeschwindigkeit(double maxGeschwindigkeit) {
        if (maxGeschwindigkeit < 0 || maxGeschwindigkeit > 320) {
            throw new IllegalArgumentException("Max. Geschwindigkeit muss zwischen 0 und 320 sein");
        }
        this.maxGeschwindigkeit = maxGeschwindigkeit;
    }

    /**
     * Getter für das Attribut Sitze
     *
     * @return die Anzahl Sitze in diesem Fahrzeug
     */
    public int getSitzplaetze() {
        return this.sitzplaetze;
    }

    /**
     * Setter für das Attribut Sitze
     *
     * @param sitze die neue Anzahl Sitze in diesem Fahrzeug
     */
    public void setSitzplaetze(int sitzplaetze) {
        this.sitzplaetze = sitzplaetze;
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
     * @throws IllegalArgumentException wenn Entfernung < 0
     */
    public void fahreNach(String zielName, double zielEntfernung) {
        if (zielEntfernung < 0) {
            throw new IllegalArgumentException("Entfernung muss grösser 0 sein");
        }
        System.out.println("Fahrt nach " + zielName + ". Fahrzeit: " + berechneFahrzeitAlsString(zielEntfernung));

    }

    /**
     * Berechnet die Fahrzeit aus der Entfernung und gibt sie als formatierten
     * String aus.
     *
     * @param zielEntfernung die zu fahrende Entfernung in km.
     * @return die berechnete Fahrzeit als String im Format "2 Tag(e) 1
     *         Stunde(n) 37 Minute(n)"
     */
    protected String berechneFahrzeitAlsString(double zielEntfernung) {
        /*
         * Aus Entfernung in km und Geschwindigkeit in km/h lässt sich die
         * Fahrzeit in Stunden berechnen. Da beide double-Werte sind ist auch das
         * Ergebnis ein double, nicht die ganzzahlige Stundenzahl.
         */
        Double fahrzeitInStunden = zielEntfernung / getMaxGeschwindigkeit();
        // Anzahl Tage berechnen.
        int fahrzeitInTage = (int) (fahrzeitInStunden / 24);
        // Die für Tage "verbrauchten" Stunden wegnehmen
        fahrzeitInStunden %= 24;
        // Ganzzahlige Stunden werden durch cast nach int ermittelt
        int stunden = fahrzeitInStunden.intValue();
        // Minuten ergeben sich aus der Differenz zwischen genauer und ganzzahliger
        // Stundenzahlö
        int fahrzeitInMinuten = (int) ((fahrzeitInStunden - stunden) * 60);
        // Ergebnisstring zusammensetzen. Tage und Stunden werden ausgelassen, wenn an
        // dieser Stelle eine 0 steht
        String duration = "";
        if (fahrzeitInTage > 0) {
            duration += fahrzeitInTage + " Tage, ";
        }
        if (fahrzeitInStunden > 0) {
            duration += stunden + " Stunden, ";
        }
        duration += fahrzeitInMinuten + " Minuten";
        return duration;
    }

    public static class GeschwindigkeitsComparator implements Comparator{
        public int compare(Object o1, Object o2){
            double g1 = ((Fahrzeug) o1).maxGeschwindigkeit;
            double g2 = ((Fahrzeug) o2).maxGeschwindigkeit;
            if (g1 < g2){
                return -1;
            } else if (g1 > g2){
                return 1;
            } else {
                return 0;
            }
        }
    }
}
