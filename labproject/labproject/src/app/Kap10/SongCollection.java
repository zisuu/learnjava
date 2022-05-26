package app.Kap10;

import java.util.Collection;
import java.util.Iterator;

/**
 * Abstrakte Oberklasse für Collections vom Typ {@link Song}.
 * @author zisuuu
 */
public abstract class SongCollection implements Iterable<Song>{
    /**
     * Datenfeld für Songs. Konkrete Collection-Implementierung wird in den 
     * Spezialisierungen festgelegt und beeinflusst das verhalten der 
     * SongCollections.
     */
    protected final Collection<Song> songs;

    /**
     * Konstruktor für Songs
     * @param songs
     */
    public SongCollection(Collection<Song> songs) {
        this.songs = songs;
    }

    /**
     *  Füge Song hinzu
     * @param song
     * @return true, wenn der Song hinzugefügt wurde, sonst false
     */
    public boolean addSong(Song song) {
        return songs.add(song);
    }

    /**
     * Entferne Song
     * @param song
     * @return true, wenn der Song entfernt wurde, ansonsten false
     */
    public boolean removeSong(Song song) {
        return songs.remove(song);
    }

    /**
     * gebe Collection grösse zurück
     * @return
     */
    public int size(){
        return songs.size();
    }

    @Override
    public Iterator<Song> iterator() {
        return songs.iterator();
    }
}
