package app.Kap7;

import java.io.*;

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

    public static void main(String[] args) throws IOException {
        System.out.println("## BMI Rechner ##");
        System.out.println("Eingabe Körpergewicht in [Kg]: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer bodyWeight = Integer.parseInt(reader.readLine());
        System.out.println("Eingabe Körpergrösse in [cm]: ");
        Integer bodyHeight = Integer.parseInt(reader.readLine());
        System.out.println(getBMI(bodyWeight, bodyHeight));
    }

    public static double getBMI(int bodyHeight, int bodyWeight){
        double bodyHeightM = (double) bodyHeight / 100;
        double bmi = bodyWeight / (bodyHeightM * bodyHeightM);
        return bmi;
    }

    public static String bmiZuKategorie(double bmi){
        if (bmi < 18.5){
            return "Untergewicht";
        } else if (bmi < 25){
            return "Normalgewicht";
        } else if (bmi < 30){
            return "Übergewicht";
        } else {
            return "starkes Übergewicht";
        }
    }
}
