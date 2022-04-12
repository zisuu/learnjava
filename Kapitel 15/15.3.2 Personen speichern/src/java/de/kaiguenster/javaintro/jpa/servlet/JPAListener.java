package de.kaiguenster.javaintro.jpa.servlet;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class JPAListener implements ServletContextListener{
    
    private static final String PERSISTENCE_UNIT = "Adressbuch";
    public static final String KEY = "pu.adressbuch";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EntityManagerFactory factory = 
                Persistence.createEntityManagerFactory("Adressbuch");
        sce.getServletContext().setAttribute(KEY, factory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        EntityManagerFactory factory = 
                (EntityManagerFactory) sce.getServletContext().getAttribute(KEY);
        factory.close();
    }
    
}
