package de.kaiguenster.javaintro.musikfinder;

import java.io.File;
import java.util.Arrays;
import java.util.function.Consumer;

public class Musikfinder {

    final private File start;
    
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Benutzung: java de.kaiguenster.javaintro.musikfinder.Musikfinder <Startverzeichnis>");
            System.exit(1);
        }
        new Musikfinder(args[0]).findeMusik(System.out::println);
            
    }
    
    public Musikfinder(String start){
        this(new File(start));
    }
    
    public Musikfinder(File start){
        if (!start.exists() || !start.isDirectory() || !start.canRead())
            throw new IllegalArgumentException("Startverzeichnis muss ein lesbares Verzeichnis sein");
        this.start = start;
        
    }
    
    public void findeMusik(Consumer<File> c){
        findeMusik(start, c);
    }

    private void findeMusik(File verzeichnis, Consumer<File> c) {
        File[] unterverzeichnisse = verzeichnis.listFiles(f -> f.isDirectory() && f.canRead());
        if (unterverzeichnisse != null)
            Arrays.stream(unterverzeichnisse).forEach(f -> this.findeMusik(f, c));
        File[] musikDateien = verzeichnis.listFiles(f-> f.getName().endsWith(".mp3"));
        if (musikDateien != null)
            Arrays.stream(musikDateien).forEach(c);
    }
    
}
