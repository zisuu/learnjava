package app.Kap12;

import java.io.File;
import java.nio.file.Files;

/**
 * Programm, um eine Datei zu kopieren.
 *
 * @author zisuu
 */
public class FileCopy {

    public static void main(String[] args) {
        // Es müssen genau zwei Parameter übergeben werden: Quelle und Ziel
        if (args.length != 2) {
            throwError(
                    "Bitte übergeben Sie als erster Parameter die Quell-Datei und als zweiter Parameter die Ziel-Datei an");
        }
        try {
            // erzeuge File-Objekte aus Dateinamen
            File quelle = new File(args[0]);
            File ziel = new File(args[1]);
            // prüfe, ob die Quelldatei gültig ist
            checkSourceFile(quelle);
            // Prüfe, ob das Ziel gültig ist. Lege Verzeichnisse an, falls nötig.
            ziel = checkAndCreateDest(ziel, quelle.getName());
            // Kopiere Datei
            Files.copy(quelle.toPath(), ziel.toPath()).toFile();
        } catch (Exception e) {
            throwError(e.getMessage());
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

    /**
     * Prüft. ob die Quelldatei gültig ist
     * 
     * @param quelle
     * @throws Exception falls Datei nicht existiert, nicht lesbar ist oder keine
     *                   Datei ist.
     */
    private static void checkSourceFile(File quelle) throws Exception {
        // Prüfe ob Quelldateie vorhanden
        if (!quelle.exists()) {
            throw new Exception("Fehler: Quelldatei " + quelle.toString() + " existiert nicht!");
        }
        if (!quelle.isFile()) {
            throw new Exception("Quelle ist keine Datei");
        }
        if (!quelle.canRead()) {
            throw new Exception("Quelle nicht lesbar");
        }
    }

    /**
     * Prüft, ob die Zieldatei gülltig ist, und legt Verzeichnisse an, falls
     * nötig
     *
     * @param ziel die Zieldatei
     * @param name - name der Quelldatei
     * @return ein File-Objekt der Zieldatei
     * @throws Exception wenn ziel nicht schreibbar ist oder bereits existiert
     */
    private static File checkAndCreateDest(File ziel, String name) throws Exception {
        // Prüfe ob Zieldatei bereits existiert und ob diese ein File ist
        if (ziel.exists() && ziel.isFile()) {
            throw new Exception("Zieldatei " + ziel + " existiert bereits");
        } else if (ziel.exists() && ziel.isDirectory()) {
            // Ziel existiert, aber ist ein Verzeichnis
            if (!ziel.canWrite()) {
                // Ziel ist nicht schreibbar
                throw new Exception("Zielverzeichnis nicht schreibbar");
            } else {
                /*
                 * Ziel ist Verzeichnis und schreibbar: erzeuge ein File-Objekt in
                 * diesem Verzeichnis mit dem Namen der Quelldatei
                 */
                return new File(ziel, name);
            }
        } else {
            // Ziel existiert nicht: erzeuge Elternverzeichnisse falls nötig
            ziel.getParentFile().mkdirs();
            return ziel;
        }
    }
}
