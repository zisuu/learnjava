package Kap4;


/**
 * Klasse Song, mit zwei String-Feldern interpret und titel und einem int-Feld
 * laengeInSekunden.
 * 
 * @author zisuu
 * @version 1.0
 */
public class Song {

    public String interpret;
    public String titel;
    public Integer laengeInSekunden;

    /**
     * Methode die die Daten des Songs auf die Kommandozeile ausgibt
     */
    public void print() {
        System.out.println(this);
    }

    /**
     * formatTime-Methode soll aus dem Feld laengeInSekunden eine Zeitangabe im Format
     * Minuten:Sekunden berechnen und diese zurückgeben.
     * 
     * @param laengeInSekunden - Dauer des Songs in Sekunden als
     *                         <code>Integer</code>
     * @return laengeInMinutenSekunden - Dauer des Songs im Format minuten:sekunden
     *         als <code>Integer</code>
     */
    public String formatTime() {
        Integer hours = this.laengeInSekunden / 3600;
        Integer seconds = this.laengeInSekunden % 60;
        Integer minutes = (this.laengeInSekunden % 3600) / 60;
        String duration = "";
        if (hours >0){
            duration += leadingZeros(hours) +":";
        } 
        duration += leadingZeros(minutes) + ":" + leadingZeros(seconds);
        return duration;
    }

    /**
     * Hilfsmethode, um Zahlen zu "polstern": bei einstelligen Zahlen wird eine führende null eingefügt.
     * @param number - die zu formatierende Zahl
     * @return die Zahl als String, mit führender 0 falls nötig.
     */
    private static String leadingZeros(Integer number) {
        return number < 10 ? "0" + number : Integer.toString(number);
    }

    /**
     * toString-Methode soll aus dem Feld laengeInSekunden eine Zeitangabe im Format
     * Minuten:Sekunden berechnen und
     * diese zurückgeben.
     * 
     * @return die String-Darstellung dieses Objekts.
     */
    public String toString() {
        return "Interpret: " + this.interpret + ", Titel: " + this.titel + ", Dauer: " + this.formatTime();
    }

}
