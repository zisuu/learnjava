package de.kaiguenster.javaintro.multithreadedserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server für die Klasse {@link de.kaiguenster.javaintro.client.Client}, der
 * alle Verbindungen in eigenen Threads bearbeitet
 *
 * @author Kai Günster
 */
public class MultithreadedServer {

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
        new MultithreadedServer(port).erwarteVerbindung();
    }

    private static void endeMitFehler(String nachricht) {
        System.out.println(nachricht);
        System.exit(1);
    }

    /**
     * Erzeuge einen Server
     * @param port Listen-Port
     */    
    private MultithreadedServer(int port) {
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
            final Socket sock = server.accept();
            //Wird eine Verbidnung angenommen, dann bearbeite sie in einem neuen Thread
            new Thread(new AntwortProzess(sock)).start();
        }
    }

    /**
     * Runnable, um eingehende Verbindungen zu bearbeiten
     */
    private static class AntwortProzess implements Runnable {

        private final Socket socket;

        public AntwortProzess(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            //Diese Methode wird vom Thread gerufen, wenn er startet.
            try (Socket socket = this.socket) {
                /*
                Warte zunächst 2 Sekunden. Diese Wartezeit ist nun im eigenen 
                Thread und verhindert nicht, dass weitere Verbindungen angenommen 
                werden.
                */
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                }
                //Schreibe eine Zeile Text an den Client zurück.
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                out.write("Verbindung angenommen\n");
                out.flush();
            } catch (IOException ex) {
            }
        }
    }
}
