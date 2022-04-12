package de.kaiguenster.javaintro.musiksammlung;

import java.util.Collection;
import java.util.Iterator;

/**
 * Abstrakte Oberklasse für Collections vom Typ {@link Song}.
 * @author Kai Günster
 */
public abstract class SongCollection implements Iterable<Song>{
    /**
     * Datenfeld für Songs. Konkrete Collection-Implementierung wird in den 
     * Spezialisierungen festgelegt und beeinflusst das verhalten der 
     * SongCollections.
     */
    protected final Collection<Song> songs;

    /**
     * Konstruktur, dem die konkret verwendete Collection übergeben wird
     * @param songs 
     */
    protected SongCollection(Collection<Song> songs) {
        this.songs = songs;
    }

    /**
     * Füge einen Song hintu
     * @param s - den Song
     * @return true wenn der Song hinzugefügt wurde, sonst false. 
     */
    public boolean addSong(Song s){
        return songs.add(s);
    }
    
    /**
     * Entfernt einen Song aus der Collection.
     * @param s - den zu entfernenden Song
     * @return true, wenn ein Song entfernt wurde, sonst false.
     */
    public boolean removeSong(Song s){
        return songs.remove(s);
    }
    
    /**
     * @return die Größe der Collection
     */
    public int size(){
        return songs.size();
    }
    
    @Override
    public Iterator<Song> iterator() {
        return songs.iterator();
    }
}
