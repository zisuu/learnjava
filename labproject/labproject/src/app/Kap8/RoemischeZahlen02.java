package app.Kap8;


/**
 * Enumeration römischer Ziffern.
 * 
 * @author Dave
 * @version 1.0
 */
public enum RoemischeZahlen02 {

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
    private RoemischeZahlen02(int wert, int wiederholungen, int ueberspringeStellen) {
        this.wert = wert;
        this.wiederholungen = wiederholungen;
        this.ueberspringeStellen = ueberspringeStellen;
    }

    /**
     * Übersetzt eine römische Zahl in einen int-Wert
     *
     * @param eingabeString die römische Zahl
     * @return den Zahlenwert der übergebenen Zahl
     * @throws IllegalArgumentException wenn eingabeString nicht den Regeln für
     * römische Zahlen entspricht
     */
    public static int validateRomanString(String eingabeString) {
        int wert = 0;
         // wandle alle Kleinbuchstaben in Grossbuchstaben um
        eingabeString = eingabeString.toUpperCase();
        // lege array mit Römischen zahlen (enum) an
        RoemischeZahlen02[] alleZiffern = RoemischeZahlen02.values();
        // jeder Buchstabe wird einzel bewertet
        for (int i = 0; i < alleZiffern.length; i++) {
            RoemischeZahlen02 ziffer = alleZiffern[i];
            int wiederholungen = 0;
            while (eingabeString.startsWith(ziffer.name())) {
                wiederholungen++;
                //Wird die aktuelle Ziffer häufiger wiederholt, als erlaubt, wird ein Fehler geworfen
                if (ziffer.wiederholungen != -1 && wiederholungen > ziffer.wiederholungen) {
                    throw new IllegalArgumentException("Zu viele Wiederholungen von Symbol " + ziffer);
                }
                //Der Wert der aktuellen Ziffer wird zum Ergebnis addiert.
                wert += ziffer.wert;
                //Die gerade gelesene Ziffer wird am Anfang der römischen Zahl entfernt.
                eingabeString = eingabeString.substring(ziffer.name().length());
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
        if (eingabeString.length() > 0) {
            throw new IllegalArgumentException("Zahl konnte nicht vollständig geparst werden. Verbleibende Zahl: " + eingabeString);
        }
        return wert;

    }
}