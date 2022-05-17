package app.Kap8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Programm zur Umwandlung von Römischen Zahlen in Int Zahl.
 * 
 * Um die Ziffern zu einer Zahl zusammenzusetzen, werden die entsprechenden Symbole wiederholt und summiert, 
 * dabei stehen höhere Werte immer vorn. Zum Beispiel ist die Zahl 123 in römischen Ziffern CXXIII.
 * Es gibt eine Ausnahme von der strikt aufsteigenden Folge: Ein einzelnes Einersymbol kann vor dem nächsthöheren 
 * Einer- oder Fünfersymbol stehen, um eine Subtraktion darzustellen. Die Zahl 4 wird als IV geschrieben: 5 – 1. 
 * Diese zusammengesetzten Symbole stehen in der Reihenfolge nach dem zugrunde liegenden Symbol. 293 schreiben Sie 
 * demnach als CCXCIII.
 * 
 * @author Dave
 * @version 1.0
 */
public class RoemischeZahlen01 {
    public static void main(String[] args) throws IOException {
        // Given: sei die Eingabe einer Römischen Ziffer
        System.out.println("## Bitte geben Sie die Römische Ziffer an ##");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String eingabeString = reader.readLine();
        // gebe Veratbeitung wieder aus
        System.out.println("Wert in Int: " + validateRomanString(eingabeString));

    }

    public static int validateRomanString(String eingabeString) {
        // When: die R.Ziffer eingegeben wurde, wird jeder Char des Strings mittels Switch Case gewertet und summiert.
        // Then: Resultat wird als Int ausgegeben

        // wenn der Name Leer ist soll das als Fehler behandelt werden.
        if (eingabeString == null || eingabeString.equals("")) {
            throw new IllegalArgumentException("eingabeString kann nicht leer sein");
        }

        // wandle alle Kleinbuchstaben in Grossbuchstaben um
        eingabeString = eingabeString.toUpperCase();

        int wert = 0;
        // jeder Buchstabe wird einzel bewertet
        for (int i = 0; i < eingabeString.length(); i++) {

            // ermittle Wert
            switch(eingabeString.charAt(i)){
                case 'I':
                    wert += 1;
                    break;
                case 'X':
                    wert += 10;
                    break;
                case 'C':
                    wert += 100;
                    break;
                case 'M':
                    wert += 1000;
                break;
                case 'V':
                    wert += 5;
                break;
                case 'L':
                    wert += 50;
                    break;
                case 'D':
                    wert += 500;
                break;
            }
        }
        return wert;
    }

}
