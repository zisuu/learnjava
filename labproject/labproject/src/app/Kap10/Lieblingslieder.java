package app.Kap10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Schreiben Sie im Musicplayer eine Klasse Lieblingslieder, die für jeden
 * Benutzer,
 * identifiziert durch einen Benutzernamen, eine Liste seiner Lieblingslieder
 * verwaltet.
 * Es soll einem Benutzer möglich sein, der Liste ein Lied hinzuzufügen, sich
 * alle für ihn
 * gespeicherten Lieder zurückgeben zu lassen und die Liste komplett zu
 * entfernen.
 */
public class Lieblingslieder {

    private Map<String, List<Song>> daten = new HashMap<>();

    /**
     * Füge für einen Benutzer ein Lieblingslied hinzu.
     * 
     * @param benutzer der Benutzer
     * @param song     sein neues Lieblingslied
     */
    public void fuegeHinzu(String benutzer, Song song) {
        // findeListeFürBenutzer stellt sicher, dass kein null zurückkommt.
        findeListeFuerBenutzer(benutzer).add(song);
    }

    /**
     * Hilfsmethode, die die Liste für einen Benutzer findet, oder eine Liste erzeugt,
     * falls sie noch nicht existiert.
     * @param benutzer der Benutzer
     * @return die Liste seiner Lieblingslieder. Kann leer sein, aber niemals null
     */
    public List<Song> findeListeFuerBenutzer(String benutzer) {
        // Prüfen, ob eine Liste für den Benutzuer existiert
        List<Song> ergebnis = daten.get(benutzer);
        if (ergebnis == null) {
            // Falls nicht, wird eine Liste erzeugt und in daten gespeichert
            ergebnis = new ArrayList<>();
            daten.put(benutzer, ergebnis);
        }
        // ergenis ist nun in jedem Fall eine Liste, die zurückgegeben wird.
        return ergebnis;
    }

    /**
     * Leere die Liste mit Lieblingssongs des Benutzers
     * @param benutzer
     * @return
     */
    public List<Song> leereListe(String benutzer){
        return daten.remove(benutzer);
    }

    /**
     * Finde die Liste von Lieblingsliedern eines Benutzers. 
     * @param benutzer der Benutzer
     * @return die Liste seiner Lieblingslieder als unveränderliche Liste, oder null, 
     * falls der Benutzer unbekannt ist.
     */
    public List<Song> getList(String benutzer){
        List<Song> ergebnis = daten.get(benutzer);
        return ergebnis == null ? null : Collections.unmodifiableList(ergebnis);
    }
}
