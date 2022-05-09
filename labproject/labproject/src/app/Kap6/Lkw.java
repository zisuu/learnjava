package app.Kap6;

public class Lkw extends Fahrzeug implements Motorisiert, Transporter {

    private String ladung;

    public Lkw(String markeUndModell, Double maxGeschwindigkeit, int sitzplaetze) {
        super(markeUndModell, maxGeschwindigkeit, sitzplaetze);
    }

    @Override
    public void lade(String ladung) {
        this.ladung = ladung;        
    }

    @Override
    public String pruefeLadung() {
        return this.ladung;
    }




}
