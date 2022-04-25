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

        Song meinSong = new Song();
        meinSong.setInterpret("Tester");
        meinSong.setTitel("Testsong");
        meinSong.setLaengeInSekunden(356);
        meinSong.print();
    }
}
