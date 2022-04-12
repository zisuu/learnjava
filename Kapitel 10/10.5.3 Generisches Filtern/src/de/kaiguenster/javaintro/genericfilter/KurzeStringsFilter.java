package de.kaiguenster.javaintro.genericfilter;

/**
 * Filter-Implementierung, die Strings mit weniger als 10 Zeichen erkennt.
 * @author Kai Günster
 */
public class KurzeStringsFilter implements Filter<String>{

    public boolean filter(String element) {
        return element.length() < 10;
    }
    
}
