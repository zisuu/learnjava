package de.kaiguenster.javaintro.mp3liste;

import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet, um den Inhalt einer Playlist auf einer Webseite auszugeben
 *
 * @author Kai Günster
 */
@WebServlet(name = "MP3Liste", urlPatterns = {"/"})
public class MP3ListenServlet extends MusikServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        An dieser Stelle wurde vorher die Playlist geladen. Das ist nicht mehr 
        nötig, da sie im Application Context bereits vorhanden ist. 
        */
        /*
        Aus der Zähler-Map (geerbt von MusikServlet) die Top Songs generieren:
        sortieren nach den am häufigsten abgespielten, auf 10 limitieren und eine
        Liste daraus erzeugen. (Es entsteht eine Liste von Map.Entry-Objekten).
        */
        request.setAttribute("topsongs", getZaehlerMap(request).entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .limit(10)
                .collect(Collectors.toList()));
        //Zur Ausgabe an die JSP delegieren.
        getServletContext().getRequestDispatcher("/WEB-INF/liste.jsp").forward(request, response);
    }
}
