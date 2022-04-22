package Kap4;

import java.util.Random;

public class forSchlaufen {
    public static void wuerfelSechs() {
        for (Random wuerfel = new Random(); wuerfel.nextInt(6) + 1 != 6;) {
            System.out.println(".. ich muss nochmal würfeln!");
        }
        System.out.println("jezt habe ich eine 6 gewürfelt!");
    }

    public static void verdoppleAlle(int[] zahlen) {
        for (int i = 0; i < zahlen.length; i++) {
            System.out.println(zahlen[i] *= 2);
        }
    }

    public static void main(String[] args) {
        int[] zahlen = new int[] { 99, 22, 43, 14, 35 };

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "* 7 = " + (i * 7));
        }
        verdoppleAlle(zahlen);
        wuerfelSechs();
    }

}
