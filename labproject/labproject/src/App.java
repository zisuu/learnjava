import java.io.*;

/**
 * Programm zur Empfehlung von Filmtiteln.
 * 
 * @author Dave
 * @version 1.0
 */
public class App {
    
    static String[] filmTitel = new String[] { "FilmA", "FilmB", "FilmC", "FilmD", "FilmE", "FilmF", "FilmG", "FilmH", "FilmI", "FilmNemesis" };

    public static void getMovies() {

        System.out.println("Geben Sie FilmNr eines Filmes aus der Liste ein, um zu erfahren, ob es sicht lohnt den Film zu schauen, oder nicht: ");
        for (int i = 0; i < filmTitel.length; i++) {
            System.out.println("FilmNr: "+ (i+1) + ", FilmTitel: " + filmTitel[i]);
        }
    }

    public static String getAdvice(String eingabe) {
        String advice = null;
        int filmNr = Integer.parseInt(eingabe);


    // Wenn filmNr durch zwei Teilbar ist, dann ist es eine Gerade numer - sonst ist es eine ungerade Nummer
    // empfegel alle Filme mit geraden Nummern zu schauen, mit ausnahme von filmNr 10, der sollte man nicht schauen
        if (filmNr % 2 == 0 && filmNr != 10) {

            advice = "schauen";
            System.out.println(advice);
            
        }else {
            advice = "nicht schauen";
            System.out.println(advice);
        }

        return advice;
    }

    public static void main(String[] args) throws IOException {
        getMovies();
        System.out.println("Eingabe FilmNr: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String eingabe = reader.readLine();
        getAdvice(eingabe);
    }
}

// Film 1: "Titel A" - nicht schauen
// Film 2: "Titel B" - schauen
// Film 3: "Titel C" - nicht schauen
// Film 4: "Titel D" - schauen
// Film 5: "Titel E" - nicht schauen
// Film 6: "Titel F" - schauen
// Film 7: "Titel G" - nicht schauen
// Film 8: "Titel H" - schauen
// Film 9: "Titel I" - nicht schauen
// Film 10: "Titel Nemesis" - nicht schauen