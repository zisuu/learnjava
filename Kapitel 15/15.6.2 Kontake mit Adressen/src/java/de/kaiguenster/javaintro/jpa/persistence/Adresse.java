package de.kaiguenster.javaintro.jpa.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entität für eine Adresse.
 *
 * @author Kai Günster
 */
@Entity
public class Adresse {

    /**
     * Die ID der persistenten Entität
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String strasse = "";
    @Column(length = 5)
    private String hausnummer = "";
    @Column(length = 5)
    private String plz = "";
    private String ort = "";

    /**
     * Getter für die ID der Persistenz
     *
     * @return die ID der Persistenz, oder null falls dieses Objekt noch nicht
     * gespeichert ist
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter für die ID der Persistenz
     *
     * @param id die neue ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter für das Feld Straße
     *
     * @return die Straße
     */
    public String getStrasse() {
        return strasse;
    }

    /**
     * Setter für das Feld Straße
     *
     * @param strasse die neue Straße
     */
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    /**
     * Getter für das Feld Hausnummer. Die Nummer ist ein String, um auch
     * Nummern mit Zusätzen (z.B.: 37b) aufnehmen zu können.
     *
     * @return die Hausnummer
     */
    public String getHausnummer() {
        return hausnummer;
    }

    /**
     * Setter für das Feld Hausnummer. Die Nummer ist ein String, um auch
     * Nummern mit Zusätzen (z.B.: 37b) aufnehmen zu können.
     *
     * @param hausnummer die neue Hausnummer, maximale Länge 5 Zeichen
     */
    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    /**
     * Setter für das Feld Postleitzahl.
     *
     * @return die PLZ
     */
    public String getPlz() {
        return plz;
    }

    /**
     * Setter für das Feld Postleitzahl.
     *
     * @param plz die neue PLZ, maximale Länge 5 Zeichen
     */
    public void setPlz(String plz) {
        this.plz = plz;
    }

    /**
     * Getter für das Feld Ort
     * @return den Ort
     */
    public String getOrt() {
        return ort;
    }

    /**
     * Setter für das Feld Ort
     * @param ort der neue Ort
     */
    public void setOrt(String ort) {
        this.ort = ort;
    }
}
