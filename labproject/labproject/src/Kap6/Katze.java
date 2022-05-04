package Kap6;

public class Katze extends Tier {
    @Override
    public void setGewichtGr(int gewicht) {
        if (gewicht > 10000)
            throw new IllegalArgumentException("Katzen können nicht mehr als 10 kg wiegen");
        super.setGewichtGr(gewicht);
    }
}
