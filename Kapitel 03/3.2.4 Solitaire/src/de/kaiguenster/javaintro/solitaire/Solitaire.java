package de.kaiguenster.javaintro.solitaire;

/**
 * Ein Programm, das prüft, ob eine Karte im Solitaire-Spiel angelegt werden kann. 
 * Die Regeln dazu lauten:
 * - die neue Karte muss einen um genau 1 geringeren Wert haben, als die vorherige Karte
 * - sie muss die andere Farbe (echte Farbe, nicht Kartenfarbe) haben, eine rote Karte kann also nur an eine schwarze angelegt werden und umgekehrt.
  * @author Kai Günster
 */
public class Solitaire {

    /**
     * Diese Methode prüft, ob eine Karte an eine andere angelegt werden darf
     * @param farbeAlt Farbe der alten (schon liegenden) Karte
     * @param wertAlt Wert der alten Karte
     * @param farbeNeu Farbe der neuen (anzulegenden) Karte
     * @param wertNeu Wert der neuen Karte
     * @return true wenn die neue Karte angelegt werden darf, sonst false
     */

    public static boolean kannAnlegen(String farbeAlt, int wertAlt, String farbeNeu, int wertNeu){
        //Feststellen, welche der Karten rot ist - schwarz würde ebenso funktionieren, es geht nur um Gleichehit
        boolean altRot = "Herz".equals(farbeAlt) || "Karo".equals(farbeAlt);
        boolean neuRot = "Herz".equals(farbeNeu) || "Karo".equals(farbeNeu);
        //Prüfung: ist genau einer der Karten rot (geprüft mit XOR) und ist der neue Wert um eins kleiner als der alte
        boolean ergebnis = (altRot ^ neuRot) && wertNeu + 1 == wertAlt;
        return ergebnis;        
    }
    
    /**
     * Prüft, ob für zwei Karten richtig ermittelt wird, ob die eine an die andere angelegt werden darf.
     * Diese Methode dient der Prüfung Ihrer Lösung.
     * @param farbeAlt Farbe der alten (schon liegenden) Karte
     * @param wertAlt Wert der alten Karte
     * @param farbeNeu Farbe der neuen (anzulegenden) Karte
     * @param wertNeu Wert der neuen Karte
     * @param erwartet das erwartete Ergebnis: true, wenn die Karten angelegt werden kann, sonst falsch
     */
    public static void pruefeKarte(String farbeAlt, int wertAlt, String farbeNeu, int wertNeu, boolean erwartet){
        boolean ergebnis = kannAnlegen(farbeAlt, wertAlt, farbeNeu, wertNeu);
        System.out.print(farbeNeu + " " + wertNeu + " auf " + farbeAlt + " " + wertAlt + " ");
        System.out.print(ergebnis ? "ist möglich " : " ist nicht möglich");
        if (erwartet == ergebnis){
            System.out.println(" ===> RICHTIG");
        } else {
            System.out.println(" ===> FALSCH");
        }
    }
    
    public static void main(String[] args) {
        pruefeKarte("Herz", 8, "Pik", 7, true);
        pruefeKarte("Herz", 9, "Pik", 7, false);
        pruefeKarte("Herz", 8, "Kreuz", 7, true);
        pruefeKarte("Karo", 6, "Pik", 7, false);
        pruefeKarte("Herz", 2, "Pik", 1, true);
        pruefeKarte("Karo", 8, "Herz", 7, false);
        pruefeKarte("Karo", 6, "Herz", 7, false);
        pruefeKarte("Herz", 11, "Kreuz", 10, true);
        pruefeKarte("Pik", 8, "Karo", 7, true);
        pruefeKarte("Kreuz", 7, "Pik", 5, false);
    }
    
}
