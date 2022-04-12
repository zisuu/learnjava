package de.kaiguenster.javaintro.mp3liste;

import de.kaiguenster.javaintro.playlist.Song;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Gemeinsame Oberklasse der Servlets des Musikprojekts. Gemeinsam genutzte Member
 * werden hier implementiert.
 * @author Kai Günster
 */
public abstract class MusikServlet extends HttpServlet {

    /**
     * Key, unter dem die Map gespeichert wird, die abgespielte Songs zählt.
     */
    protected static final String SESSION_SONGZAEHLER = "songzaehler";

    /**
     * Holt die Zähler-Map aus der Session. Falls sie dort noch nicht existiert, 
     * wird sie angelegt.
     * @param req der Request
     * @return die Map zum zählen abgespielter Songs, niemals null
     */
    protected Map<Song, Integer> getZaehlerMap(HttpServletRequest req) {
        Map<Song, Integer> zaehler = 
                (Map<Song, Integer>) req.getSession().getAttribute(SESSION_SONGZAEHLER);
        if (zaehler == null) {
            zaehler = new HashMap<>();
            req.getSession().setAttribute(SESSION_SONGZAEHLER, zaehler);
        }
        return zaehler;
    }
}
