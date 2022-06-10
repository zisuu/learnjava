package app.Kap12;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Objects;

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

    private String pfad;
    private String hostname;
    private Integer port;
    private String dateiname;
    private String daten;

    public String getPfad() {
        return pfad;
    }

    public void setPfad(String pfad) {
        this.pfad = pfad;
    }

    public String getHostname() {
        return this.hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return this.port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDateiname() {
        return this.dateiname;
    }

    public void setDateiname(String dateiname) {
        this.dateiname = dateiname;
    }

    public static void main(String[] args) throws IOException {
        // Prüfe Aufrufparameter: Client soll mit Hostnamen, Port und Dateipfad/Namen
        // aufgerufen werden
        if (args.length != 3) {
            throwError(
                    "Bitte Client mit einem Hostnamen, Port und Dateipfad/Namen starten!");
        }
        Client derClient = new Client();
        // erstelle var für Hostname des Servers
        derClient.setHostname(args[0]);
        // erstelle var für Port des Servers
        derClient.setPort(Integer.parseInt(args[1]));
        // erstelle File-Objekt mit aus Dateinamen
        File datei = new File(args[2]);
        // erstelle var für Dateinamen
        derClient.setDateiname(datei.getName());
        // den Dateiinhalt schreiben
        derClient.ausDatei(datei);
        // // // char[] buffer = new char[1024];
        // // // try (Reader reader = new FileReader(datei)) {
        // // // int gelesen;
        // // // while ((gelesen = reader.read(buffer)) > -1) {
        // // // char[] geleseneDaten = (gelesen == buffer.length) ? buffer :
        // Arrays.copyOf(buffer, gelesen);
        // // // vearbeitePuffer(geleseneDaten);
        // // // }
        // 3. daten für übermittlung aufbereiten = dateiname + 0-byte + dateiinhalt
        // verbindung zu server herstellen und Daten übermitteln
        // connectToServer(port, dateiBuffer);
    }

    /**
     * Datenklasse für einem Stream: zuerst den Dateinamen und dann den Dateiinhalt
     * zu übertragen:
     * Es ist kein umfangreiches oder komplexes Protokoll, aber es ist ein
     * Protokoll, das beide
     * Seiten benötigen, um zu kommunizieren.
     * 
     * Die einfachste Lösung dafür: Zwischen Dateinamen und Inhalt wird ein
     * einzelnes 0-Byte gesendet.
     * In einem gültigen Dateinamen kann kein Byte mit dem Wert 0 vorkommen, es
     * eignet sich deshalb
     * gut als Terminator. Alles, was nach dem ersten 0-Byte steht, ist der Inhalt
     * der Datei.
     *
     */

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.dateiname);
        hash = 97 * hash + Objects.hashCode(this.daten);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.dateiname, other.dateiname)) {
            return false;
        }
        if (!Objects.equals(this.daten, other.daten)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dateiname + 0 + daten;
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
    public static Client ausDatei(File datei) throws IOException {
        if (datei == null || !datei.exists() || !datei.isFile() || !datei.canRead()) {
            throwError(" datei muss eine lesbare Datei sein.");
        }
        Client dataStream = new Client();
        dataStream.pfad = datei.getAbsolutePath();

        try (InputStream in = new BufferedInputStream(new FileInputStream(datei))) {
            int gelesen;
            byte[] buffer = new byte[1024];
            while ((gelesen = in.read(buffer)) > -1) {
                byte[] geleseneDaten = (gelesen == buffer.length)
                        ? buffer
                        : Arrays.copyOf(buffer, gelesen);
                fuelleStreamAusDatei(dataStream, geleseneDaten);

            }
        }
        return dataStream;
    }

    private static void fuelleStreamAusDatei(Client client, byte[] geleseneDaten) {
        String contents = new String(geleseneDaten);
    }

    // private static void connectToServer(String hostname, Integer port, File
    // verzeichnis) throws IOException {

    // // Beispiel Client
    // String nachricht = in.readLine();

    // try (
    // Socket verbindungClient = new Socket("localhost", 23456)) {
    // BufferedReader reader = new BufferedReader(
    // new InputStreamReader(verbindungClient.getInputStream()));
    // BufferedWriter writer = new BufferedWriter(
    // new OutputStreamWriter(verbindungClient.getOutputStream()));
    // writer.write(nachricht);
    // writer.newLine();
    // writer.flush();
    // String antwort = reader.readLine();
    // }
    // }

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