package de.kaiguenster.javaintro.flugfinder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hilfklasse zum auffinden von Flugnummern in einer Sammlung von Texten.
 *
 * @author Kai Günster
 */
public class Flugfinder {

    /**
     * Regulärer Ausdruck für Flugnummern: zwei Großbuchstaben, gefolgt von
     * einem Minus, gefolgt von einer oder mehr Ziffern
     */
    private static final Pattern FLUGNUMMER = Pattern.compile("[A-Z]{2}-[0-9]+");

    /**
     * Findet eine Flugnummer in einer Sammlung von Texten.
     * @param texte die Texte
     * @return die erste gefundene Flugnummer
     */
    public static String findeFlugnummer(String[] texte) {
        //Iteriere durch alle Texte
        for (int i = 0; i < texte.length; i++) {
            String text = texte[i];
            //Wende den regulären Ausdruck für Flugnummern an
            Matcher matcher = FLUGNUMMER.matcher(text);
            //Wurde eine Flugnummer gefunden, wird sie zurückgegeben
            if (matcher.find()) {
                //group() ohne Parameter gibt den gesamten passenden Text (also die Flugnummer) zurück.
                return matcher.group();
            }
        }
        return null;
    }
}
