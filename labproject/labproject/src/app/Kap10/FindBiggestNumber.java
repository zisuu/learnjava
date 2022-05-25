package app.Kap10;

public class FindBiggestNumber {

    public static void main(String[] args) {
        System.out.println(max(5, 10, 0));
    }

    public static int max(int... zahlen) {
        int ergebnis = Integer.MIN_VALUE;
        for (int zahl : zahlen) {
            if (zahl > ergebnis) {
                ergebnis = zahl;
            }
        }
        return ergebnis;
    }
}
