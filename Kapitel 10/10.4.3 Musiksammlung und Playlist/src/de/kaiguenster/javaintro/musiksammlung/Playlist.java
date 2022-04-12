package de.kaiguenster.javaintro.musiksammlung;

import java.util.ArrayList;

/**
 * Spezielle Implementierung von {@link SongCollection}, die mehrfache Vorkommen 
 * desselben Songs erlaubt.
 * @author Kai Günster
 */
public class Playlist extends SongCollection{

    public Playlist() {
        //Durch die Liste als zu Grunde liegende Collections sind mehrfache Vorkommen möglich.
        super(new ArrayList<>());
    }
    
}
