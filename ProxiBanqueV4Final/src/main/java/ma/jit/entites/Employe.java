package ma.jit.entites;

import javax.persistence.*;

/**
 * @author GroupeF
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;

    /**
     *  constructeur sans param
     */
    public Employe() {
    }

    /** constructeur avec param
     * @param nom
     * @param prenom
     * @param email
     * @param adresse
     */
    public Employe(String nom, String prenom, String email, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
    }

    /**
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
