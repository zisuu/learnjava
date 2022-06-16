package app.Kap13;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Die dritte Klasse soll ein weiterer Server sein und den Namen
 * MultithreadedServer tragen.
 * Dieser Server soll für jede angenommene Verbindung einen neuen Thread
 * starten, in diesem
 * Thread 10 Sekunden warten und dann Text in den Socket schreiben. Führen Sie
 * Ihren Client
 * auch mit diesem Server aus, und beobachten Sie, wie sich das Verhalten
 * ändert. Die Lösung
 * zu dieser Übung finden Sie im Anhang.
 */
public class MultithreadedServer implements Runnable {
    Socket csocket;

    MultithreadedServer(Socket csocket) {
           this.csocket = csocket;
        }

    public static void main(String args[]) throws Exception {
        ServerSocket ssock = new ServerSocket(1234);
        System.out.println("Listening");

        while (true) {
            Socket sock = ssock.accept();
            System.out.println("Connected");
            Thread.sleep(10000); // set time delay to 10 seconds
            new Thread(new MultithreadedServer(sock)).start();
        }
    }

    public void run() {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(csocket.getOutputStream()));
            String antwort = "This is just a test!";
            writer.write(antwort);
            writer.newLine();
            writer.flush();
            csocket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
