package de.kaiguenster.javaintro.bmirechner;
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Kommandozeilenanwendung, um aus Gewicht und Größe einer Perden den 
 * Body-Mass-Index zu berechnen.
 * @author Kai Günster
 */
public class BMIRechner {

    public static void main(String[] args) throws IOException {
        //Zuerst werden die Nutzereingaben gelesen
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Bitte geben Sie Ihre Größe in cm an");
        int groesseCM = Integer.parseInt(reader.readLine());
        System.out.println("Bitte geben Sie Ihr Gewicht in kg an");
        int gewicht = Integer.parseInt(reader.readLine());
        
        //Dann wird gerechnet
        double groesse = (double) groesseCM / 100;
        double bmi = gewicht / (groesse * groesse);
        
        //Zuletzt wird das Egebnis ausgegeben
        //Mit DecimalFormat wird der bmi für die Augabe formatiert
        NumberFormat formatter = new DecimalFormat("##.##");
        System.out.println("Ihr BMI ist " + formatter.format(bmi));
        //Und mit if-else wird der errechnete Wert in eine der vier Kategorien einsortiert.
        if (bmi < 18.5){
            System.out.println("Damit haben Sie Untergewicht");
        } else if (bmi < 25){
            System.out.println("Damit haben Sie Normalgewicht");
        } else if (bmi < 30){
            System.out.println("Damit haben Sie Übergewicht");
        } else {
            System.out.println("Damit haben Sie schweres Übergewicht");
        }
    }
    
}
