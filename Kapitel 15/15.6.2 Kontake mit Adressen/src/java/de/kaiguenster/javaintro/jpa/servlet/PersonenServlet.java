package de.kaiguenster.javaintro.jpa.servlet;

import de.kaiguenster.javaintro.jpa.persistence.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet für die Personenliste. Lädt Personen aus der Datenbank und zeigt sie
 * auf einer JSP an
 * @author Kai Günster
 */
@WebServlet(name = "PersonenServlet", urlPatterns = {"/personen"})
public class PersonenServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Den EntityManager erzeugen
        EntityManager manager = createEntityManager();
        TypedQuery<Person> q;
        final String queryString = request.getParameter("query");
        final String ort = request.getParameter("ort");
        //Falls ein Suchbegriff als URL-Parameter übergeben wurde...
        if (queryString != null){
            //... wird die benannte Query für die Suche nach Namensteil verwendet...
            q = manager.createNamedQuery(Person.QUERY_NAMENSTEIL, Person.class);
            //... und der Parameter um % für die LIKE-Suche erweitert...
            q.setParameter("name", "%" + queryString.toLowerCase() + "%");
        } else if (ort != null){
            /*
            ...wurde ansonsten ein Ort übergeben, so werden Personen nach ihrem 
            Wohnort gesucht. Wurden beide Parameter übergeben, wird der Ort 
            ignoriert.
            */
            q = manager.createNamedQuery(Person.QUERY_WOHNORT, Person.class);
            q.setParameter("ort", "%" + ort.toLowerCase() + "%");
        } else {
            //Fehlen beide Parameter, werden alle Personen geladen
            q = manager.createQuery("SELECT p FROM Person p", Person.class);
        }
        //Mit der oben gebauten Query werden nun Personen geladen
        List<Person> personen = q.getResultList();
        //Die Personen werden im Request abgelegt
        request.setAttribute("personen", personen);
        //Die Anzeige übernimmt eine JSP
        getServletContext().getRequestDispatcher("/WEB-INF/personen.jsp").forward(request, response);
    }

    private EntityManager createEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute(JPAListener.KEY);
        EntityManager manager = emf.createEntityManager();
        return manager;
    }
}
