package de.kaiguenster.javaintro.music;

/**
 * Auch wenn die Klasse Musicplayer heißt, handelt es sich doch nur um eine Testklasse
 * für Song.
 * @author Kai Günster
 */
public class Musicplayer {
    public static void main(String[] args){
        Song song = new Song();
        song.interpret = "if/else";
        song.titel = "Entscheid' dich...heut noch!";
        song.laengeInSekunden = 4347;
        song.drucke();
    }
}
