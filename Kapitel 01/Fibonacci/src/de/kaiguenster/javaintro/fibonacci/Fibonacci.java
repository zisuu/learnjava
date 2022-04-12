package de.kaiguenster.javaintro.fibonacci;

/**
 * Java-Programm zur Berechnung von Fibonacci-Zahlen.
 * Auruf: java de.kaiguenster.javaintro.fibonacci.Fibonacci &lt;n&gt;. Dabei ist
 * n der Index der gesuchten Fibonacci-Zahl, <code>...Fibonacci 6</code> berechnet
 * die 6. Zahl der Folge: 5
 * @author Kai
 */
public class Fibonacci {

    public static int fibonacci(int n){
        if (n < 0) 
            throw new IllegalArgumentException("Fibonaccizahlen sind für negativen Index nicht definiert.");
        else if (n == 0) 
            return 0;
        else if (n == 1) 
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Aufruf: java de.kaiguenster.javaintro.fibonacci.Fibonacci <n>");
            System.exit(1);
        }
        int n = Integer.parseInt(args[0]);
        int result = fibonacci(n);
        System.out.println("Die " + n + ". Fibonacci-Zahl ist: " + result);
    }
}
