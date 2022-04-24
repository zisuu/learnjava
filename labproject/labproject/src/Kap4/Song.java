package Kap4;

// Schreiben Sie nun Ihre erste Methode. Beginnen Sie mit der Klasse Song, wie abgedruckt, mit zwei String-Feldern 
// interpret und titel und einem int-Feld laengeInSekunden. Fügen Sie eine Methode drucke hinzu, die die Daten des 
// Songs auf die Kommandozeile ausgibt. Schreiben Sie dann eine Klasse Musicplayer, die ein Song-Objekt erzeugt, 
// seine Felder mit Werten befüllt und es schließlich mit Hilfe Ihrer Methode ausgibt. Die Lösung zu dieser Übung 
// finden Sie im Anhang.

 /**
 * Klasse Song, mit zwei String-Feldern interpret und titel und einem int-Feld laengeInSekunden.
 * @author zisuu
 * @version 1.0
 */
public class Song {

    public String interpret;
    public String titel;
    public Integer laengeInSekunden;

     /**
     * Methode die die Daten des Songs auf die Kommandozeile ausgibt
     */
    public void print() {
        System.out.println( "Interpret: " + this.interpret + ", Titel: " + this.titel + ", laengeInSekunden: " + this.laengeInSekunden);
    }
}
