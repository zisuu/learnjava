package Kap5;

/**
 * Klasse Musicplayer, die ein Song-Objekt erzeugt,
 * seine Felder mit Werten befüllt und es schliesslich mit Hilfe Ihrer Methode
 * ausgibt.
 * 
 * @author zisuu
 * @version 1.1
 */
public class Musikplayer {
    public static void main(String[] args) {

        Song meinSong1 = new Song("Testsong1", "Tester", 30);
        meinSong1.print();
        Song meinSong2 = new Song("Testsong2", 20);
        meinSong2.print();
        System.out.println("Gesamtlänge: " + Song.getGesamtLaenge());
        meinSong1.setLaengeInSekunden(20);
        meinSong2.setLaengeInSekunden(30);
        System.out.println("Gesamtlänge: " + Song.getGesamtLaenge());
    }
}
