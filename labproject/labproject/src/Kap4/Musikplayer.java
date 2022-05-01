package Kap4;

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

        Song meinSong1 = new Song("Testsong1", "Tester", 632);
        meinSong1.print();
        Song meinSong2 = new Song("Testsong2", 356);
        meinSong2.print();
        Song meinSong3 = new Song("Testsong3", "Tester", 3, 2, 32);
        meinSong3.print();
    }
}
