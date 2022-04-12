package de.kaiguenster.javaintro.wordcount;

import java.io.*;
import java.util.*;

/**
 * Ein einfacher Wortzähler, der aus einem beliebigen {@link InputStream} Wörter zählt. 
 * Wörter sind alle Gruppen von alphabetischen Zeichen. Das führt zum Beispiel beim 
 * abgekürzten "geht's" dazu, dass es als "geht" und "s" gezählt wird.
 * @author Kai
 */
public class WordCount {

    
    private InputStream source;
    private Map<String, Integer> wordCounts = new HashMap<>();
    private int totalCount = 0;
    
    /**
     * Erzeuge ein neues WordCount-Objekt aus einem {@link InputStream}
     * @param source - der Inputstream, aus dem gelesen wird. Sollte auch wirklich 
     * Textdaten enthalten, sonst ist das Ergebnis ungewiss.
     */
    public WordCount(InputStream source){
        this.source = source;
    }
    
    /**
     * Zählt Wörter aus dem InputStream
     */
    public void count(){
        try(Scanner scan = new Scanner(source)){
            scan.useDelimiter("[^\\p{IsAlphabetic}]+");
            while (scan.hasNext()){
                String word = scan.next().toLowerCase();
                totalCount++;
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }    
    }

    /**
     * @return die Anzahl Wörter im Text
     */
    public int getTotalCount(){
        return totalCount;
    }
    
    /**
     * @return die Menge aller gefundenen Wörter im Text
     */
    public Set<String> getWords(){
        return Collections.unmodifiableSet(wordCounts.keySet());
    }
    
    /**
     * Findet, wie oft ein bestimmtes wort im Text vorkommt.
     * @param word - das Wort, nach dem gesucht wird
     * @return - wie oft das Wort im Text vorkommt
     */
    public int getCount(String word){
        Integer result = wordCounts.get(word);
        return result != null ? result : 0;
    }
    
    /**
     * Die Main-Methode wird ausgeführt, wenn WordCount als Programm aufgerufen wird. 
     * @param args - erwartet wird genau ein Aufrufparameter: ein Dateiname
     * @throws FileNotFoundException - diese Exception wird nie wirklich geworfen, 
     * der Fehler wird vorher abgefangen
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) fail("WordCount requires exactly one file name as argument");
        File f = new File(args[0]);
        if (!f.exists()) fail("File does not exist " + f.getAbsolutePath());
        if (!f.isFile()) fail("Not a file " + f.getAbsolutePath());
        if (!f.canRead()) fail("File not readable " + f.getAbsolutePath());
        try(FileInputStream in = new FileInputStream(f)){
            WordCount count = new WordCount(new FileInputStream(f));
            count.count();
            System.out.println("Words in total: " + count.getTotalCount());
            count.getWords().stream().sorted().forEach((word) -> {
                System.out.println(word + ": " + count.getCount(word));
            });
        }
    }    
    
    /**
     * Hilfsmethode zu main: im Fehlerfall schreibt diese Methode eine Fehlermeldung 
     * und beendet das Programm
     * @param message - die Fehlermeldung
     */
    private static void fail(String message){
        System.err.println(message);
        System.exit(1);
    }
}
