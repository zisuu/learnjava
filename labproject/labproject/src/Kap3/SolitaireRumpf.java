package Kap3;

public class SolitaireRumpf {
    
    public static boolean kannAnlegen(String farbeAlt, int wertAlt, String farbeNeu, int wertNeu) {
        boolean ergebnis = false;

        // erkenne ob farbeAlt rot, erkenne ob farbeNeu rot
        boolean altRot = ("Herz".equals(farbeAlt) || "Karo".equals(farbeAlt));
        boolean neuRot = ("Herz".equals(farbeNeu) || "Karo".equals(farbeNeu));
        // überprüfe ob Wert neu = wert alt -1:
        ergebnis = altRot ^ neuRot && (wertNeu == wertAlt - 1);

        return ergebnis;
    }

    public static void pruefeKarte(String farbeAlt, int wertAlt, String farbeNeu, int wertNeu, boolean erwartet) {
        boolean ergebnis = kannAnlegen(farbeAlt, wertAlt, farbeNeu, wertNeu);
        System.out.print(farbeNeu + " " + wertNeu + " auf " + farbeAlt + " " + wertAlt + " ");
        System.out.print(ergebnis ? "ist möglich " : " ist nicht möglich");
        if (erwartet == ergebnis) {
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