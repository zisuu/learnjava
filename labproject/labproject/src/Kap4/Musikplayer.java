package Kap4;

 /**
 *  Klasse Musicplayer, die ein Song-Objekt erzeugt, 
 *  seine Felder mit Werten befüllt und es schliesslich mit Hilfe Ihrer Methode ausgibt.
 * @author zisuu
 * @version 1.0
 */
public class Musikplayer {
    public static void main(String[] args) {

        Song meinSong = new Song();
        meinSong.interpret = "Tester";
        meinSong.titel = "Testsong";
        meinSong.laengeInSekunden = 64;
        meinSong.print();

    }    
}
