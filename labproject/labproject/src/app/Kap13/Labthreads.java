package app.Kap13;

import java.util.stream.IntStream;

public class Labthreads {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> 
                    .forEach(j -> 
                    // neues Client-Objekt erzeugen und die Datei übertragen
                    new Client(host, port).sendeDatei(datei)));
            t.start();
        }
    }
}
