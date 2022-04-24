package Kap4;

// Schreiben Sie nun Ihre erste Methode. Beginnen Sie mit der Klasse Song, wie abgedruckt, mit zwei String-Feldern 
// interpret und titel und einem int-Feld laengeInSekunden. Fügen Sie eine Methode drucke hinzu, die die Daten des 
// Songs auf die Kommandozeile ausgibt. Schreiben Sie dann eine Klasse Musicplayer, die ein Song-Objekt erzeugt, 
// seine Felder mit Werten befüllt und es schließlich mit Hilfe Ihrer Methode ausgibt. Die Lösung zu dieser Übung 
// finden Sie im Anhang.

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
        meinSong.laengeInSekunden = 30;
        meinSong.print();

    }    
}
