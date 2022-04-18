public class array {
    public void numbers(String name) {
        int[] zahlen = new int[] { 1, 2, 3, 4, 5 };
        int ersteZahl = zahlen[0]; // den ersten Wert des Arrays lesen
        zahlen[0] = 17; // den ersten Wert des Arrays schreiben
        int[] zahlen2 = new int[100];
        String[] namen = new String[512];
        double[] koordinaten = new double[]{1.5, 3.2, 1.0};
        System.out.println(zahlen.length + " Zahlen im Array");
        System.out.println("Erste Zahl:" + ersteZahl);
    }
}