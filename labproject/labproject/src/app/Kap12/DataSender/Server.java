package app.Kap12.DataSender;

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
public class Server {

    /**
     * Encoding für den Dateinamen
     */
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    

    private final File verzeichnis;
    private final int port;

    public static void main(String[] args) throws IOException {
        // Prüfe Aufrufparameter: Der Server soll mit einem Port und einem
        // Verzeichnis als Aufrufparameter gestartet werden.
        if (args.length != 2) {
            throwError("Bitte Server mit Verzeichnis und Port als Aufrufparameter starten!");
        }
        File verzeichnis = new File(args[0]);
        if (!verzeichnis.exists() || !verzeichnis.isDirectory() || !verzeichnis.canWrite()) {
            throwError(args[0] + " ist kein schreibbares Verzeichnis!");
        }
        if (!args[1].matches("\\d+")) {
            throwError(args[1] + " ist kein gültiger Port!");
        }
        int port = Integer.parseInt(args[1]);
        if (port < 1024 || port > 65535){
            throwError(port + " ist nicht im Range der dynamischen TCP Ports von 1024 bis 65535!");
        }
        // starte Server und warte bis Verbindung aufgebaut ist
        new Server(port, verzeichnis).erwarteVerbindung(port);
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

    /**
     * Das Server-Objekt Konstruktor
     * 
     * @param port
     * @param verzeichnis
     */
    public Server(int port, File verzeichnis) {
        this.port = port;
        this.verzeichnis = verzeichnis;
    }

    public void erwarteVerbindung(Integer port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        try (
                Socket verbindung = server.accept()) {
            // Öffne einen BufferedInputStream für die Verbindung
            BufferedInputStream in = new BufferedInputStream(verbindung.getInputStream());
            String dateiname = liesNameAusStream(in);
            // 3. erstelleDatei und danach schreibeDatei
            schreibeDatei(in, erstelleDatei(verzeichnis, dateiname));
        }
    }

    /**
     * Liest den Dateinamen aus dem Inputstream
     * 
     * @param in der InputStream
     * @return den Dateinamen
     * @throws IOException
     */
    private String liesNameAusStream(BufferedInputStream in) throws IOException {
        byte[] buffer = new byte[255];
        int i;
        // Lies maximal 255 Byte aus dem Strom. Es wird Byte für Byte gelesen, um nicht
        // versehentlich nach dem Ende des Namens weiterzulesen
        for (i = 0; i < 255; i++) {
            int gelesen = in.read();
            // -1 signalisiert einen Verbindungsabbruch
            if (gelesen == -1) {
                throw new IllegalStateException("Unerwartetes Ende des Datenstromns");
            }
            // ein 0-byte ist das mit dem Client vereinbarte Zeichen für das Ende des
            // Dateinamens
            if (gelesen == 0) {
                break;
            }
            buffer[i] = (byte) gelesen;
        }
        // Erzeuge aus den empfangenen Byte einen String
        return new String(buffer, 0, i, ISO_8859_1);
    }

    /**
     * Prüft, ob die Zieldatei gülltig ist, und legt Verzeichnisse an, falls
     * nötig
     *
     * @param ziel die Zieldatei
     * @param name - name der Quelldatei
     * @return ein File-Objekt der Zieldatei
     * @throws IOException
     * @throws Exception   wenn ziel nicht schreibbar ist oder bereits existiert
     */
    private File erstelleDatei(File verzeichnis, String dateiname) throws IOException {
        File datei = new File(dateiname);
        // Nimm nur den Namensbestandteil des empfangenen Namens
        datei = new File(verzeichnis, datei.getName());
        datei.createNewFile();
        return datei;
    }


    private void schreibeDatei(BufferedInputStream in, File datei) throws FileNotFoundException, IOException {
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(datei))) {
            byte[] buffer = new byte[4096];
            int bytesRead = 0;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }

    }
}
