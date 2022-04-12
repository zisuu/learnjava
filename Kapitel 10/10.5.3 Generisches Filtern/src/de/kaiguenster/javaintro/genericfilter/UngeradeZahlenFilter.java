package de.kaiguenster.javaintro.genericfilter;

/**
 * Filter-Implementierung, die ungerade Zahlen erkennt.
 * @author Kai Günster
 */
public class UngeradeZahlenFilter implements Filter<Integer>{
    @Override
    public boolean filter(Integer element) {
        return element % 2 != 0;
    }
}
