package app.Kap13;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class SinglethreadedServer {

    private final int port;

    public static void main(String[] args) throws IOException {
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
        new SinglethreadedServer(port).erwarteVerbindung(port);
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

    public void erwarteVerbindung(Integer port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        try (Socket verbindung = server.accept()) {
            verarbeiteVerbindung(verbindung);
        }
    }

    private void verarbeiteVerbindung(Socket verbindung) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(verbindung.getOutputStream()));
        String antwort = "das ist ein Test";
        writer.write(antwort);
        writer.newLine();
        writer.flush();
    }
}
