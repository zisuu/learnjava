package Kap4;

import java.io.*;

public class kgv {
    public static void main(String[] args) throws IOException {
        System.out.println("## kgv rechner ##");
        System.out.println("Bitte geben Sie die erste Zahl an: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer zahl1 = Integer.parseInt(reader.readLine());
        System.out.println("Bitte geben Sie die zweite Zahl an: ");
        Integer zahl2 = Integer.parseInt(reader.readLine());
        System.out.println(kgv(zahl1, zahl2));
    }

    private static int kgv(int zahl1, int zahl2) {
        if (zahl1 <= 0 || zahl2 <= 0)
            throw new IllegalArgumentException("Beide Zahlen müssen >0 sein.");
        int hoch = 1;
        int kandidatKleiner = zahl1 < zahl2 ? zahl1 : zahl2;
        while (Math.pow(zahl1,hoch) || zahl2 % kandidatKleiner != 0) {
            hoch++;
        }
        return kandidat;
    }
}
