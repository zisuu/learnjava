public class fail {
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
