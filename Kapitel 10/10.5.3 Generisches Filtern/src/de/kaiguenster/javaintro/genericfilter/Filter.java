package de.kaiguenster.javaintro.genericfilter;

import java.util.Collection;
import java.util.Iterator;

/**
 * Implementierungen dieses Interfaces können auf eine Collection angewendet werden, 
 * um alle Objekte aus dieser zu entfernen, die von der Filter-Methode erkannt werden.
 * @author Kai Günster
 * @param <T> - der Typ, auf den dieser Filter anwendbar ist.
 */
public interface Filter<T> {
    public boolean filter(T element);
    
    /**
     * Filter eine Liste mit einem Filter. Beide Parameter müssen identische Typen haben.
     * @param <U> der Typ von Liste und Filter
     * @param collection die zu filternde Liste
     * @param filter der anzuwendende Filter
     */
    public static <U> void wendeFilterAn(Collection<U> collection, Filter<U> filter){
        Iterator<U> it  = collection.iterator();
        //Iteriere über alle Elemente
        while (it.hasNext()){
            //Wenn der Filter ein Objekt erkennt, entferne es.
            if (filter.filter(it.next())) it.remove();
        }
    }
}
