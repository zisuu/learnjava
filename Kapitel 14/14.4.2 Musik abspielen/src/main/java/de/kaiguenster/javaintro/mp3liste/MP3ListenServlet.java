package de.kaiguenster.javaintro.mp3liste;

import de.kaiguenster.javaintro.playlist.Playlist;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet, um den Inhalt einer Playlist auf einer Webseite auszugeben
 *
 * @author Kai Günster
 */
@WebServlet(name = "MP3Liste", urlPatterns = {"/"})
public class MP3ListenServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Die Playlist-Datei finden
        File listfile = new File("C:\\\\tmp\\\\playlist.play");
        //Falls die Datei nicht existiert eine Fehlermeldung senden.
        if (!listfile.exists() || !listfile.canRead()) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Kann Playlist-Datei nicht lesen.");
            return;
        }
        //Playlist lesen
        Playlist playlist = Playlist.lese(listfile);
        //Die Playlist als Request-Attribut ablegen, so dass die JSP darauf zugreifen kann
        request.setAttribute("playlist", playlist);
        //Zur Ausgabe an die JSP delegieren.
        getServletContext().getRequestDispatcher("/WEB-INF/liste.jsp").forward(request, response);
    }
}
