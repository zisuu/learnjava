package de.kaiguenster.javaintro.fakultaet;

import java.math.BigInteger;

/**
 * Testprogramm zur Berechnung von Fakultäten
 *
 * @author Kai Günster
 */
public class Fakultaet {

    public static void main(String[] args) {
        //Es werden zuerst die Fakultäten 1! bis 100! mit long berechnet. 
        System.out.println("Fakultaeten mit Long");
        for (int zaehler = 1; zaehler <= 100; zaehler++) {
            long fakultaet = fakultaetLong(zaehler);
            //Es wird zu Überläufen kommen, darauf muss geprüft werden.
            if (fakultaet < 0) {
                System.out.println(zaehler + "! = ÜBERLAUF");
                //Nach dem ersten Überlauf wird diese Schleife unterbrochen
                break;
            } else {
                System.out.println(zaehler + "! = " + fakultaet);
            }
        }
        //Dieselben Fakultäten werden nun mit BigInteger berechnet.
        System.out.println("Fakultaeten mit BigInteger");
        for (int zaehler = 1; zaehler <= 100; zaehler++) {
            //Eine Überlaufprüfung ist nicht nötig, mit BigInteger ist ein Überlauf ausgeschlossen
            BigInteger fakultaet = fakultaetBigInteger(BigInteger.valueOf(zaehler));
            System.out.println(zaehler + "! = " + fakultaet);
        }

    }

    /**
     * Berechne die Fakultät eines long-Wertes. Überläufe werden nicht
     * behandelt!
     *
     * @param argument die Zahl, deren Fakultät berechnet werden soll
     * @return die Fakultät
     * @throws IllegalArgumentException wenn eine Zahl kleiner 1 übergeben wird.
     */
    protected static long fakultaetLong(long argument) {
        if (argument < 1) {
            throw new IllegalArgumentException("Fakultät ist nur für positive Zahlen definiert");
        }
        long fakultaet = argument;
        //In einer Schleife werden alle Zahlen zusammenmultipliziert.
        for (long zaehler = argument - 1; zaehler > 0; zaehler--) {
            fakultaet = fakultaet * zaehler;
        }
        return fakultaet;
    }

    /**
     * Berechne die Fakultät eines BigInteger-Wertes.
     *
     * @param argument die Zahl, deren Fakultät berechnet werden soll
     * @return die Fakultät
     * @throws IllegalArgumentException wenn eine Zahl kleiner 1 übergeben wird.
     */
    protected static BigInteger fakultaetBigInteger(BigInteger argument) {
        if (argument.compareTo(BigInteger.ONE) < 0) {
            throw new IllegalArgumentException("Fakultät ist nur für positive Zahlen definiert");
        }
        BigInteger fakultaet = argument;
        //Die Schleife entspricht exakt der aus fakultaetLong, sie sieht nur mit BigInteger umständlicher aus.
        for (BigInteger zaehler = argument.subtract(BigInteger.ONE); zaehler.compareTo(BigInteger.ONE) > 0; zaehler = zaehler.subtract(BigInteger.ONE)) {
            fakultaet = fakultaet.multiply(zaehler);
        }
        return fakultaet;
    }

}
