package de.kaiguenster.javaintro.jpa.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entität für eine Person
 *
 * @author Kai Günster
 */
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Die ID der persistenten Entität
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titel = "";
    private String vorname = "";
    @Column(nullable = false)
    private String nachname = "";

    /**
     * Getter für die ID der Persistenz
     * @return die ID der Persistenz, oder null falls dieses Objekt noch nicht gespeichert ist
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter für die ID der Persistenz
     * @param id die neue ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter für den Vornamen
     * @return den Vornamen
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * Setter für den Vornamen
     * @param vorname der neue Vorname
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**
     * Getter für den Nachnamen
     * @return den Nachnamen.
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * Setter für den Nachnamen
     * @param nachname der neue Nachnamen
     */ 
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    /**
     * Getter für den Titel der Person (Dr., Prof., usw.)
     * @return den Titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Setter für den Titel der Person
     * @param titel der neue Titel
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.kaiguenster.javaintro.jpa.persistence.Person[ id=" + id + " ]";
    }

}
