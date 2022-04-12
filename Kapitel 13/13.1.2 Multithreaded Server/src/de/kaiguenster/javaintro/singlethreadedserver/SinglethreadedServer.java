package de.kaiguenster.javaintro.singlethreadedserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server für die Klasse {@link de.kaiguenster.javaintro.client.Client}, der
 * alle Verbindungen in nur einem Thread bearbeitet
 *
 * @author Kai Günster
 */
public class SinglethreadedServer {

    private final int port;

    public static void main(String[] args) throws IOException {
        //Aufrufparameter prüfen
        if (args.length != 1) {
            endeMitFehler("Aufruf: java de.kaiguenster.javaintro.singlethreadedserver.SinglethreadedServer <Port>");
        }
        if (!args[0].matches("\\d+")) {
            endeMitFehler(args[1] + " ist kein gültiger Port.");
        }
        int port = Integer.parseInt(args[0]);
        if (port <= 1024) {
            endeMitFehler("Ports unter 1024 sind reserviert");
        }
        if (port > 65535) {
            endeMitFehler("Der höchte Port ist 65535");
        }
        //Server-Objekt erzeugen und auf Verbindungen warten
        new SinglethreadedServer(port).erwarteVerbindung();
    }

    private static void endeMitFehler(String nachricht) {
        System.out.println(nachricht);
        System.exit(1);
    }

    /**
     * Erzeuge einen Server
     * @param port Listen-Port
     */
    private SinglethreadedServer(int port) {
        this.port = port;
    }

    /**
     * Warte auf Verbindung und verarbeite sie.
     * @throws IOException 
     */
    private void erwarteVerbindung() throws IOException {
        ServerSocket server = new ServerSocket(port);
        //Diese Schleife läuft, bis das Programm von außen gestoppt wird (z.B. STRG+C)
        while (true) {
            //Warte auf Verbindungen
            try (Socket sock = server.accept()) {
                //Wenn eine Verbindung ankommt, dann warte 2 Sekunen
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                }
                //Schreibe eine Zeile Text an den Client zurück.
                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(sock.getOutputStream()));
                out.write("Verbindung angenommen\n");
                out.flush();
            }
        }
    }
}
