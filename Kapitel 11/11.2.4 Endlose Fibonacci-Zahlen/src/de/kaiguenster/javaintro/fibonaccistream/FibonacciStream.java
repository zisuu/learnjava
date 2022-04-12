package de.kaiguenster.javaintro.fibonaccistream;

import java.math.BigInteger;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Programm, dass auf zwei verschiedene Arten einen endlosen Stream von 
 * Fibonacci-Zahlen erzeugt.
 * @author Kai Günster
 */
public class FibonacciStream {

    public static void main(String[] args) {
        fibonacciAnonym();
        fibonacciLambda();
    }

    /**
     * Erzeugt den Fibonacci-Stream mit einer anonymen Klasse
     */
    private static void fibonacciAnonym() {
        //Erzeuge einen Stream durch eine anonyme Supplier-Implementierung
        Stream.generate(new Supplier(){
            //Die beiden vorherigen Zahlen
            BigInteger vor1 = BigInteger.ZERO, vor2 = BigInteger.ONE;
            @Override
            public Object get() {
                //Nächste Zahl = Summe der vorherigen Zahlen
                BigInteger zahl = vor1.add(vor2);
                //Neue vorherige Zahlen Speichern
                vor1 = vor2;
                vor2 = zahl;
                return zahl;
            }
        }).limit(1000).forEach(System.out::println);
    }

    /**
     * Erzeugt den Fibonacci-Stream durch Lambdas
     */
    private static void fibonacciLambda() {
        //Verwendet einen Lambda-Ausdruck und die Hilfsklasse Pair, um den Fibonacci-Stream zu erzeugen
        //Vom Zahlenpaar (0, 1) ausgehend ist das jeweils nächste Paar (zahl2, zahl1+zahl2)
        Stream.iterate(new Pair<BigInteger>(ZERO, ONE), 
                p -> new Pair<>(p.getSecond(), p.getFirst().add(p.getSecond())))
        //Für die Ausgabe, nimm die erste Zahl jedes Paars
        .map(Pair::getFirst)
        .limit(1000)
        .forEach(System.out::println);

    }
    
    
    private static class Pair<T>{
        private final T first, second;
        private Pair(T first, T second){
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }
        
        
    }
}
