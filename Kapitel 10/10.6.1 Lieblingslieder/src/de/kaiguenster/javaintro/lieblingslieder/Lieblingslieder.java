package de.kaiguenster.javaintro.lieblingslieder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Klasse zur Verwaltung einer Liste von Lieblingsliedern für mehrere Benutzer.
 * @author Kai
 */
public class Lieblingslieder {
    private Map<String, List<Song>> daten = new HashMap<>();
    
    /**
     * FÜge für einen Benutzer ein Lieblingslied hinzu.
     * @param benutzer der Benutzer
     * @param song sein neues Lieblingslied
     */
    public void fuegeHinzu(String benutzer, Song song){
        //findeListeFürBenutzer stellt sicher, dass kein null zurückkommt.
        findeListeFuerBenutzer(benutzer).add(song);
    }
    
    /**
     * Finde die Liste von Lieblingsliedern eines Benutzers. 
     * @param benutzer der Benutzer
     * @return die Liste seiner Lieblingslieder als unveränderliche Liste, oder null, 
     * falls der Benutzer unbekannt ist.
     */
    public List<Song> getListeFuerBenutzer(String benutzer){
        List<Song> ergebnis = daten.get(benutzer);
        return ergebnis == null ? null : Collections.unmodifiableList(ergebnis);
    }
    
    /**
     * Entfernt die Liste von Lieblingsliedern für einen Benutzer
     * @param benutzer der Benutzer
     * @return die entfernte Liste.
     */
    public List<Song> entferneListeFuerBenutzer(String benutzer){
        return daten.remove(benutzer);
    }
    
    /**
     * Hilfsmethode, die die Liste für einen Benutzer findet, oder eine Liste erzeugt,
     * falls sie noch nicht existiert.
     * @param benutzer der Benutzer
     * @return die Liste seiner Lieblingslieder. Kann leer sein, aber niemals null
     */
    private List<Song> findeListeFuerBenutzer(String benutzer){
        //Prüfen, ob eine Liste für den Benutzuer existiert
        List<Song> ergebnis = daten.get(benutzer);
        if (ergebnis == null){
            //Falls nicht, wird eine Liste erzeugt und in daten gespeichert
            ergebnis = new ArrayList<>();
            daten.put(benutzer, ergebnis);
        }
        //ergenis ist nun in jedem Fall eine Liste, die zurückgegeben wird.
        return ergebnis;
    }
}
