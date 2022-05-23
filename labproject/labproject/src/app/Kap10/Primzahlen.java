package app.Kap10;

/**
 * Dabei schreiben Sie zunächst alle Zahlen auf, die kleiner als die Grenze
 * sind. Dann gehen Sie diese
 * Liste durch, angefangen bei der 2, der per Definition kleinsten Primzahl. Für
 * jede Zahl, die Sie
 * bearbeiten, streichen Sie alle Vielfachen dieser Zahl aus. Bei der 2
 * streichen Sie also 4, 6, 8,
 * 10 … Ist eine Zahl bereits ausgestrichen, müssen Sie sie nicht weiter
 * beachten, denn dann sind alle
 * ihre Vielfachen ebenfalls gestrichen. Haben Sie alle Zahlen bearbeitet, dann
 * sind die übrigen, nicht
 * ausgestrichenen Zahlen Primzahlen, denn sie waren durch keine andere Zahl
 * teilbar.
 * 
 * -> Implementieren Sie das Sieb des Eratosthenes in Java auf Basis von Arrays.
 * OK: soll die Obergrenze als Parameter erhalten
 * -> soll ein int[] zurückgeben, das alle Primzahlen enthält, die kleiner oder
 * gleich dieser Grenze sind.
 * OK: Die Obergrenze soll dabei maximal 100.000 betragen.
 */
public class Primzahlen {

    public static int[] calcPrim(int zahlGrenze) {
        if (zahlGrenze < 0 || zahlGrenze > 100000) {
            throw new IllegalArgumentException("Grenze darf nur zwischen 0 und 100000 sein!");
        }
        /*
         * In einem boolean[] wird festgehalten, welche Zahlen teilbar sind.
         * Dies ist einfacher, als festzuhalten, welche Zahlen prim sind, da
         * boolean-Werte per Default false sind.
         */
        boolean[] teilbar = new boolean[zahlGrenze + 1];
        int gefunden = 0;
        for (int i = 2; i < teilbar.length; i++) {
            if (!teilbar[i]) {
                /*
                 * Wenn i nicht teilbar ist, ist es prim. In dem Fall werden alle
                 * Vielfachen von i als teilbar markiert.
                 */
                gefunden++;
                for (int j = 2 * i; j < teilbar.length; j += i) {
                    teilbar[j] = true;
                }
            }
        }
        // Nun ist bekannt, wie viele Primzahlen es gibt
        int[] ergebnis = new int[gefunden];
        int ergebnisIndex = 0;
        // alle nicht teilbaren Zahlen werden in das Ergebnis-Array eingetragen
        for (int i = 2; i < teilbar.length; i++) {
            if (!teilbar[i]) {
                ergebnis[ergebnisIndex++] = i;
            }
        }
        return ergebnis;
    }

}
