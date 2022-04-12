package de.kaiguenster.javaintro.jpa.persistence;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * Entität für eine Person
 *
 * @author Kai Günster
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Namensteil", 
            query="SELECT p FROM Person p "
                 + "WHERE LOWER(p.vorname) LIKE :name "
                 + "   OR LOWER(p.nachname) LIKE :name"),
    @NamedQuery(name="VorUndNachname", 
            query="SELECT p FROM Person p "
                 + "WHERE p.vorname = :vorname "
                 + "   OR p.nachname = :nachname"),
    @NamedQuery(name="Wohnort",
            query="SELECT p FROM Person p"
                + "  JOIN p.adresse a"
                + " WHERE LOWER(a.ort) LIKE :ort")
     
})
public class Person implements Serializable {
    
    /**
     * Named Query für die Suche nach einem beliebigen Namensteil
     */
    public static final String QUERY_NAMENSTEIL = "Namensteil";
    
    /**
     * Named Query für die Suche nach genauem Vor- oder Nachnamen
     */    
    public static final String QUERY_VOR_UND_NACHNAME = "VorUndNachname";
    
    /**
     * Named Query für die Suche nach dem Wohnort in der aggregierten Adresse
     */    
    public static final String QUERY_WOHNORT = "Wohnort";
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
     * Die Adresse. Da eine Adresse nicht ohne Person existieren kann, dürfen 
     * alle Operationen zur Adresse kaskadieren.
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Adresse adresse = new Adresse();

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

    /**
     * Getter für die aggregierte Adresse
     * @return die Adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Setter für die aggregierte Adresse
     * @param adresse die neue Adresse
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
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
