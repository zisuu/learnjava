package de.kaiguenster.javaintro.namensdreher;

/**
 * Programm, das Namen in umgedrehter Schreibweise (Günster, Kai) in herkömliche
 * Schreibweise (Kai Günster) umsortiert.
 *
 * @author Kai Günster
 */
public class Namensdreher {

    public static void main(String[] args) {
        //Der zu drehende Name wird als Aufrufparameter erwartet, das Ergebnis wird ausgegeben.
        System.out.println(dreheNamen(args[0]));
    }

    /**
     * Dreht einen Namen in umkehrter Schreibweise in normale Schreibweise.
     * Kommt im übergebenen Argumen kein Komma vor, wird nicht gedreht. Kommen
     * mehrere Kommas vor, so wird der letzte Teil zum ersten, der vorletzte zum
     * zweiten usw.
     *
     * @param eingabe der zu drehende Name
     * @return den gedrehten Namen,
     * @throws IllegalArgumentException für null als Eingabe
     */
    public static String dreheNamen(String eingabe) {
        if (eingabe == null) {
            throw new IllegalArgumentException("null ist keine gültige Eingabe.");
        }
        int index = eingabe.length();
        String ausgabe = "";
        //Die Schleife läuft, solange in Eingabe weitere Kommas gefunden werden.
        do {
            //Von hinten angefangen wird das nächste Komma ghesucht. 
            int naechsterIndex = eingabe.lastIndexOf(",", index - 1);
            //Der Text zwischen diesem Komma und dem vorherigen (oder dem Stringende) wird an die Ausgabe angehangen
            ausgabe += eingabe.substring(naechsterIndex + 1, index).trim();
            //Der Ausgabe wird ein Leerzeichen hinzugefügt
            ausgabe += " ";
            //Das gerade gefundene Komma wird für den nächsten Durchlauf zum vorherigen Komma
            index = naechsterIndex;
        } while (index > -1);
        return ausgabe.trim();
    }

}
