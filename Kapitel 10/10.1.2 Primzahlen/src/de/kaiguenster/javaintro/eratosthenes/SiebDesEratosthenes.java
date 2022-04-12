package de.kaiguenster.javaintro.eratosthenes;

/**
 * Ein Programm, um Primzahlen zu finden. Nach dem "Sieb des Erastothenes"-Algorithmus
 * werden alle Primzahlen kleiner als die gegebene Obergrenze identifiziert.
 * @author Kai
 */
public class SiebDesEratosthenes {

    /**
     * Wendet den Algorithmus an, um alle Primzahlen kleiner als <code>limit</code>
     * zu identifizieren.
     * @param limit die Obergrenze der Suche
     * @return ein Array aller Primzahlen kleiner der Obergrenze
     */
    public static int[]  findePrimzahlen(int limit){
        if (limit < 0 || limit > 100000){
            throw new IllegalArgumentException("Limit muss zwischen 0 und 100.000 liegen");
        }
        /*
        In einem boolean[] wird festgehalten, welche Zahlen teilbar sind. 
        Dies ist einfacher, als festzuhalten, welche Zahlen prim sind, da 
        boolean-Werte per Default false sind. 
        */
        boolean[] teilbar = new boolean[limit + 1];
        int gefunden = 0;
        //durch alle Werte kleiner Limit interieren
        for (int i = 2; i < teilbar.length; i++){
            if(!teilbar[i]){
                /*
                Wenn i nicht teilbar ist, ist es prim. In dem Fall werden alle 
                Vielfachen von i als teilbar markiert.
                */
                gefunden++;
                for (int j = 2 * i; j < teilbar.length; j += i){
                    teilbar[j] = true;
                }
            }
        }
        //Nun ist bekannt, wie viele Primzahlen es gibt
        int[] ergebnis = new int[gefunden];
        int ergebnisIndex = 0;
        //alle nicht teilbaren Zahlen werden in das Ergebnis-Array eingetragen 
        for (int i = 2; i < teilbar.length; i++){
            if (!teilbar[i]){
                ergebnis[ergebnisIndex++] = i;
            }
        }
        return ergebnis;
    }
    
}
