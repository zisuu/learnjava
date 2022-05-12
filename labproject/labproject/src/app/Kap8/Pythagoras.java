package app.Kap8;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Programm zur Pythagoras Berechnung.
 * 
 * Verwendet die Methoden von Math, um den Satz des Pythagoras (a2 + b2 = c2) umzusetzen. 
 * Fragt die Länge der beiden Katheten a und b vom Benutzer ab, und berechnet die Länge der Hypotenuse c. 
 * 
 * @author Dave
 * @version 1.0
 */
public class Pythagoras {

    /**
     * 
     * @param katheteA - Kathete a als <code>double</code>
     * @param katheteB - Kathete b als <code>double</code>
     * @return Hypotenuse c als <code>double</code>
     * @throws IllegalArgumentException wenn ungültige Zahl
     */

    public static void main(String[] args) throws IOException {
        System.out.println("## Hypotenuse Rechner ##");
        System.out.println("Kathete a: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double katheteA = Double.parseDouble(reader.readLine());
        System.out.println("Kathete b: ");
        double katheteB = Double.parseDouble(reader.readLine());
        //Dann wird gerechnet
        double hypotenuseC = getHypotenuse(katheteA,katheteB);
        NumberFormat formatter = new DecimalFormat("##.##");
        System.out.println("Hypotenuse c ist: " + formatter.format(hypotenuseC));
    }

    public static double getHypotenuse(double katheteA, double katheteB){
        if (katheteA <=0 || katheteB <=0) {
            throw new IllegalArgumentException("Katheten müssen >0 sein.");
        }
        if (katheteA >= Double.MAX_VALUE || katheteB >= Double.MAX_VALUE ) {
            throw new ArithmeticException("Katheten sind ausserhalb Wertebereich limit von " + (Double.MAX_VALUE -1));
        }
        return Math.sqrt(Math.pow(katheteA, 2) + Math.pow(katheteB, 2));
    }
}
