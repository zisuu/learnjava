package de.kaiguenster.javaintro.dateikopie;

import java.io.File;
import java.nio.file.Files;

/**
 * Programm, um eine Datei zu kopieren.
 *
 * @author Kai Günster
 */
public class Dateikopie {

    public static void main(String[] args) {
        //Es müssen genau zwei Parameter übergeben werden: Quelle und Ziel
        if (args.length != 2) {
            endeMitFehler("Sie müssen 2 Dateien angeben");
        }
        try {
            //Erzeuge File-Objekte aus den Dateinamen
            File quelle = new File(args[0]);
            File ziel = new File(args[1]);
            //prüfe, ob die Quelldatei gültig ist
            pruefeQuellDatei(quelle);
            //Prüfe, ob das Ziel gültig ist. Lege Verzeichnisse an, falls nötig.
            ziel = pruefeUndErzeugeZiel(ziel, quelle.getName());
            //Kopiere die Dateien.
            Files.copy(quelle.toPath(), ziel.toPath()).toFile();
        } catch (Exception e) {
            endeMitFehler(e.getMessage());
        }
    }

    /**
     * Programm mit einer Fehlermeldung beenden
     *
     * @param fehlermeldung die Fehlermeldung
     */
    private static void endeMitFehler(String fehlermeldung) {
        //Fehlermeldung ausgeben
        System.err.println("Fehler beim Kopieren: " + fehlermeldung);
        //System.exit mit einem Wert != 0 bedeutet Ende mit Fehler
        System.exit(1);
    }

    /**
     * Prüft, ob die Quelldatei gültig ist
     *
     * @param quelle die Quelldatei
     * @throws Exception falls die Quelldatei nicht existiert, bicht lesbar ist
     * oder keine Datei ist.
     */
    private static void pruefeQuellDatei(File quelle) throws Exception {
        if (!quelle.exists()) {
            throw new Exception("Quelle nicht vorhanden");
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
    private static File pruefeUndErzeugeZiel(File ziel, String name) throws Exception {
        if (ziel.exists() && ziel.isFile()) {
            //Ziel ist eine Datei und existiert bereits.
            throw new Exception("Zieldatei existiert bereits");
        } else if (ziel.exists() && ziel.isDirectory()) {
            //Ziel existiert, aber ist ein Verzeichnis
            if (!ziel.canWrite()) {
                //Ziel ist nicht schreibbar
                throw new Exception("Zielverzeichnis nicht schreibbar");
            } else {
                /*
                 Ziel ist Verzeichnis und schreibbar: erzeuge ein File-Objekt in 
                 diesem Verzeichnis mit dem Namen der Quelldatei
                 */
                return new File(ziel, name);
            }
        } else {
            //Ziel existiert nicht: erzeuge Elternverzeichnisse falls nötig
            ziel.getParentFile().mkdirs();
            return ziel;
        }
    }
}
