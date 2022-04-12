/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.kaiguenster.javaintro.grundrechenarten;

/**
 *
 * @author Kai
 */
public class Grundrechenarten {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("Aufruf: java de.kaiguenster.javaintro.grundrechenarten.Grundrechenarten <zahl1> <zahl2>");
        }
        int zahl1 = Integer.parseInt(args[0]);
        int zahl2 = Integer.parseInt(args[1]);
        System.out.println("Summe: " + (zahl1 + zahl2));
        System.out.println("Differenz: " + (zahl1 - zahl2));
        System.out.println("Produkt: " + (zahl1 * zahl2));
        System.out.println("Quotient: " + (zahl1 / zahl2));
        System.out.println("Divisionsrest: " + (zahl1 % zahl2));
    }
    
}
