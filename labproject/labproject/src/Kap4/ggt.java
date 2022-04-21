package Kap4;

public class ggt {
    public static void main(String[] args) {
        System.out.println(ggt(5, 50));
    }

    private static int ggt(int zahl1, int zahl2) {
        if (zahl1 <= 0 || zahl2 <= 0) 
         throw new IllegalArgumentException("Beide Zahlen müssen >0 sein.");
        int kandidat = zahl1 < zahl2 ? zahl1 : zahl2;
        while(zahl1 % kandidat != 0 || zahl2 % kandidat != 0){
            kandidat--;
        }
        return kandidat;
    }
}
