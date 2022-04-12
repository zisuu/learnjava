package de.kaiguenster.javaintro.jpa.servlet;

import de.kaiguenster.javaintro.jpa.persistence.Person;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet zur Anzeige und Bearbeitung einer einzelnen Person.
 *
 * @author Kai Günster
 */
@WebServlet(name = "PersonServlet", urlPatterns = {"/person"})
public class PersonServlet extends HttpServlet {

    /**
     * Als Antwort auf einen GET-Request werden die Daten einer Person
     * angezeigt. Die Person wird durch den URL-Parameter "id" identifiziert.
     * Ist keine ID angegeben wird ein leeres Formular angezeigt, um eine neue
     * Person anzulegen.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Person p = null;
        if (id != null) {
            EntityManager manager = createEntityManager();
            p = manager.find(Person.class, Long.parseLong(id));
        }
        request.setAttribute("person", p);
        getServletContext().getRequestDispatcher("/WEB-INF/person.jsp").forward(request, response);
    }

    /**
     * POST-Requests werden verwendet, um Objekte in die Datenbank zu speichern.
     * Die Felder für eine Person werden aus den URL-Parametern gelesen, daraus
     * ein Objekt erzeugt und dieses schließlich gespeichert.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager manager = createEntityManager();
        //Ein neues Person-Objekt erzeugen
        Person p = new Person();
        String id = request.getParameter("id");
        //Falls eine ID gesendet wurde, diese in das Objekt setzen
        if (id != null) {
            p.setId(Long.parseLong(id));
        }
        //Die weiteren Felder setzen
        p.setTitel(request.getParameter("titel"));
        p.setVorname(request.getParameter("vorname"));
        p.setNachname(request.getParameter("nachname"));
        try {
            //Eine JPA-Transaktion beginnen
            manager.getTransaction().begin();
            if (p.getId() == null){
                //Neue Objekte werden mit persist gespeichert
                manager.persist(p);
            } else {
                //Updates erfolgen mit merge
                manager.merge(p);
            }
            //Nach dem Schreiben die Transaktion commiten.
            manager.getTransaction().commit();
        } catch (Exception e) {
            //Im Fehlerfall ein Rollback ausführen: alle Änderungen dieser Transaktion werden zurückgenommen
            manager.getTransaction().rollback();
            request.setAttribute("error", e);
        }
        //Den Benutzer auf die Personenlsite weiterleiten.
        response.sendRedirect("personen");
    }

    private EntityManager createEntityManager() {
        EntityManagerFactory emf
                = (EntityManagerFactory) getServletContext().getAttribute(JPAListener.KEY);
        return emf.createEntityManager();
    }

}
