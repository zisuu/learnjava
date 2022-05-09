package app.Kap3;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Programm zur BMI Berechnung.
 * 
 * @author Dave
 * @version 1.0
 */
public class BMI {

    /**
     * mit diesem Programm sollen der BMI-(Body-Mass-Index-) berechnet werden
     * können.
     * Dazu müssen zunächst Größe und Gewicht des Benutzers abgefragt werden.
     * Aus diesen Angaben wird der BMI nach der Formel BMI = Gewicht ÷ Größe2
     * berechnet.
     * Dazu wird das Gewicht in Kilogramm und die Größe in Metern benötigt.
     * aber es ist etwas einfacher, die Größe in Zentimetern eingeben zu lassen und
     * umzurechnen,
     * so müssen Sie sich nicht um das Eingabeformat der Dezimalzahl kümmern.
     * 
     * @param bodyWeight - das Gewicht weightKg als <code>Integer</code>
     * @param bodyHeight - die Grösse in Zentimeter als <code>Integer</code>
     * @return BMI als <code>String</code>
     * @throws IllegalArgumentException wenn ungültige Zahl
     */
    public static String getBMI(Integer bodyWeight, Integer bodyHeight) {
        
        // Zentimeter in Meter umrechnen
        Double bodyHeightM = (double) bodyHeight / 100;
        // BMI berechnen
        Double BMI = bodyWeight / (bodyHeightM * bodyHeightM);
        NumberFormat formatter = new DecimalFormat("##.##");

        if (BMI < 18.5) {
            return "Untergewicht, BMI Wert: " + formatter.format(BMI);
        } else if (BMI > 18.5 && BMI < 25) {
            return "Normalgewicht, BMI Wert: " + formatter.format(BMI);
        } else if (BMI > 25 && BMI < 30) {
            return "Übergewicht, BMI Wert: " + formatter.format(BMI);
        } else {
            return "schweres Übergewicht, BMI Wert: " + formatter.format(BMI);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("## BMI Rechner ##");
        System.out.println("Eingabe Körpergewicht in [Kg]: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer bodyWeight = Integer.parseInt(reader.readLine());
        System.out.println("Eingabe Körpergrösse in [cm]: ");
        Integer bodyHeight = Integer.parseInt(reader.readLine());
        System.out.println(getBMI(bodyWeight, bodyHeight));
    }
}
