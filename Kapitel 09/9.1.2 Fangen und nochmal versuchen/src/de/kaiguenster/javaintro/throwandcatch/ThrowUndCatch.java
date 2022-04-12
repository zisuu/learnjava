package de.kaiguenster.javaintro.throwandcatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Dieses Programm liest eine Zahl voim Benutzer ein und halbiert sie. Wird keine
 * gültige Zahl eingegeben, wird die Abfrage wiederholt, bis eine Zahl gelesen
 * werden konnte.
 * @author Kai Günster
 */
public class ThrowUndCatch {

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer haelfte = null;
        //solange haelfte null ist: weiterversuchen
        while (haelfte == null){
            System.out.println("Bitte geben Sie eine gerade Zahl ein: ");
            //Code im try-Block wird versucht, aber Fehler werden behandelt
            try {
                /*
                Wird eine EException geworfen gibt halbiereZahl keinen Wert zurück.
                haelfte bleibt null, die Schleife läuft weiter.
                */
                haelfte = halbiereZahl(Integer.parseInt(in.readLine()));
            //Im catct-Block findet Fehlerbehandlung statt.
            } catch (IllegalArgumentException e){
                //Fehlerbehandlung: Ausgeben, was mit der Eingabe nicht stimmte.
                System.out.println(e.getMessage());
            }
        }
        //Endlich am Ende: Ergebnis ausgeben.
        System.out.println("Die Hälfte Ihrer Zahl ist " + haelfte);
    }

    private static int halbiereZahl(int zahl) {
        if (zahl % 2 != 0) 
            throw new IllegalArgumentException(zahl + " ist ungerade");
        else return zahl / 2;
    }
    
    protected void a() throws IOException{
        
    }
    
}

class Extend extends ThrowUndCatch{

    @Override
    protected void a() {
    }
    
}
