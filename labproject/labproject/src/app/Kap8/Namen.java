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
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name kann nicht leer sein");
        }
        int index = name.length();
        String ausgabe = "";
        //Die Schleife läuft, solange in Eingabe weitere Kommas gefunden werden.
        do {
            //Von hinten angefangen wird das nächste Komma ghesucht. 
            int naechsterIndex = name.lastIndexOf(",", index - 1);
            //Der Text zwischen diesem Komma und dem vorherigen (oder dem Stringende) wird an die Ausgabe angehangen
            ausgabe += name.substring(naechsterIndex + 1, index).trim();
            //Der Ausgabe wird ein Leerzeichen hinzugefügt
            ausgabe += " ";
            //Das gerade gefundene Komma wird für den nächsten Durchlauf zum vorherigen Komma
            index = naechsterIndex;
        } while (index > -1);
        return ausgabe.trim();
    }

}
