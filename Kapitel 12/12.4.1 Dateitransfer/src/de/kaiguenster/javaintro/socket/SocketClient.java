package de.kaiguenster.javaintro.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Programm, um eine Datei durch das Netzwerk zu einem {@link SocketServer} zu
 * übertragen.
 *
 * @author Kai Günster
 */
public class SocketClient {

    /**
     * Encoding für den Dateinamen
     */
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    private final String hostname;
    private final int port;

    public static void main(String[] args) throws IOException {
        //Aurfurfparameter prüfen
        if (args.length != 3) {
            endeMitFehler("Aufruf: java de.kaiguenster.javaintro.socket.SocketClient <host> <port> <datei>");
        }
        String host = args[0];
        if (!args[1].matches("\\d+")) {
            endeMitFehler(args[1] + " ist kein gültiger Port.");
        }
        int port = Integer.parseInt(args[1]);
        if (port <= 1024) {
            endeMitFehler("Ports unter 1024 sind reserviert");
        }
        if (port > 65535) {
            endeMitFehler("Der höchte Port ist 65535");
        }
        File datei = new File(args[2]);
        if (!datei.exists() || !datei.isFile() || !datei.canRead()) {
            endeMitFehler(args[2] + " ist keine lesbare Datei");
        }
        //Neues SocketClient-Objekt erzeugen und die Datei übertragen
        new SocketClient(host, port).sendeDatei(datei);
    }

    private static void endeMitFehler(String nachricht) {
        System.out.println(nachricht);
        System.exit(1);
    }

    /**
     * Erzeuge einen neuen SocketClient zur Übertragung an einen entfernten
     * Rechner
     *
     * @param hostname Name des entfernten Rechners
     * @param port Port für die Verbindung
     */
    public SocketClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    /**
     * Sende eine Datei an den entfernten Rechner
     *
     * @param datei zu übertragende Datei
     * @throws IOException
     */
    public void sendeDatei(File datei) throws IOException {
        //Öffne Verbindung zum entfernten Rechner
        try (Socket verbindung = new Socket(hostname, port)) {
            //Öffne einen OutputStream für die Verbindung
            BufferedOutputStream out = new BufferedOutputStream(verbindung.getOutputStream());
            //Sende den Dateinamen
            sendeDateinamen(out, datei);
            //Sende den Dateiinhalt
            sendeInhalt(out, datei);
        }
    }

    /**
     * Sende den Dateinamen. Namen Länger als 255 Zeichen werden abgeschnitten.
     *
     * @param out Übertagungsziel.
     * @param datei die Datei
     * @throws IOException
     */
    private void sendeDateinamen(BufferedOutputStream out, File datei) throws IOException {
        String name = datei.getName();
        //Schneide zu lange Namen ab
        if (name.length() > 255) {
            name = name.substring(0, 255);
        }
        //Sende den Namen im festgelegten Encoding
        out.write(name.getBytes(ISO_8859_1));
        //Sende ein 0-byte. Der Server erkennt daran das Ende des Dateinamens
        out.write(0);
    }

    /**
     * Sende den Dateiinhalt.
     *
     * @param out Übertragungsziel
     * @param datei die Datei
     * @throws IOException
     */
    private void sendeInhalt(BufferedOutputStream out, File datei) throws IOException {
        //Öffne die Quelldatei
        try (InputStream in = new BufferedInputStream(new FileInputStream(datei))) {
            //Lies die Datei in Blöcken von 4 Kilobyte
            byte[] buffer = new byte[4096];
            int gelesen = 0;
            //Speichere, wie viele Byte in den Buffer gelesen wurden. Vor allem wichtig am Dateiende
            while ((gelesen = in.read(buffer)) != -1) {
                //Übertrage nur so viele Byte, wie auch gelesen wurden.
                out.write(buffer, 0, gelesen);
            }
        }
    }

}
