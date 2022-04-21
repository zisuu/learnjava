package Kap4;

import java.util.Random;
import java.io.*;


public class zahlraten {
    public static void main(String[] args) throws IOException {
        Random wuerfel = new Random();
        Integer zufallsZahl = wuerfel.nextInt(100)+1;

        System.out.println("## Ich habe mir eine Zahl zwischen 0 und 100 ausgedacht. Kannst du sie erraten? ##");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer rateZahl = Integer.parseInt(reader.readLine());

        while (zufallsZahl != rateZahl) {
            if (zufallsZahl < rateZahl) {
                System.out.println("Falsch, meine Zahl ist kleiner!");
            } else
                System.out.println("Falsch, meine Zahl ist grösser!");
            System.out.println("Versuche es nochmals: ");
            rateZahl = Integer.parseInt(reader.readLine());
        }

        System.out.println("TARATATATAAAA - RICHTIG. Meine Zahl ist: " + zufallsZahl);
    }

}
