package de.kaiguenster.javaintro.music;

/**
 * Auch wenn die Klasse Musicplayer heißt, handelt es sich doch nur um eine Testklasse
 * für Song.
 * @author Kai Günster
 */
public class Musicplayer {
    public static void main(String[] args){
        Song song = new Song();
        song.setInterpret("if/else");
        song.setTitel("Entscheid' dich!");
        song.setLaengeInSekunden(136);
        song.drucke();
    }
}
