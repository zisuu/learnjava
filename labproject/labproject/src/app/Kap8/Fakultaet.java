package app.Kap8;

import java.math.BigInteger;

/**
 * Programm zur Fakultaet Berechnung.
 * 
 * Schreiben Sie ein Programm, das Fakultäten berechnet, und zwar einmal mit long und einmal mit BigInteger. 
 * In beiden Fällen sollen Fakultäten der Zahlen von 1 bis 100 ausgegeben werden oder bis ein Überlauf auftritt, 
 * falls das vorher passiert. Die Lösung zu dieser Übung finden Sie im Anhang.
 * 
 * @author Dave
 * @version 1.0
 */
public class Fakultaet {

    public static void main(String[] args) {
        System.out.println("## Generiere Fakultät von 1-100 mit long ##");
       for (int i = 1; i <= 100; i++) {
            long fakultaet = berechneFakultaetLong(i);
            //Es wird zu Überläufen kommen, darauf muss geprüft werden.
            if (fakultaet < 0) {
                System.out.println("Fakultät von Zahl " + i + " generiert Überlauf");
                //Nach dem ersten Überlauf wird diese Schleife unterbrochen
                break;
            } else {
                System.out.println("Fakultät von Zahl " + i + " ist = " + fakultaet);
            }
        }


        System.out.println("## Generiere Fakultät von 1-100 mit BigInteger ##");
        for (int i = 1; i <= 100; i++) {
            BigInteger fakultaet = berechneFakultaetBigInt(BigInteger.valueOf(i));
            System.out.println("Fakultät von Zahl " + i + " ist = " + fakultaet);
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
    public static long berechneFakultaetLong (long argument) {
        if (argument < 1) {
            throw new IllegalArgumentException("Fakultät ist nur für positive Zahlen definiert");
        }
        long fakultaet = argument;
        for (long counter = (argument -1); counter > 0; counter--){
            fakultaet = fakultaet * counter;
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
    public static BigInteger berechneFakultaetBigInt (BigInteger argument) {
        if (argument.compareTo(BigInteger.ONE) < 0) {
            throw new IllegalArgumentException("Fakultät ist nur für positive Zahlen definiert");
        }
        BigInteger fakultaet = argument;
        for (BigInteger counter = argument.subtract(BigInteger.ONE); counter.compareTo(BigInteger.ONE) > 0; counter = counter.subtract(BigInteger.ONE)){
            fakultaet = fakultaet.multiply(counter);
        }
        return fakultaet;
    }
}
