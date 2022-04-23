package Kap4;

import java.io.*;

// Wenn Sie in den bisherigen Beispielen eine Zahl eingeben sollten, aber dann etwas anderes eingegeben haben, 
// kam es zu einer sehr unschönen NumberFormatException. In Kapitel 9, »Fehler und Ausnahmen«, werden Sie zwar 
// lernen, mit dieser Fehlermeldung umzugehen, aber schon jetzt können Sie in einem String Zeichen für Zeichen 
// prüfen, ob es sich um eine Zahl handelt. Sie können Strings ähnlich wie Arrays behandeln: Die Methode length
//  – Vorsicht, bei Strings ist es eine Methode – gibt an, wie viele Zeichen im String enthalten sind, die Methode 
//  charAt gibt das Zeichen an der angegebenen Stelle zurück.
// Schreiben Sie ein Programm, das den Benutzer einen String eingeben lässt, das prüft, ob dieser String eine 
// gültige Zahl ist, und das eine entsprechende Meldung ausgibt. Die Lösung zu dieser Übung finden Sie im Anhang.


 /**
 * Programm das den Benutzer einen String eingeben lässt, das prüft, ob dieser String eine gültige Zahl ist, 
 * und das eine entsprechende Meldung ausgibt. 
 * @author Dave
 * @version 1.0
 */
public class zahlenpruefen {


    public static void main(String[] args) throws IOException {
        System.out.println("Bitte geben Sie den gewünschten Text ein, um zu überprüfen ob dieser Text aus gültigen Zahlen besteht: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String eingabe = reader.readLine();
        pruefeEingabe(eingabe);
    }

    public static void pruefeEingabe(String eingabe) {
        for (int i = 0; i < eingabe.length(); i++) {
            System.out.println(Character.isDigit(eingabe.charAt(i)) ? eingabe.charAt(i) + " is Digit" : eingabe.charAt(i) + " is not Digit");
        }
    }
}
