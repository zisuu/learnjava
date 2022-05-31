package app.Kap11;

import java.util.stream.IntStream;

/**
 * Gibt alle Vielfachen von 3 zwoschen 0 und 1000000 aus.
 */
public interface IntStreamTest {
    public static void main(String[] args) {
        IntStream.range(0, 1000000)
                .filter(i -> i % 3 == 0)
                .forEach(System.out::println);
    }
}
