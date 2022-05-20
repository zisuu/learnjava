package app.Kap8;

import java.util.regex.*;

/**
 * Schreiben Sie eine Methode, die reguläre Ausdrücke benutzt, um ein String-Array – Ihr Postfach – 
 * nach der ersten Flugnummer zu durchsuchen. Eine Flugnummer besteht immer aus zwei Großbuchstaben, 
 * gefolgt von einem Bindestrich, gefolgt von einer Reihe von Ziffern.
 * 
 * @author Dave
 * @version 1.0
 */
public class Flugnummern {

    //Regex to find flightNumber
    private static final Pattern FLIGHTNUMBER_PATTERN = Pattern.compile("[A-Z]{2}-\\d+");

    /**
     * Durchsucht das StringArray postFach nach Flugnummern.
     *
     * @param postfach als StringArray
     * @return die Flugnummern
     * @throws IllegalArgumentException wenn keine Flugnummern gefunden
     */
    public static String findFlightNumber(String [] postfach){

        for (int i = 0; i < postfach.length; i++) {
            Matcher matcher = FLIGHTNUMBER_PATTERN.matcher(postfach[i]);
            if (matcher.find()) {
                return matcher.group();
            }
        }
        return null;
    }
    
}
