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
    public static void main(String[] args) {
        String[] postfach = new String []{"Hans Fischer", "RTestmail 12235", "HE-877665436", "sdgsdfas124w-as12", "ZH-454", "-BE-1111"};
        findFlightNumber(postfach);
    }

    /**
     * Durchsucht das StringArray postFach nach Flugnummern.
     *
     * @param postfach als StringArray
     * @return die Flugnummern
     * @throws IllegalArgumentException wenn keine Flugnummern gefunden
     */
    public static void findFlightNumber(String [] postfach){
        String flightNumber = "";
         // TODO: Regex Anpassen    
        Pattern FLIGHTNUMBER_PATTERN = Pattern.compile("(^[A-Z]{2}[-]\\d+)");
        if (postfach == null){
            throw new IllegalArgumentException("Postfach darf nicht null sein");
        }
        for (int i = 0; i < postfach.length; i++) {
            Matcher matcher = FLIGHTNUMBER_PATTERN.matcher(postfach[i]);
            if (matcher.find()) {
                String result = matcher.group(0);
                System.out.println(result);
            }
        }
    }
    
}
