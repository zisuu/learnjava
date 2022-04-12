package de.kaiguenster.javaintro.datenundzeiten.DatenUndZeiten;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Eine Klasse, um Ihren persönlichen Fernsehkalender zu erzeugen.
 *
 * @author Kai Günster
 */
public class Fernsehkalender {

    /**
     * Berechnet Ihren persönlichen Fernsehkalender. Aus einem Array von
     * {@link Fernsehserie}n wird ein Array von {@link Folge}n berechnet, mit
     * der genauen Ausstrahlungszeit. Voraussetzung ist natürlich, dass die
     * Ausstrahlung regelmäßig ist.
     *
     * @param serien ein Array von {@link Fernsehserie}n mit dem
     * Ausstrahlungsdatum der ersten Folge in der Zeitzone der Ausstrahlung
     * @param zeitzone die Zeitzone, in der Sie den Kalender sehen wollen
     * @return ein Array von {@link Folge}n, mit dem Ausstrahlungsdatum in der
     * angegebenen Zeitzone
     * @throws IllegalArgumentException wenn ein null-Argument übergeben wird.
     */
    public static Folge[] erzeugeKalender(Fernsehserie[] serien, ZoneId zeitzone) {
        if (serien == null || zeitzone == null) {
            throw new IllegalArgumentException("serien und zeitzone dürfen nicht null sein.");
        }
        //Ergebnis muss genug Platz für die Folgen aller Serien haben
        Folge[] ergebnis = new Folge[zaehleAlleFolgen(serien)];
        int index = 0;
        //Über die Serien iterieren
        for (int i = 0; i < serien.length; i++) {
            Fernsehserie serie = serien[i];
            ZonedDateTime ausstrahlungOriginal = serie.ersteFolge;
            //Für jede Folge der aktuellen Serie...
            for (int j = 0; j < serie.folgen; j++) {
                //... die Ausstrahlungszeit in die benötigte Zeitzone übersetzen ...
                ZonedDateTime ausstrahlungLokal = ausstrahlungOriginal.withZoneSameInstant(zeitzone);
                //... daraus eine Folge erzeugen... 
                ergebnis[index++] = new Folge(serie.name, j + 1, ausstrahlungLokal);
                //... und die nächste Ausstrahlungszeit genau eine Woche in der Zukunft setzen
                ausstrahlungOriginal = ausstrahlungOriginal.plusWeeks(1);
            }
        }
        //Die Folgen nach Ausstrahlungszeit sortieren
        Arrays.sort(ergebnis, COMPARATOR_AUSSTRAHLUNGSZEIT);
        return ergebnis;
    }

    /**
     * Erzeugt einen Kalender mit {@link #erzeugeKalender(Fernsehserie[], ZoneId) 
     * in der Default-Zeitzone Ihres Systems.
     * @param serien
     * @return 
     */
    public static Folge[] erzeugeKalender(Fernsehserie[] serien) {
        return erzeugeKalender(serien, ZoneId.systemDefault());
    }

    private static int zaehleAlleFolgen(Fernsehserie[] serien) {
        int arraygroesse = 0;
        for (int i = 0; i < serien.length; i++) {
            arraygroesse += serien[i].folgen;
        }
        return arraygroesse;
    }

    private final static FolgenComparatorNachAusstrahlungszeit COMPARATOR_AUSSTRAHLUNGSZEIT = new FolgenComparatorNachAusstrahlungszeit();

    private static final class FolgenComparatorNachAusstrahlungszeit implements Comparator {

        public int compare(Object o1, Object o2) {
            Folge f1 = (Folge) o1;
            Folge f2 = (Folge) o2;
            return f1.ausstrahlung.compareTo(f2.ausstrahlung);
        }
    }

}
