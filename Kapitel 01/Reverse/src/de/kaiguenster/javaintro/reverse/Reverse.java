/**
 * Programm zum Umkehren von Strings in der Kommandozeile. 
 * @author Kai
 * @version 1.0
 */
package de.kaiguenster.javaintro.reverse;

/**
 *
 * @author Kai
 */
public class Reverse {

    /**
     * Kehrt einen <code>String</code> zeichenweise um. Zum Beispiel wird "Hallo, Welt!" zu "!tleW ,ollaH"
     * @param in der umzukehrende <code>String</code>
     * @return den umgekehrten <code>String</code>
     * @throws IllegalArgumentException wenn in == <code>null</code> ist.
     */
    public static String reverse(String in){
        if (in == null) throw new IllegalArgumentException("Parameter in muss übergeben werden.");
        StringBuilder out = new StringBuilder();
        for (int i = in.length() - 1; i >= 0; i--){
            out.append(in.charAt(i));
        }
        return out.toString();
    }
    
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Aufruf: java de.kaiguenster.javaintro.reverse.Reverse \"<text>\"");
            System.exit(1);
        }
        String reversed = reverse(args[0]);
        System.out.println(reversed);
    }
    
}
