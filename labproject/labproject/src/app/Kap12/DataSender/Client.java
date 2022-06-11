package app.Kap12.DataSender;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Für diese Übung schreiben Sie zwei Programme, einen Server und einen Client.
 * 
 * Der Server soll mit einem Port und einem Verzeichnis als Aufrufparameter
 * gestartet werden.
 * 
 * Er soll auf dem Port auf eine Verbindung warten, von dieser Verbindung einen
 * Dateinamen und den
 * Dateiinhalt lesen und diese Datei in das übergebene Verzeichnis schreiben.
 * 
 * Die Aufgabe des Clients ist damit schon klar: Er soll mit einem Hostnamen,
 * Port und Dateinamen
 * aufgerufen werden, eine Verbindung zu diesem Host auf diesem Port aufbauen
 * und Dateinamen und
 * Inhalt übermitteln.
 * 
 * Lesen und Schreiben der Dateien sind nichts Neues mehr, und mit den
 * Netzwerkverbindungen können
 * Sie, wie Sie gesehen haben, sehr ähnlich umgehen. Insofern müssen Sie nur das
 * in diesem Kapitel
 * Gelernte zusammensetzen.
 * 
 * Eine Schwierigkeit besteht darin, dass Sie ein Protokoll entwickeln müssen,
 * um in einem Stream
 * zuerst den Dateinamen und dann den Dateiinhalt zu übertragen. Es ist kein
 * umfangreiches oder
 * komplexes Protokoll, aber es ist ein Protokoll, das beide Seiten benötigen,
 * um zu kommunizieren.
 * Die einfachste Lösung dafür: Zwischen Dateinamen und Inhalt wird ein
 * einzelnes 0-Byte gesendet.
 * In einem gültigen Dateinamen kann kein Byte mit dem Wert 0 vorkommen, es
 * eignet sich deshalb
 * gut als Terminator. Alles, was nach dem ersten 0-Byte steht, ist der Inhalt
 * der Datei.
 * 
 * Als weitere Einschränkung sollte der Dateiname niemals länger als 255 Byte
 * sein – dies ist das
 * Limit vieler aktuell verbreiteter Dateisysteme.
 * 
 * Idealerweise können Sie Ihre Programme mit zwei verschiedenen Computern
 * testen, so dass die
 * Daten wirklich über ein Netzwerk übertragen werden. Wenn Sie diese
 * Möglichkeit nicht haben,
 * können Sie aber auch beide Programme auf demselben Computer ausführen und als
 * Hostnamen für
 * den Client localhost angeben.
 */
public class Client {

    /**
     * Encoding für den Dateinamen
     */
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    
    private final String hostname;
    private final int port;

    public static void main(String[] args) throws IOException {
        // Prüfe Aufrufparameter: Client soll mit Hostnamen, Port und Dateipfad/Namen
        // aufgerufen werden
        if (args.length != 3) {
            throwError(
                    "Bitte Client mit einem Hostnamen, Port und Dateipfad/Namen starten!");
        }
        String host = args[0];
        if (!args[1].matches("\\d+")) {
            throwError(args[1] + " ist kein gültiger Port.");
        }
        int port = Integer.parseInt(args[1]);
        if (port <= 1024) {
            throwError("Ports unter 1024 sind reserviert");
        }
        if (port > 65535) {
            throwError("Der höchte Port ist 65535");
        }
        File datei = new File(args[2]);
        if (!datei.exists() || !datei.isFile() || !datei.canRead()) {
            throwError(args[2] + " ist keine lesbare Datei");
        }
        // neues Client-Objekt erzeugen und die Datei übertragen
        new Client(host, port).sendeDatei(datei);
    }

    /**
     * Der Client-Objekt Konstruktor
     * @param hostname
     * @param port
     */
    public Client(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    /**
     * Statische Methode, um ein Client aus dem Dateinamen und dem
     * Dateiinhalt
     * zu erzeugen, getrennt von einem
     * 0-Byte.
     *
     * @param datei die Datei
     * @return ein Client-Objekt
     * @throws IOException              wenn Fehler beim Lesen auftreten
     * @throws IllegalArgumentException wenn datei keine lesbare Datei ist
     */
    public void sendeDatei(File datei) throws IOException {
        if (datei == null || !datei.exists() || !datei.isFile() || !datei.canRead()) {
            throwError(" datei muss eine lesbare Datei sein.");
        }
        try (
            Socket verbindung = new Socket(hostname, port)) {
            //Öffne einen OutputStream für die Verbindung
            BufferedOutputStream out = new BufferedOutputStream(verbindung.getOutputStream());
            sendeDateiname(out, datei);
            sendeDateinhalt(out, datei);
        }
    }

    public void sendeDateiname(BufferedOutputStream out, File datei) throws NumberFormatException, IOException {
        String filename = datei.getName();
        //Schneide zu lange Namen ab
        if (filename.length() > 255) {
            filename = filename.substring(0, 255);
        }
        //Sende den Namen im festgelegten Encoding
        out.write(filename.getBytes(ISO_8859_1));
        //Sende ein 0-byte. Der Server erkennt daran das Ende des Dateinamens
        out.write(0);
    }

    public void sendeDateinhalt(BufferedOutputStream out, File datei) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(datei))) {
            // lege buffer an
            byte[] buffer = new byte[4096];
            int read = 0;
            // sende Dateiinhalt an Server
            while ((read = in.read(buffer)) >= 0){
                out.write(buffer, 0, read);
            }
        }
    }

    /**
     * Programm mit einer Fehlermeldung beenden
     * 
     * @param error - die Fehlermedlung
     */
    private static void throwError(String error) {
        // Fehlermeldung ausgeben
        System.out.println("Fehler beim kopieren: " + error);
        System.exit(1);
    }
}