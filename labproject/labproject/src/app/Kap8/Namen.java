package app.Kap8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Programm zur Verarbeitung von Namen.
 * 
 * Schreiben Sie eine Methode, die Namen im Format »Nachname, Vorname«
 * entgegennimmt und sie in der Form »Vorname Nachname« wieder ausgibt.
 * Vergessen Sie nicht die Testfälle!
 * Denken Sie vor allem darüber nach, wie Sie reagieren, wenn kein Komma oder
 * mehrere Kommata vorkommen.
 * 
 * @author Dave
 * @version 1.0
 */
public class Namen {

    // Given: Der Benutzer wird nach Nachname und Vorname gefragt im Format
    // "Nachname, Vorname" und
    // für die verarbeitung an die zuständige Methode übergeben.
    public static void main(String[] args) throws IOException {
        System.out.println("## Bitte geben Sie Nachname und Vorname im Format 'Nachname, Vorname' an ##");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String eingabeString = reader.readLine();
        // gebe Veratbeitung wieder aus
        System.out.println("Ihre Daten wurden wiefolgt gespeichert: " + validateName(eingabeString));
    }

    // When: Wenn der Benutzer die Eingabe gemacht hat, soll diese von "Nachname,
    // Vorname" in
    // »Vorname Nachname« geändert werden.
    // Then: Name soll im neuen Format ausgegeben werden.
    public static String validateName(String name) {
        // wenn der Name Leer ist soll das als Fehler behandelt werden.
        if (name.equals("")) {
            throw new IllegalArgumentException("Name kann nicht leer sein");
        }
        // wenn mehr oder weniger als ein Komma enthalten ist, soll das als Fehler
        // behandelt werden, dazu gibt es die validateComma Methode
        if (validateComma(name) != 1){
            throw new IllegalArgumentException("Fehler: es muss ein Komma, gefolgt von einem leerschlag vorhanden sein! Bitte korrigiere Eingabe!");
        }
        // lokalisiere das Komma
        int index = name.indexOf(",");
        // erkenne Vorname
        String nachname = name.substring(0, index);
        // erkenne Nachname
        String vorname = name.substring(index+2, name.length());
        // setze neuen String zusammen
        name = vorname + " " + nachname;
        return name;
    }

    /**
     * Ermittelt wieviele Kommas im String name vorhanden sind und gibt die Anzahl zurück
     *
     * @param name der String, der geprüft werden soll
     * @return die Anzahl Kommatas
     * 
     */
    public static int validateComma(String name) {
        int index = name.indexOf(", ");
        int coutComma = 0;
        while (index != -1) {
            coutComma++;
            index = name.indexOf(", ", index + 1);
        }
        return coutComma;
    }
}
