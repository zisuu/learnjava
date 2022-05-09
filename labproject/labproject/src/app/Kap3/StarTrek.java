package app.Kap3;

import java.io.*;

/**
 * Programm zur Empfehlung von Filmtiteln.
 * 
 * @author Dave
 * @version 1.0
 */
public class StarTrek {

    static String[] filmTitel = new String[] { "The 300", "Horrible Bosses 2", "Detachement", "Intermission",
            "October Sky", "Moon", "Interstellar", "Shrek",
            "Crash", "Nemesis" };

    public static void getMovies() {

        System.out.println(
                "Geben Sie FilmNr eines Filmes aus der Liste ein, um zu erfahren, ob es sicht lohnt den Film zu schauen, oder nicht: ");
        for (int i = 0; i < filmTitel.length; i++) {
            System.out.println("FilmNr: " + (i + 1) + ", FilmTitel: " + filmTitel[i]);
        }
    }

    /**
     * Empfiehung alle Filme mit geraden Nummern zu schauen, mit ausnahme von filmNr
     * 10, der sollte man nicht schauen
     * Wenn filmNr durch zwei Teilbar ist, dann ist es eine Gerade numer - sonst ist
     * es eine ungerade Nummer
     * 
     * @param filmNr - die gewünschte FilmNr als <code>String</code>
     * @return der Ratschlag als <code>String</code>
     * @throws IllegalArgumentException wenn FilmNr nicht zwischen 1 und 10
     */
    public static String getAdvice(Integer filmNr) {
        String advice = null;

        if (filmNr >= 1 && filmNr <= 10) {

            if (filmNr % 2 == 0 && filmNr != 10) {

                advice = "schauen";
                System.out.println(advice);

            } else {
                advice = "nicht schauen";
                System.out.println(advice);
            }

            return advice;
        }
        fail("Es gibt nur FilmNr 1-10!");
        return "Error";
    }

    private static void fail(String message) {
        System.err.println(message);
        System.exit(1);
    }

    public static void main(String[] args) throws IOException {
        getMovies();
        System.out.println("Eingabe FilmNr: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int filmNr = Integer.parseInt(reader.readLine());
        getAdvice(filmNr);
    }
}
