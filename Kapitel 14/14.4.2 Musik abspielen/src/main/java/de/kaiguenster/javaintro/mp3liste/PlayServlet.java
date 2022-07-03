package de.kaiguenster.javaintro.mp3liste;

import de.kaiguenster.javaintro.playlist.Playlist;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet, um eine MP3-Datei zum Browser zu streamen. 
 * @author Kai Günster
 */
@WebServlet(name = "PlayServlet", urlPatterns = {"/play/*"})
public class PlayServlet extends HttpServlet {

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
        //Die Playlist-Datei lesen        
        File listfile = new File("/tmp/playlist.play");
        if (!listfile.exists() || !listfile.canRead()){
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Kann Playlist-Datei nicht lesen.");
            return;
        }
        Playlist playlist = Playlist.lese(listfile);
        //Die Musikdatei am übergebenen Index lesen
        File musikdatei = new File(playlist.getSongs().get(index).getPfad());
        if (!musikdatei.exists() || !musikdatei.canRead()){
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Kann Musikdatei nicht lesen.");
        }
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
}
