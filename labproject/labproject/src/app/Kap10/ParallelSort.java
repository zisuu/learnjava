package app.Kap10;

import java.util.Arrays;
import java.util.Random;

/**
 * Schreiben Sie dann ein Programm, das nacheinander zufällige Quader-Arrays der
 * Größe 10, 100, 1.000 … 10.000.000 erzeugt. Um zufällige Quadergrößen zu
 * erzeugen,können Sie die Klasse java.util.Random verwenden; limitieren
 * Sie die Quadergröße dabei in jede
 * Richtung auf 100.
 * 
 * Jedes dieser Arrays soll einmal sequenziell und einmal parallel sortiert
 * werden. Messen Sie jeweils
 * von beiden Sortierungen die Zeit, und geben Sie sie aus.
 * 
 * Vergleichen Sie, ab welcher Array-Größe parallele Sortierung Vorteile bringt.
 */

public class ParallelSort {
    public static void main(String[] args) {

        for (int i = 10; i <= 10000000; i *= 10) {
            vergleicheSortierung(i);
        }
    }

    /**
     * Vergleiche die Laufzeiten sequenzieller/paralleler Sortierung für Arrays
     * der gegebenen Länge
     * 
     * @param arraygroesse die Arraylänge
     */
    private static void vergleicheSortierung(int arraygroesse) {
        // Erzeuge ein zufälliges Array von Quadern
        Quader[] sortiereSequentiell = erzeugeTestArray(arraygroesse);
        // Kopiere das erzeugte Array, so dass beide Algorithmen mit den selben Daten
        // arbeiten
        Quader[] sortiereParallel = Arrays.copyOf(sortiereSequentiell, sortiereSequentiell.length);
        // Nimm die Zeit vor dem Start der sequenziellen Sortierung
        long vorSequentiell = System.currentTimeMillis();
        // Sortiere sequenziell
        Arrays.sort(sortiereSequentiell);
        // Nimm die Zeit zwischen sequenzieller und paralleler Sortierung
        long zwischen = System.currentTimeMillis();
        // Sortiere parallel
        Arrays.parallelSort(sortiereParallel);
        // Nimm die Endzeit
        long nachParallel = System.currentTimeMillis();
        // Gib aus, wie lange beide Operationen gedauert haben.
        System.out.println("Sequentielle Sortierung (" + arraygroesse + "): " + (zwischen - vorSequentiell) + " ms");
        System.out.println("Parallele Sortierung (" + arraygroesse + "): " + (nachParallel - zwischen) + " ms");
    }

    /**
     * Erzeugt ein Array zufälliger Quader der gegebenen Länge
     * 
     * @param arraygroesse die benötigte Länge
     * @return ein gefülltes Quader[] der benötigten Länge
     */
    private static Quader[] erzeugeTestArray(int arraygroesse) {
        Quader[] ergebnis = new Quader[arraygroesse];
        Random zufall = new Random();
        for (int i = 0; i < ergebnis.length; i++) {
            ergebnis[i] = new Quader(zufall.nextInt(100), zufall.nextInt(100), zufall.nextInt(100));
        }
        return ergebnis;
    }

}
