package app.Kap12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Für diese Übung schreiben Sie zwei Programme, einen Server und einen Client. 
 * 
 * Der Server soll mit einem Port und einem Verzeichnis als Aufrufparameter gestartet werden. 
 * 
 * Er soll auf dem Port auf eine Verbindung warten, von dieser Verbindung einen Dateinamen und den 
 * Dateiinhalt lesen und diese Datei in das übergebene Verzeichnis schreiben.
 * 
 * Die Aufgabe des Clients ist damit schon klar: Er soll mit einem Hostnamen, Port und Dateinamen 
 * aufgerufen werden, eine Verbindung zu diesem Host auf diesem Port aufbauen und Dateinamen und 
 * Inhalt übermitteln.
 * 
 * Lesen und Schreiben der Dateien sind nichts Neues mehr, und mit den Netzwerkverbindungen können 
 * Sie, wie Sie gesehen haben, sehr ähnlich umgehen. Insofern müssen Sie nur das in diesem Kapitel 
 * Gelernte zusammensetzen.
 * 
 * Eine Schwierigkeit besteht darin, dass Sie ein Protokoll entwickeln müssen, um in einem Stream 
 * zuerst den Dateinamen und dann den Dateiinhalt zu übertragen. Es ist kein umfangreiches oder 
 * komplexes Protokoll, aber es ist ein Protokoll, das beide Seiten benötigen, um zu kommunizieren. 
 * Die einfachste Lösung dafür: Zwischen Dateinamen und Inhalt wird ein einzelnes 0-Byte gesendet.
 * In einem gültigen Dateinamen kann kein Byte mit dem Wert 0 vorkommen, es eignet sich deshalb 
 * gut als Terminator. Alles, was nach dem ersten 0-Byte steht, ist der Inhalt der Datei. 
 * 
 * Als weitere Einschränkung sollte der Dateiname niemals länger als 255 Byte sein – dies ist das
 *  Limit vieler aktuell verbreiteter Dateisysteme.
 * 
 * Idealerweise können Sie Ihre Programme mit zwei verschiedenen Computern testen, so dass die 
 * Daten wirklich über ein Netzwerk übertragen werden. Wenn Sie diese Möglichkeit nicht haben, 
 * können Sie aber auch beide Programme auf demselben Computer ausführen und als Hostnamen für 
 * den Client localhost angeben.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 1. Prüfe Aufrufparameter: Der Server soll mit einem Port und einem Verzeichnis als Aufrufparameter gestartet werden.
        if (args.length != 2) {
            throwError(
                    "Bitte Server mit Port und einem Verzeichnis als Aufrufparameter starten!");
        }
        int port = Integer.parseInt(args[0]);
        File verzeichnis = new File(args[1]);

        // 2. starte Server und warte bis Verbindung aufgebaut ist
        starteServer(port, verzeichnis);
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
    
    private static void starteServer(Integer port, File verzeichnis) throws IOException {
        ServerSocket server = new ServerSocket(port);
        try(
        Socket verbindung = server.accept())
        // 3. wenn Verbindung ok, dann empfange zuerst dateinamen
        // 4. Dateiname endet wenn 0-Byte übertragen wird
        // 5. Nun kommt Dateiinhalt
        {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(verbindung.getInputStream()));
            String nachricht = reader.readLine();
        }
    }

}
