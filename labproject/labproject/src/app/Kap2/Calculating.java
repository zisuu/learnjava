package app.Kap2;
public class Calculating {
    public static void main(String[] args) {
        int zahl1 = Integer.parseInt(args[0]);
        int zahl2 = Integer.parseInt(args[1]);
        System.out.println("Summe: " + (zahl1 + zahl2));
        System.out.println("Differenz: " + (zahl1 - zahl2));
        System.out.println("Produkt: " + (zahl1 * zahl2));
        System.out.println("Quotient: " + (zahl1 / zahl2));
        System.out.println("Divisionsrest: " + (zahl1 % zahl2));
    }
}