package app.Kap10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Schreiben Sie im Musicplayer eine Klasse Lieblingslieder, die für jeden
 * Benutzer,
 * identifiziert durch einen Benutzernamen, eine Liste seiner Lieblingslieder
 * verwaltet.
 * Es soll einem Benutzer möglich sein, der Liste ein Lied hinzuzufügen, sich
 * alle für ihn
 * gespeicherten Lieder zurückgeben zu lassen und die Liste komplett zu
 * entfernen.
 */
public class Lieblingslieder {

    private Map<String, List<Song>> daten = new HashMap<>();

    // public static void main(String[] args) {
    // Lieblingslieder mylist = new Lieblingslieder();
    // mylist.fuegeLiedHinzu("Hans", "Hanssong");
    // }

    /**
     * FÜge für einen Benutzer ein Lieblingslied hinzu.
     * 
     * @param benutzer der Benutzer
     * @param song     sein neues Lieblingslied
     */
    public void fuegeHinzu(String benutzer, Song song) {
        // findeListeFürBenutzer stellt sicher, dass kein null zurückkommt.
        findeListeFuerBenutzer(benutzer).add(song);
    }

    public void fuegeLiedHinzu(String name, List<Song> songs){

        //Der Booklist zwei Books hinzufügen
        booklist.add(new Book(…));
        booklist.add(new Book(…));
        //Das zweite Buch durch ein anderes ersetzen
        booklist.set(1, new Book(…));
        //Alle Buecher anzeigen
        for (Book book : booklist){
            System.out.println(book.getTitel());
        }

        daten.put(name, songs.add(e));
    }

    public Song findeLieblingslieder(String name) {
        return daten.get(name);
    }

    public void schreibeLieblingslieder() {

        for (Map.Entry<String, List<Song>> entry : daten.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
