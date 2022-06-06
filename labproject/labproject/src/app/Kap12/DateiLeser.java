package app.Kap12;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * Programm, um eine Datei zu lesen.
 *
 * @author zisuu
 */
public class DateiLeser {

    public static void main(String[] args) throws Exception{
        // Prüfe Aufrufparameter
        if (args.length != 1) {
            System.out.println("Bitte Datei angeben!");
            System.exit(1);
        }
        File quelle = new File(args[0]);
        char[] buffer = new char[1024];
        try (Reader reader = new FileReader(quelle)) {
            int gelesen;
            while ((gelesen = reader.read(buffer)) > -1) {
                char[] geleseneDaten = (gelesen == buffer.length) ? buffer : Arrays.copyOf(buffer, gelesen);
                vearbeitePuffer(geleseneDaten);
            }
        }
    }
    private static void vearbeitePuffer(char[] geleseneDaten) {
        String contents = new String(geleseneDaten);
        System.out.println(contents);
    }
}