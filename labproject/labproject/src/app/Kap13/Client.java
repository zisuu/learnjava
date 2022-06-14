package app.Kap13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.stream.IntStream;

/**
 * Als Erstes benötigen Sie einen Client. Er soll mit einem Hostnamen und einem
 * Port gestartet werden und 20 Threads starten,
 * die sich zu diesem Host und Port verbinden, von dort eine einzelne Zeile Text
 * lesen und dann ausgeben, wie lange sie auf
 * Antwort warten mussten.
 * 
 * Zu einem Client gehört natürlich auch ein Server. Schreiben Sie zunächst eine
 * Klasse SinglethreadedServer, die keine neuen
 * Threads startet, sondern nur in einer Endlosschleife Netzwerkverbindungen
 * annimmt, 2 Sekunden wartet, eine Zeile Text –
 * irgendeinen Text – in den Socket schreibt und dann den Socket schließt.
 * Starten Sie den Server, führen Sie den Client aus,
 * und beobachten Sie, wie lange für die Antworten gebraucht wird.
 * 
 * Die dritte Klasse soll ein weiterer Server sein und den Namen
 * MultithreadedServer tragen. Dieser Server soll für jede
 * angenommene Verbindung einen neuen Thread starten, in diesem Thread 10
 * Sekunden warten und dann Text in den Socket schreiben.
 * Führen Sie Ihren Client auch mit diesem Server aus, und beobachten Sie, wie
 * sich das Verhalten ändert.
 */
public class Client {

  private final String hostname;
  private final int port;

  public static void main(String[] args) throws Exception {
    // Prüfe Aufrufparameter: Client soll mit Hostnamen, Port und Dateipfad/Namen
    // aufgerufen werden
    if (args.length != 2) {
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
    // neues Client-Objekt erzeugen und die Datei übertragen
    System.out.println(new Client(host, port).leseDaten());
  }

  /**
   * Der Client-Objekt Konstruktor
   * 
   * @param hostname
   * @param port
   */
  public Client(String hostname, int port) {
    this.hostname = hostname;
    this.port = port;
  }

  protected String leseDaten() throws UnknownHostException, IOException {
    try (Socket verbindung = new Socket(hostname, port)) {
      BufferedReader reader = new BufferedReader(
          new InputStreamReader(verbindung.getInputStream()));
      return reader.readLine();
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
