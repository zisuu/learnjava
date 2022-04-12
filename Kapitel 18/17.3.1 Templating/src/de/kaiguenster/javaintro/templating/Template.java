package de.kaiguenster.javaintro.templating;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ein einfaches Templating-System, dass aus einer Vorlage und einem Datenobjekt
 * durch Reflection einen Text erzegt, in dem Platzhalter durch Daten aus dem 
 * Objekt ersetzt wurden. 
 * Platzhalter werden durch führende und abschließende $$ markiert, also zum 
 * Beispiel $$vorname$$. Namen der Platzhalter werden auf Getter des Datenobjektes 
 * abgebildet.
 * @author Kai Günster
 */
public class Template {

    /**
     * Das Pattern, mit dem Platzhalter erkannt werden.
     */
    private static final Pattern FELD_PATTERN = Pattern.compile("\\$\\$([a-z][a-zA-Z0-9]*)\\$\\$");
    
    /**
     * Der Text der Vorlage
     */
    private String templateText;
    
    /**
     * Liste von in der Vorlage identifizierten Platzhaltern.
     */
    private List<String> felder;
    
    /**
     * Erzeugt ein neues Template aus einem Dateinamen
     * @param filename relativer oder absoluter Pfad einer existierenden, 
     * lesbaren Template-Datei
     * @throws FileNotFoundException wenn die Datei nicht gefunden wurde
     * @throws IOException bei anderen IO Problemen
     */
    public Template(String filename) throws FileNotFoundException, IOException{
        this(new File(filename));
    }

    /**
     * Erzeugt ein neues Template aus einem File
     * @param file eine lesbare, existierende Template-Datei
     * @throws FileNotFoundException wenn die Datei nicht gefunden wurde
     * @throws IOException bei anderen IO Problemen
     */
    public Template(File file) throws FileNotFoundException, IOException{
        this(new BufferedReader(new FileReader(file)));
    }
    
    /**
     * Erzeugt ein neues Template aus einem Reader
     * @param reader ein Reader, aus dem ein Template gelesen werden kann
     * @throws IOException bei anderen IO Problemen
     */

    public Template(Reader reader) throws IOException{
        //Den gesamten Inhalt der Template-Datei lesen
        this.templateText = liesTemplate(reader);
        //Felder im Template finden
        this.felder = parseTemplate(templateText);
    }

    /**
     * Liest eine Template-Datei und gibt ihren gesamten Inhalt als String zurück.
     * Annahme ist, dass ein Template nicht übermäßig gror wird
     * @param reader ein Reader, aus dem ein Template gelesen werden kann.
     * @return das gesamte Template als String
     * @throws IOException 
     */
    private final String liesTemplate(Reader reader) throws IOException {
        //Zum lesen wird ein 1024-Zeichen Puffer verwendet
        char[] buffer = new char[1024];
        int read;
        StringBuilder builder = new StringBuilder();
        //Solange Zeichen in den Puffer gelesen werden können...
        while ((read = reader.read(buffer)) >= 0){
            //... werden diese Zeichen an builder angehangen.
            builder.append(buffer, 0, read);
        }
        //Das Ergebnis als String zurückgeben.
        return builder.toString();
    }

    /**
     * Identifiziert alle Platzhalter im Template und gibt die Namen als Liste 
     * zurück
     * @param templateText der Template Text
     * @return eine Liste der Namen aller Platzhalter, ohne umgebende $$
     */
    private List<String> parseTemplate(String templateText) {
        List<String> felder = new ArrayList<>();
        //Erzeuge einen Matcher für den regulären Ausdruck FELD_PATTERN
        Matcher matcher = FELD_PATTERN.matcher(templateText);
        //Solange der Ausdruck weitere Platzhaltern findet...
        while(matcher.find()){
            /*
            Speichere deren Namen in der Ergebnisliste. Eine geklammerte Gruppe 
            im regulären Ausdruck wird verwendet, um die $$ abzuschneiden.
            */
            felder.add(matcher.group(1));
        }
        return felder;
    }
   
    /**
     * Erzeuge aus dem Namen eines Platzhalters den Namen der dazugehörigen
     * Getter-Methode
     * @param feld Name des Platzhalters
     * @return den Namen der Getter-Methode
     */
    private String zuGetterNamen(String feld){
        /*
        Das erste Zeichen des Platzhalters wird in einen Großbuchstaben 
        umgewandelt und es wird get davorgeschrieben.
        */
        return "get" + feld.substring(0, 1).toUpperCase() + feld.substring(1);
    }

    /**
     * Wende die Vorlage auf ein Datenobjekt an. Es wird versucht, alle 
     * Platzhalter durch einen passenden Wert aus dem Datenobjekt zu ersetzen.
     * @param eingabe das Datenobjekt
     * @return den erzeugten Text
     * @throws Exception wenn beim Zugriff per Reflection etwas schiefgeht, vor 
     * allem aber, wenn ein vom Template benötigtes Feld im Objekt fehlt.
     */
    public String wendeAn(Object eingabe) throws Exception{
        String ausgabe = templateText;
        for (String feld : felder){
            Method getter = eingabe.getClass().getMethod(zuGetterNamen(feld));
            String wert = getter.invoke(eingabe).toString();
            ausgabe = ausgabe.replace("$$" + feld + "$$", wert);
        }
        return ausgabe;
    }    
}
