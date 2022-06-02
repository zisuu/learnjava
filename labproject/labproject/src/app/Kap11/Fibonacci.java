package app.Kap11;

import java.math.BigInteger;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;

/**
 * Erzeugen Sie einen endlosen Stream der Fibonacci-Zahlen. Die Fibonaci-Zahlen
 * sind die Elemente einer
 * Zahlenfolge, in der jedes Element die Summe aus den beiden vorhergehenden
 * Elementen ist. Die beiden
 * ersten Elemente sind per Definition 1. Die ersten zehn Fibonacci-Zahlen
 * lauten also:
 * 1
 * 1
 * 2 = 1 + 1
 * 3 = 2 + 1
 * 5 = 3 + 2
 * 8 = 5 + 3
 * 13 = 8 + 5
 * 21 = 13 + 8
 * 34 = 21 + 13
 * 55 = 34 + 21
 * Geben Sie die ersten 1.000 aus.
 * 
 * Sie dürfen dazu auf eine traditionelle anonyme Klasse zurückgreifen, denn mit
 * Lambda-Ausdrücken lässt
 * sich dieses Problem nicht so einfach lösen. Überlegen Sie als Zusatzaufgabe,
 * was das Problem mit
 * Lambda-Ausdrücken bei dieser Aufgabe ist.
 */
public class Fibonacci {
    public static void main(String[] args) {
        fibonacciOhneLambda();
        fibonacciAnonym();
        fibonacciMitLambda();
    }

    /**
     * erzeuge die Fibonacci Zahlen ohne Lambda
     */
    private static void fibonacciOhneLambda() {
        // erzeuge BigInt x mit Wert 1
        BigInteger x = BigInteger.ONE;
        // erzeuge BigInt y mit Wert 1
        BigInteger y = BigInteger.ONE;

        // starte bei 0 und wiederhole 1000 mal
        for (int i = 0; i < 1000; i++) {
            // gebe bei der ersten Iteration die BigInteger werte aus
            if (i == 0) {
                System.out.println(x);
                System.out.println(y);
            }
            // summiere x und y als z
            BigInteger z = x.add(y);
            // gebe diese Inhalte aus
            System.out.println(z + " = " + x + " + " + y);
            // wert x erhält wert von y
            y = x;
            // wert z erhät wert von x
            x = z;
        }
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
    private static void fibonacciMitLambda() {
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
