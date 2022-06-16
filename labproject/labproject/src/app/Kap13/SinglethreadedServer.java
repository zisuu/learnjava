package app.Kap13;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
        while (true){
            // starte Server und warte bis Verbindung aufgebaut ist
            new SinglethreadedServer(port).erwarteVerbindung(port);
        }
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

    public void erwarteVerbindung(Integer port) throws IOException, InterruptedException {
            ServerSocket server = new ServerSocket(port);
            try (Socket verbindung = server.accept()) {
                Thread.sleep(2000); // set time delay to 2 seconds
                verarbeiteVerbindung(verbindung);
            }
            server.close();
    }

    private void verarbeiteVerbindung(Socket verbindung) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(verbindung.getOutputStream()));
        String antwort = "This is just a test!";
        writer.write(antwort);
        writer.newLine();
        writer.flush();
    }
}
