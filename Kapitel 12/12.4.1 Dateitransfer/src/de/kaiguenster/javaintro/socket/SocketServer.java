package de.kaiguenster.javaintro.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Programm, um Dateitransfer von einem {@link SocketClient} entgegegnzunehmen.
 * @author Kai Günster
 */
public class SocketServer {

    /**
     * Encoding für den Dateinamen
     */
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    private final int port;
    private final File verzeichnis;

    public static void main(String[] args) throws IOException {
        //Prüfe die Aufrufparameter
        if (args.length != 2) {
            endeMitFehler("Aufruf: java de.kaiguenster.javaintro.socket.SocketServer <Verzeichnis> <Port>");
        }
        File zielVerzeichnis = new File(args[0]);
        if (!zielVerzeichnis.exists() || !zielVerzeichnis.isDirectory() || !zielVerzeichnis.canWrite()) {
            endeMitFehler(args[0] + " ist kein schreibbares Verzeichnis");
        }
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
        //Erzeuge einen neuen SocketServer für diesen Port und Zielverzeichznis und warte auf Verbindung
        new SocketServer(port, zielVerzeichnis).erwarteVerbindung();
    }

    private static void endeMitFehler(String nachricht) {
        System.out.println(nachricht);
        System.exit(1);
    }

    /**
     * Erzeuge einen neuen SocketServer für diesen Port und Zielverzeichznis
     * @param port Listen-Port
     * @param verzeichnis Zielverzeichnis
     */
    public SocketServer(int port, File verzeichnis) {
        this.port = port;
        this.verzeichnis = verzeichnis;
    }

    /**
     * Warte auf Verbindung, schreibe Daten ins Dateisystem wenn eine Verbindung eingeht
     * @throws IOException 
     */
    public void erwarteVerbindung() throws IOException {
        ServerSocket server = new ServerSocket(port);
        //Warte auf eingehende Verbindung. accept blockiert, bis eine Verbindung kommt
        try (Socket verbindung = server.accept()) {
            //Erzeuge einen InputStream für die Verbindung
            BufferedInputStream in = new BufferedInputStream(verbindung.getInputStream());
            //Lies den Dateinamen
            String dateiname = liesNameAusStream(in);
            //Erzeuge die Zieldatei
            File datei = erzeugeSichereDatei(dateiname, verzeichnis);
            //Schreibe die empfangenen Daten in die Zieldatei
            schreibeDatei(datei, in);
        }
    }

    /**
     * Liest den Dateinamen aus dem Inputstream
     * @param in der InputStream
     * @return den Dateinamen
     * @throws IOException 
     */
    private String liesNameAusStream(BufferedInputStream in) throws IOException {
        byte[] buffer = new byte[255];
        int i;
        //Lies maximal 255 Byte aus dem Strom. Es wird Byte für Byte gelesen, um nicht versehentlich nach dem Ende des Namens weiterzulesen
        for (i = 0; i < 255; i++) {
            int gelesen = in.read();
            //-1 signalisiert einen Verbindungsabbruch
            if (gelesen == -1) {
                throw new IllegalStateException("Unerwartetes Ende des Datenstromns");
            }
            //ein 0-byte ist das mit dem Client vereinbarte Zeichen für das Ende des Dateinamens
            if (gelesen == 0) {
                break;
            }
            buffer[i] = (byte) gelesen;
        }
        //Erzeuge aus den empfangenen Byte einen String im vereinbarten Encoding
        return new String(buffer, 0, i, ISO_8859_1);
    }

    /**
     * Erzeuge die Zieldatei. Stelle dabei sicher, dass Sie unterhalb des Zielverzeichnis liegt.
     * Es ist nicht möglich, durch einen Namen wie "../test.txt" nach oben zu navigieren.
     * @param dateiname der empfangene Dateiname
     * @param verzeichnis das Zielverzeichnis
     * @return eine Datei im Zielverzeichnis
     * @throws IOException 
     */
    private File erzeugeSichereDatei(String dateiname, File verzeichnis) throws IOException {
        File datei = new File(dateiname);
        //Nimm nur den Namensbestandteil des empfangenen Namens
        datei = new File(verzeichnis, datei.getName());
        datei.createNewFile();
        return datei;
    }

    /**
     * Empfange den Dateiinhalt
     * @param datei die Zieldate
     * @param in der InputStream, aus dem zu lesen ist
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void schreibeDatei(File datei, BufferedInputStream in) throws FileNotFoundException, IOException {
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(datei))) {
            byte[] buffer = new byte[4096];
            int gelesen = 0;
            while ((gelesen = in.read(buffer)) != -1) {
                out.write(buffer, 0, gelesen);
            }
        }
    }

}
