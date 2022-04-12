package de.kaiguenster.javaintro.mp3liste;

import de.kaiguenster.javaintro.playlist.Playlist;
import de.kaiguenster.javaintro.playlist.Song;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PlayServlet", urlPatterns = {"/play/*"})
public class PlayServlet extends MusikServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        Aus Sicherheitsgründen kann kein Pfad als Parameter übergeben werden, 
        sondern nur der Index in der Playlist. Deshalb muss die Playlist hier 
        wieder geladen werden, um den richtigen Song zu finden. Würden Pfade als 
        Parameter erwartet, wäre es möglich, beliebige Dateien vom Server zu lesen, 
        ein großes Sicherheitsproblem.
        */
        //Den Index aus dem URL-Pfad lesen: /play/7 liefert so den Index 7        

        int index = Integer.parseInt(req.getPathInfo().substring(1));
        //Die Playlist aus dem Application Context holen
        Playlist playlist = (Playlist) getServletContext().getAttribute(PlaylistLader.PLAYLIST);
        final Song song = playlist.getSongs().get(index);
        File musikdatei = new File(song.getPfad());
        if (!musikdatei.exists() || !musikdatei.canRead()){
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Kann Musikdatei nicht lesen.");
        }
        //Den Abspiel-Zähler des Songs hochsetzen
        zaehleSong(song, req);
        //Die Antwort hat das MP3-Format
        resp.setContentType("audio/mp3");
        //Die Musikdatei in Blöcken von 1024 Byte lesen und an den Browser senden.
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(musikdatei))){
            byte[] buffer = new byte[1024];
            int read = 0;
            while ((read = in.read(buffer)) >= 0){
                resp.getOutputStream().write(buffer, 0, read);
            }
        }
    }
    
    /**
     * Zählt den übergebenen Song als einmal abgespielt
     * @param s der abgespielte Song
     * @param req der Request
     */
    protected void zaehleSong(Song s, HttpServletRequest req){
        Map<Song, Integer> zaehler = getZaehlerMap(req);
        zaehler.put(s, zaehler.getOrDefault(s, 0) + 1);
    }
    
}
