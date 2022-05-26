package app.Kap10;

import java.util.HashSet;


/**
 * 
 * Schreiben Sie zwei Klassen, Musiksammlung und Playlist.
 * Beide Klassen sollen Methoden anbieten, die Songs hinzufügen und Songs
 * entfernen, und sie sollen
 * mit einer for-each-Schleife iterierbar sein. Der Unterschied zwischen beiden
 * Klassen ist der, dass
 * Playlist denselben Song mehrmals enthalten kann, Musiksammlung aber nicht.
 * 
 * Versuchen Sie bei der Programmierung, doppelten Code zu vermeiden. Alles, was
 * beide Klassen gemeinsam
 * haben, sollten Sie auch nur einmal schreiben.
 * 
 */
public class Musiksammlung extends SongCollection{


    public Musiksammlung() {
        //verwende ein Set, so sind Mehrfachvorkommen nicht möglich.
        super(new HashSet<>());
    }

}
