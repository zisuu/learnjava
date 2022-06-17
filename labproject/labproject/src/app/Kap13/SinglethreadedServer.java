package app.Kap13;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server für die Klasse {@link app.Kap13.Client}, der
 * alle Verbindungen in nur einem Thread bearbeitet
 *
 */
public class SinglethreadedServer {

    private final int port;

    public static void main(String[] args) throws IOException, InterruptedException {
        // Prüfe Aufrufparameter: Der Server soll mit einem Port und einem
        // Verzeichnis als Aufrufparameter gestartet werden.
        if (args.length != 1) {
            throwError("Bitte Server mit Port als Aufrufparameter starten!");
        }
        if (!args[0].matches("\\d+")) {
            throwError(args[0] + " ist kein gültiger Port!");
        }
        int port = Integer.parseInt(args[0]);
        if (port < 1024 || port > 65535) {
            throwError(port + " ist nicht im Range der dynamischen TCP Ports von 1024 bis 65535!");
        }
        // starte Server und warte bis Verbindung aufgebaut ist
        new SinglethreadedServer(port).erwarteVerbindung();
    }

    /**
     * Programm mit einer Fehlermeldung beenden
     * 
     * @param error - die Fehlermedlung
     */
    private static void throwError(String error) {
        // Fehlermeldung ausgeben
        System.out.println("Fehler: " + error);
        System.exit(1);
    }

    /**
     * Das SinglethreadedServer-Objekt Konstruktor
     * 
     * @param port
     */
    public SinglethreadedServer(int port) {
        this.port = port;
    }

    /**
     * Warte auf Verbindung und verarbeite sie
     * 
     * @param port
     * @throws IOException
     */
    public void erwarteVerbindung() throws IOException {
        ServerSocket server = new ServerSocket(port);
        // Schleife läuft bis sie unterbrochen wird CNTR+C
        while (true) {
            try (Socket verbindung = server.accept()) {
                // warte 2s nach Verbindungsannahme
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                }
                // Schreibe ein Text an den Client zurück
                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(verbindung.getOutputStream()));
                out.write("This is just a test!\n");
                out.flush();
            }
        }
    }
}
