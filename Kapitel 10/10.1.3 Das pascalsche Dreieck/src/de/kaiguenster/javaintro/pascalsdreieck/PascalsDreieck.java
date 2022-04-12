package de.kaiguenster.javaintro.pascalsdreieck;

/**
 * Klasse zur Berechnung und Ausgabe des Pascalschen Dreiecks, eines Konstrukts 
 * zur Bestimmung von Binomialkoeffizienten. Das sind die Faktoren, die zur 
 * Berechnung einer Formal der Form (a+b)<sup>n</sup> benötigt werden. Zum Beispiel
 * sind in (a+b)<sup>2</sup> = 1a<sup>2</sup> + 2ab + 1b<sup>2</sup> die Zahlen 
 * 1, 2 und 1 die Koeffizienten, die aus der dritten Zeile des Dreiecks abgelesen
 * werden können.
 * Jedes Dreieck enthält so viele Zeile, wie im Konstruktor übergeben. Werden 
 * größere Zeilen benötigt,  muss ein neues Dreieck berechnet werden.
 * @author Kai Günster
 */
public class PascalsDreieck {

    private final int[][] dreieck;
    
    /**
     * Konstruktor für ein neues Objekt
     * @param zeilen die Anzahl Zeilen in diesem Dreieck. 
     */
    public PascalsDreieck(int zeilen){
        dreieck = new int[zeilen + 1][];
        berechneDreieck();
    }
    
    /**
     * Liest eine Zeile von Koeffizienten aus. Die Zählung der Zeilen ist 0-basiert, 
     * dadurch finden Sie die Koeffizienten zu (a+b)<sup>2</sup> auch wirklich in 
     * Zeile 2.
     * @param zeile die gesuchte Zeile
     * @return ein Array der Koeffizienten.
     */
    public int[] getZeile(int zeile){
        if (zeile >= dreieck.length){
            throw new IllegalArgumentException("Zeile liegt außerhalb dieses Dreiecks");
        }
        return dreieck[zeile];
    }
    
    @Override
    public String toString(){
        //Um das Dreieck in die richtige Form zu bringen, müssen wir zunächst wissen, wie lang die letzte Zeile ist.
        //Deshalb wird diese zuerst berechnet. 
        String letzteZeile = schreibeZeile(dreieck[dreieck.length - 1], new StringBuilder()).toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dreieck.length - 1; i++){
            /*
            Für jede Zeile außer der letzen wird ein String erzeugt, der links 
            und rechts die gleiche Zahl Leerzeichen hat. Dieser wird an einen 
            StringBuilder angehangen.
            */
            int[] zeile = dreieck[i];
            polstereZeile(schreibeZeile(zeile, sb), letzteZeile.length());
            
            sb.append("\n");
        }
        //Zum Schluss muss die Anfangs berechnete letzte Zeile angehangen weren.
        sb.append(letzteZeile).append("\n");
        return sb.toString();
    }

    /**
     * Schreibt eine Zeile des Dreiecks sauber formatiert in einen StringBuilder.
     * @param zeile die Zeile, die es zu schreiben gilt
     * @param sb das Ziel der Ausgabe
     * @return den übergebenen StringBuilder
     */
    private StringBuilder schreibeZeile(int[] zeile, StringBuilder sb) {
        for (int j = 0; j < zeile.length; j++){
            /*
            Fügt jede Zahl aus dem Array in die Ausgabe ein, jeweils gefolgt von
            einem Zwischenraum zur nächsten Zahl-
            */
            sb.append(zeile[j]).append("  ");
        }
        return sb;
    }
    
    /**
     * Polstert eine Zeile mit Leerzeichen für die Ausgabe in Dreiecksform. 
     * @param sb die Gesamtausgabe bisher. Nur die letzte Zeile wird verändert-
     * @param zeilenlaenge die benötigte Gesamtlänge
     */
    private void polstereZeile(StringBuilder sb, int zeilenlaenge){
        //Anfang der letzten Zeile finden.
        int letzteZeileStart = sb.lastIndexOf("\n") + 1;
        //Deren Länge ermitteln
        int letzteZeileLaenge = sb.length() - letzteZeileStart;
        /*
        Die Hälfte der Differenz zwischen echter Zeilenlänge und benötigter 
        Zeilenlänge muss eingefügt werden, um die Dreiecksform zu erreichen.
        */
        int fuellung = (zeilenlaenge - letzteZeileLaenge) / 2;
        for (int i = 0; i < fuellung; i ++){
            /*
            Füge die benötigten Leerzeichen am Anfang der Zeile ein.
            Am Ende wird nichts eingefügt, denn abschließende Leerzeichen wäre 
            ohnehin nicht sichtbar.
            */
            sb.insert(letzteZeileStart, " ");
        }
    }
    
    /**
     * Berechne das vollständige Dreieck.
     */
    private final void berechneDreieck() {
        if (dreieck.length == 0) return;
        //Die erste Zeile wird mit "1" initialisiert.
        dreieck[0] = new int[]{1};
        for(int i = 1; i < dreieck.length; i++){
            //Weitere Zeilen werden jeweils aus der Vorzeile berechnet.
            dreieck[i] = berechneNaechsteZeile(dreieck[i-1]);
        }
    }

    /**
     * Berechnet eine Zeile des Dreiecks aus der Vorzeile. 
     * @param vorzeile
     * @return 
     */
    private final int[] berechneNaechsteZeile(int[] vorzeile) {
        //Die neue Zeile ist um eine Zahl länger als die vorherige.
        int[] zeile = new int[vorzeile.length + 1];
        //Jede Zahl wird in der Schleife berechnet als Summe der Zahlen recht und links oberhalb
        for (int i = 0; i < zeile.length; i++){
            //Zahl links oberhalb. Existiert nicht am linken Rand, in diesem Fall 0
            int vorLinks = (i == 0 ? 0 : vorzeile[i - 1]);
            //Zahl rechts oberhalb. Existiert nicht am rechzten Rand, in diesem Fall 0
            int vorRechts = (i >= vorzeile.length ? 0 : vorzeile[i]);
            zeile[i] = vorLinks + vorRechts;
        }
        return zeile;
    }    
}
