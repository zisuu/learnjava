/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.kaiguenster.javaintro.music;

public class Musicplayer {
    public static void main(String[] args){
        Song song = new Song("Entscheid' dich!", "if/else", 136);
        Song song2 = new Song("White Noise", "static", 200);
        song.drucke();
        song2.drucke();
        System.out.println("Gesamtlänge: " + Song.getGesamtLaenge());
        song.setLaengeInSekunden(437);
        song2.setLaengeInSekunden(190);
        System.out.println("Gesamtlänge: " + Song.getGesamtLaenge());
    }
}
