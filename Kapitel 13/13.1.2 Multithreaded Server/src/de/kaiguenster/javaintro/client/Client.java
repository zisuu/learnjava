package de.kaiguenster.javaintro.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Programm, um eine Daten durch das Netzwerk von einem Server liest.
 *
 * @author Kai Günster
 */
public class Client implements Runnable {

    private final String hostname;
    private final int port;
    private final int id;

    public static void main(String[] args) throws IOException {
        //Aurfurfparameter prüfen
        if (args.length != 2) {
            endeMitFehler("Aufruf: java de.kaiguenster.javaintro.client.Client <host> <port>");
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
        for (int i = 0; i < 20; i++) {
            //Starte 20 Clients in eigenen Threads
            new Thread(new Client(host, port, i)).start();
        }
    }

    private static void endeMitFehler(String nachricht) {
        System.out.println(nachricht);
        System.exit(1);
    }

    /**
     * Erzeuge einen Client
     * @param hostname Name des entfernten Rechners
     * @param port Port für die Verbindung
     * @param id id des Client-Threads
     */
    public Client(String hostname, int port, int id) {
        this.hostname = hostname;
        this.port = port;
        this.id = id;
    }

    @Override
    public void run() {
        //Diese Methode wird ausgeführt, wenn ein Client-Thread startet
        long startzeit = System.currentTimeMillis();
        //Baue eine Verbindung zum entfernten Rechner auf
        try (Socket verbindung = new Socket(hostname, port)) {
            //Öffne einen InputStream
            BufferedReader reader = new BufferedReader(new InputStreamReader(verbindung.getInputStream()));
            //Lies eine Textzeile vom Servedr
            System.out.println(id + ": " + reader.readLine());
            //Berechne die benötigte Zeit
            long zeitInSekunden = (System.currentTimeMillis() - startzeit) / 1000;
            System.out.println(id + ": " + (zeitInSekunden) + " Sekunden");
        } catch (IOException ex) {
            System.out.println(id + ": " + ex.getMessage());
        }
    }

}
