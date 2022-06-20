package app.Kap13;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;

/**
 * Schreiben Sie eine Klasse, die mittels java.util.Random in mehreren Threads Zufallszahlen erzeugt.
 * Ein Random-Objekt ist threadsicher, Sie können also einen Zufallsgenerator in allen Threads teilen.
 * Sie übergeben Ihrem Objekt den Höchstwert für die Zufallszahlen, die Anzahl der Threads, die Zahlen
 * erzeugen sollen, und die Anzahl insgesamt zu erzeugender Zahlen.
 * 
 * Über die erzeugten Werte sollen an einer zentralen Stelle, also nicht innerhalb des Threads, folgende
 *  Daten gesammelt werden: Anzahl der Versuche und Summe der Ergebnisse, um den Durchschnitt zu berechnen,
 *  und für jeden möglichen Wert, wie oft er vorkam, um die Verteilung der Werte zu ermitteln.
 * 
 * Ein weiterer Thread soll alle 5 Sekunden den Durchschnitt der bis dahin gefundenen Werte ermitteln. 
 * Achten Sie darauf, dass Sie den Durchschnitt immer aus einem konsistenten Zustand heraus berechnen.
 */
public class Zufallsverteilung {

    private int zaehler;
    private long summe;
    private int[] einzelwerte;

    private final IntSupplier zufallszahlen;
    //versuche ist ein AtomicInteger, so dass mehrere Threads gleichzeitig abwärts zählen können
    private final AtomicInteger versuche;
    private final int threads;


    public static void main(String[] args) {
        //Teste für Zufallszahlen von 0 - 19 in 8 Threads mit insgesamt 1.000.000.000 Versuchen
        new Zufallsverteilung(20, 8, 1000000000).teste();
    }

    /**
     * Erzeuge ein Objekt zum Zufallstest
     *
     * @param hoechstwert der Höchstwert des Würfels
     * @param threads
     * @param versuche
     */
    public Zufallsverteilung(int hoechstwert, int threads, int versuche) {
        //Das Random-Objekt wird in einem IntSupplier verpackt. 
        Random rnd = new Random();
        this.zufallszahlen = () -> rnd.nextInt(hoechstwert);
        this.versuche = new AtomicInteger(versuche);
        this.threads = threads;
        einzelwerte = new int[hoechstwert];
    }

    /**
     * Starte den Test der Zufallsverteilung
     */
    public void teste() {
        //Als erstes wird der Monitorthread gestartet. Er soll alle 5 Sekunden den Durchschnitt bisher ausgeben
        starteMonitorThread();
        //Dann starten die Würfel-Threads
        Thread[] alleThreads = starteThreads();
        //Es wird gewartet, bis alle Threads ausgewürfelt haben.
        warteAufAlleThreads(alleThreads);
        //Dann wird das finale Ergebnis ausgegeben.
        druckeErgebnis();
    }


    /**
     * Startet die benötigte Anzahl Würfel-Threads
     *
     * @return ein Array von gestartetetn Würfel-Threads
     */
    private Thread[] starteThreads() {
        Thread[] alleThreads = new Thread[threads];
        for (int i = 0; i < threads; i++) {
            //Erzeuge einen Würfel-Thread und starte ihn
            alleThreads[i] = new Thread(new Wuerfel());
            alleThreads[i].start();
        }
        return alleThreads;
    }

    /**
     * Warte, bis alle übergebenen Threads terminiert sind.
     *
     * @param alleThreads
     */
    private void warteAufAlleThreads(Thread[] alleThreads) {
        for (Thread t : alleThreads) {
            /*
             Solange t noch lebt, warte, bis t endet. Die Schleife ist nötig, weil
             das Warten auch mit einer InterruptedException unterbrochen werden könnte
             */
            while (t.isAlive()) {
                try {
                    t.join();
                } catch (InterruptedException ex) {
                    //tue hier nichts, aber die Schleife wird einen weiteren Durchlauf machen
                }
            }
        }
    }

    /**
     * Druckt den Durchschnitt bisher gewürfelter Zahlen
     */
    private void druckeErgebnis() {
        for (int i = 0; i < einzelwerte.length; i++) {
            System.out.println(i + ": " + einzelwerte[i]);
        }
        System.out.println("Durchschnitt: " + ((double) summe / zaehler));
    }

    private void starteMonitorThread() {
        //Erzeuge einen Thread als Monitor
        Thread t = new Thread(() -> {
            //Dieser Thread läuft endlos
            while (true) {
                //Er wartet 5 Sekunden
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    //absichtlich leer
                }
                //Dann synchronisiert er auf this, um das Lock mit der synchronized-Methode zahl zu teilen
                synchronized (this) {
                    //und gibt den Durchschnitt aus.
                    System.out.println("Durchschnitt nach " + zaehler + ": " + ((double) summe / zaehler));
                }
            }
        });
        //Dieser Thread ist ein Daemon, obwohl er endlos läuft verhindert er nicht, dass die JVM beendet wird. 
        t.setDaemon(true);
        t.start();
    }

    /**
     * Nimm eine Zahl von einem der Würfel-Threads entgegen. Synchronisation
     * sorgt dafür, dass gesammelte Daten zu jeder Zeit konsistent sind.
     *
     * @param zahl die gewürfelte Zahl
     */
    private synchronized void zahl(int zahl) {
        zaehler++;
        summe += zahl;
        einzelwerte[zahl]++;
    }

    /**
     * Das Runnable für die Würfel-Threads.
     */
    private final class Wuerfel implements Runnable {

        @Override
        public void run() {
            //Solange noch Versuche zu Würfeln sind
            while (versuche.decrementAndGet() > 0) {
                /*
                 Würfle und gib das Ergebnis an die synchronisierte Methode zahl.
                 Das Würfeln selbst ist nicht synchronisiert, nur das Sammeln der Werte 
                 benötigt ein Lock.
                 */
                zahl(zufallszahlen.getAsInt());
            }

        }
    }

}