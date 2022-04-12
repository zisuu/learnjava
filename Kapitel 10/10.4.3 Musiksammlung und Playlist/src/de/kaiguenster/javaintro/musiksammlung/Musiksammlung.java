package de.kaiguenster.javaintro.musiksammlung;

import java.util.HashSet;

/**
 * Spezielle Implementierung von {@link SongCollection}, die die Eindeutigkeit 
 * enthaltener Songs sicherstellt.
 * @author Kai Günster
 */
public class Musiksammlung extends SongCollection{

    public Musiksammlung() {
        //Grundlegende Collection ist ein Set, so sind Mehrfachvorkommen nicht möglich.
        super(new HashSet<>());
    }
    
}
