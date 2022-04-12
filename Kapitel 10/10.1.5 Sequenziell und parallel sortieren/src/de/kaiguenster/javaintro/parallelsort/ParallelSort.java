package de.kaiguenster.javaintro.parallelsort;

import java.util.Arrays;
import java.util.Random;

/**
 * Programm zum Vergleich der Laufzeiten sequenzieller und paralleler Sortierung.
 * @author Kai Günster
 */
public class ParallelSort {

        public static void main(String[] args) {
            //In Sprüngen von Faktor 10 werden Arrays verschiedener Länge getestet
            for (int i = 10; i < 10000000; i *= 10)
                vergleicheSortierung(i);
        }

        /**
         * Vergleiche die Laufzeiten sequenzieller/paralleler Sortierung für Arrays 
         * der gegebenen Länge
         * @param arraygroesse die Arraylänge
         */
        private static void vergleicheSortierung(int arraygroesse) {
            //Erzeuge ein zufälliges Array von Quadern
            Quader[] sortiereSequentiell = erzeugeTestArray(arraygroesse); 
            //Kopiere das erzeugte Array, so dass beide Algorithmen mit den selben Daten arbeiten
            Quader[] sortiereParallel = Arrays.copyOf(sortiereSequentiell, sortiereSequentiell.length);
            //Nimm die Zeit vor dem Start der sequenziellen Sortierung
            long vorSequentiell = System.currentTimeMillis();
            //Sortiere sequenziell
            Arrays.sort(sortiereSequentiell);
            //Nimm die Zeit zwischen sequenzieller und paralleler Sortierung
            long zwischen = System.currentTimeMillis();
            //Sortiere parallel
            Arrays.parallelSort(sortiereParallel);
            //Nimm die Endzeit
            long nachParallel = System.currentTimeMillis();
            //Gib aus, wie lange beide Operationen gedauert haben.
            System.out.println("Sequentielle Sortierung (" + arraygroesse+ "): " + (zwischen - vorSequentiell) + " ms");
            System.out.println("Parallele Sortierung (" + arraygroesse+ "): " + (nachParallel - zwischen) + " ms");
        }

        /**
         * Erzeiugt ein Array zufälliger Quader der gegebenen Länge
         * @param arraygroesse die benötigte Länge
         * @return ein gefülltes Quader[] der benötigten Länge
         */
        private static Quader[] erzeugeTestArray(int arraygroesse){
            Quader[] ergebnis = new Quader[arraygroesse];
            Random zufall = new Random();
            for (int i = 0; i < ergebnis.length; i++){
                ergebnis[i] = new Quader(zufall.nextInt(100), zufall.nextInt(100), zufall.nextInt(100));
            }
            return ergebnis;
        }
    
}
