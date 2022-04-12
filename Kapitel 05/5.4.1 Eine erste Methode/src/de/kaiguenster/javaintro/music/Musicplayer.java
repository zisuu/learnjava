package de.kaiguenster.javaintro.music;

/**
 * Auch wenn die Klasse Musicplayer heißt, handelt es sich doch nur um eine Testklasse
 * für Song.
 * @author Kai Günster
 */
public class Musicplayer {
    public static void main(String[] args){
        //Es wird ein neuer Song erzeugt.
        Song song = new Song();
        //Seine Felder werden gesetzt.
        song.interpret = "if/else";
        song.titel = "Entscheid' dich!";
        song.laengeInSekunden = 247;
        //Der Song wird ausgegeben.
        song.drucke();
    }
}
