package app.Kap10;

/**
 * Der Kasten »Sortieren in mehreren Threads« behauptet, dass parallele Sortierung auf Maschinen mit mehreren 
 * Kernen wesentlich schneller ist als sequenzielle Sortierung. Zeit, das auf die Probe zu stellen.
 * 
 * Schreiben Sie eine Klasse Quader, die drei int-Felder enthält: Länge, Breite und Höhe des Quaders. 
 * Außerdem soll die Klasse eine Methode getVolumen haben, die das Volumen des Quaders berechnet. 
 * Quader sollen durch ihr Volumen eine natürliche Ordnung haben.
 * 
 * Schreiben Sie dann ein Programm, das nacheinander zufällige Quader-Arrays der Größe 
 * 10, 100, 1.000 … 10.000.000 erzeugt. Um zufällige Quadergrößen zu erzeugen, können Sie die Klasse 
 * java.util.Random verwenden; limitieren Sie die Quadergröße dabei in jede Richtung auf 100.
 * 
 * Jedes dieser Arrays soll einmal sequenziell und einmal parallel sortiert werden. Messen Sie jeweils 
 * von beiden Sortierungen die Zeit, und geben Sie sie aus.
 * 
 * Vergleichen Sie, ab welcher Array-Größe parallele Sortierung Vorteile bringt.
 */
public class Sortieren {
    
}
