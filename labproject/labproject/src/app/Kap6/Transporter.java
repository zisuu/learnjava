package app.Kap6;

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
public interface Transporter {

    public void lade(String ladung);

    public String pruefeLadung();

    default public String entlade() {
        //Die aktuelle Ladung in einer lokalen Variablen zwischenspeichern
        String ladung = pruefeLadung();
        //Leere, neue Ladung aufladen
        lade(null);
        //Die alte Ladung zurückgeben
        return ladung;
    }
}
