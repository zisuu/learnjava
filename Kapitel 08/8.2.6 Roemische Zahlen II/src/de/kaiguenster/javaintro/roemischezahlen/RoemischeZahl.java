package de.kaiguenster.javaintro.roemischezahlen;

/**
 * Enumeration römischer Ziffern. Zusammengesetzte Ziffern (wie IX = 9) werden
 * als eine Ziffer behandelt, um die Arbeit zu vereinfachen.
 *
 * @author Kai Günster
 */
public enum RoemischeZahl {
    /**
     * M = 1000
     */
    M(1000, -1, 0),
    /**
     * CM = 900
     */
    CM(900, 1, 3),
    /**
     * D = 500
     */
    D(500, 1, 1),
    /**
     * CD = 400
     */
    CD(400, 1, 1),
    /**
     * C = 100
     */
    C(100, 3, 0),
    /**
     * XC = 90
     */
    XC(90, 1, 3),
    /**
     * L = 50
     */
    L(50, 1, 1),
    /**
     * XL = 40
     */
    XL(40, 1, 1),
    /**
     * X = 10
     */
    X(10, 3, 0),
    /**
     * IX = 9
     */
    IX(9, 1, 3),
    /**
     * V = 5
     */
    V(5, 1, 1),
    /**
     * IV = 4
     */
    IV(4, 1, 1),
    /**
     * I = 1
     */
    I(1, 3, 0);
    private int wert;
    private int wiederholungen;
    private int ueberspringeStellen;
    
    /**
     * Privater Konstruktor, um die enum-Werte mit den benötigten Parametern zu
     * befüllen
     *
     * @param wert der Zahlenwert der Ziffer, für X z.B. 10
     * @param wiederholungen wie viele Wiederholungen der Ziffer sind erlaubt? X
     * darf bis zu dreimal vorkommen, IX oder L aber höchstens einmal. -1
     * bedeutet, dass beliebig viele Wiederholungen erlaubt sind.
     * @param ueberspringeStellen wie viele Ziffern müssen nach dem Parsen
     * übersprungen werden? Nach einem IX darf kein V, IV oder I folgen, es
     * müssen deshlab 3 Ziffern übersprungen werden.
     */    
    private RoemischeZahl(int wert, int wiederholungen, int ueberspringeStellen){
        this.wert = wert;
        this.wiederholungen = wiederholungen;
        this.ueberspringeStellen = ueberspringeStellen;
    }
    
    /**
     * Übersetzt eine römische Zahl in einen int-Wert
     *
     * @param roemisch die römische Zahl
     * @return den Zahlenwert der übergebenen Zahl
     * @throws IllegalArgumentException wenn roemisch nicht den Regeln für
     * römische Zahlen entspricht
     */
    public static int zuZahl(String roemisch) {
        int zahl = 0;
        //die übergebene römische Zahl wird in Großbuchtaben umgesetzt, um auch Eingaben wie "xii" zu erlauben.
        roemisch = roemisch.toUpperCase();
        RoemischeZahl[] alleZiffern = RoemischeZahl.values();
        //Diese Schleife durchläuft alle römischen Ziffern, angefangen mit M
        for (int i = 0; i < alleZiffern.length; i++) {
            RoemischeZahl ziffer = alleZiffern[i];
            int wiederholungen = 0;
            //Zählen, wie oft die aktuelle Ziffer vorkommt
            while (roemisch.startsWith(ziffer.name())) {
                wiederholungen++;
                //Wird die aktuelle Ziffer häufiger wiederholt, als erlaubt, wird ein Fehler geworfen
                if (ziffer.wiederholungen != -1 && wiederholungen > ziffer.wiederholungen) {
                    throw new IllegalArgumentException("Zu viele Wiederholungen von Symbol " + ziffer);
                }
                //Der Wert der aktuellen Ziffer wird zum Ergebnis addiert.
                zahl += ziffer.wert;
                //Die gerade gelesene Ziffer wird am Anfang der römischen Zahl entfernt.
                roemisch = roemisch.substring(ziffer.name().length());
            }
            /*
            Wenn die aktuelle Ziffer vorkam, wird die Laufvariable der Schleife 
            manipuliert, um Ziffern zu überspringen. Das bedeutet z.B.: wenn L gelesen 
            wurde, darf danach kein XL folgen. Folgt doch eine übersprungene Ziffer,
            so können weitere Stellen der Zahl nicht mehr gelesen werden, die Prüfung 
            unten wird dies feststellen und einen Fehler werfen.
            */
            if (wiederholungen > 0) {
                i = i + ziffer.ueberspringeStellen;
            }
        }
        //Sind Ziffern übrig (zum Beispiel weil übersprungene Ziffern vorkamen) wird hier ein Fehler geworfen.
        if (roemisch.length() > 0) {
            throw new IllegalArgumentException("Zahl konnte nicht vollständig geparst werden. Verbleibende Zahl: " + roemisch);
        }
        return zahl;
    }
    
    /**
     * Übersetzt einen int-Wert in eine römische Zahl
     * @param zahl die zu übersetzende Zahl
     * @return die entsprechende römische Zahl
     */
    public static String zuRoemisch(int zahl){
        //In diesem StringBuilder wird das Ergebnis aufgebaut
        StringBuilder ergebnis = new StringBuilder();
        //Negative Zahl: ein Minus-Zeichen an den Anfang der römischen Zahl schreiben, dann die positive Zahl parsen
        if (zahl < 0){
            ergebnis.append("-");
            zahl *= -1;
        }
        RoemischeZahl[] alleZiffern = RoemischeZahl.values();
        //Durch alle römischen Ziffern iterieren
        for (int i = 0; i < alleZiffern.length; i++){
            RoemischeZahl ziffer = alleZiffern[i];
            //Solange der verbleibende Zahlenwert größer ist als der Wert der aktuellen Ziffer ...
            while (zahl >= ziffer.wert){
                //... wird der Ziffernwert von der Zahl abgezogen ...
                zahl -= ziffer.wert;
                //... und die Ziffer an die römische Zahl angehangen
                ergebnis.append(ziffer.name());
            }
        }
        return ergebnis.toString();
    }
    
}
