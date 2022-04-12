package de.kaiguenster.javaintro.bmirechner;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Programm zur Berechnung des Body-Mass-Index (BMI) aus Größe und Gewicht einer
 * Person.
 *
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
        double bmi = berechneBMI(groesseCM, gewicht);
        //Zuletzt wird das Egebnis ausgegeben
        // Mit DecimalFormat wird der bmi für die Augabe formatiert
        NumberFormat formatter = new DecimalFormat("##.##");
        System.out.println("Ihr BMI ist " + formatter.format(bmi));
        System.out.println("Damit haben Sie " + bmiZuKategorie(bmi));
    }

    /**
     * Methode zur Berechnung des BMI aus Größe und Gewicht
     *
     * @param groesseCM Körpergröße in cm.
     * @param gewichtKG Gewicht in kg.
     * @return den BMI
     * @throws IllegalArgumentException wenn Größe oder Gewicht <= 0
     */
    public static double berechneBMI(int groesseCM, int gewichtKG) {
        if (groesseCM <= 0) {
            throw new IllegalArgumentException("Größe muss mehr als 0 cm sein.");
        }
        if (gewichtKG <= 0) {
            throw new IllegalArgumentException("Gewicht muss mehr als 0 kg sein.");
        }
        double groesse = (double) groesseCM / 100;
        double bmi = gewichtKG / (groesse * groesse);
        return bmi;
    }

    /**
     * Methode zur Einordnung des BMI-Werts in die Gewichtskategorien Untergewicht, 
     * Normalgewicht, Übergewicht und schweres Übergewicht.
     * @param bmi
     * @return 
     */
    public static String bmiZuKategorie(double bmi) {
        if (bmi <= 0) {
            throw new IllegalArgumentException("BMI muss größer 0 sein.");
        }
        if (bmi < 18.5) {
            return "Untergewicht";
        } else if (bmi < 25) {
            return "Normalgewicht";
        } else if (bmi < 30) {
            return "Übergewicht";
        } else {
            return "schweres Übergewicht";
        }
    }

}
