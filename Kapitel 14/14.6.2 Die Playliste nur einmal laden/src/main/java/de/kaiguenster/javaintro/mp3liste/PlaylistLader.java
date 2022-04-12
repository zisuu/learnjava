package de.kaiguenster.javaintro.mp3liste;

import de.kaiguenster.javaintro.playlist.Playlist;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PlaylistLader implements ServletContextListener{

    public static final String PLAYLIST = "playlist";
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
            File listfile = new File(sce.getServletContext().getInitParameter("playlist_location"));
            Playlist playlist = null;
            if (listfile.exists() && listfile.canRead()) {
                try {
                    playlist = Playlist.lese(listfile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (playlist == null) playlist = new Playlist();
            sce.getServletContext().setAttribute(PLAYLIST, playlist);
        
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
