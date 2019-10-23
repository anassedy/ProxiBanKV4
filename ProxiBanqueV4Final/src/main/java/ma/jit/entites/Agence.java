package ma.jit.entites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Groupe F
 *
 */
@Entity
public class Agence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(mappedBy = "agence",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Gerant gerant;
	private String nom;
	private String adresse;
	@OneToOne(mappedBy = "agence",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private CompteAgence compteAgence;
	
	/**
	 * @return getId
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id setId
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return getGerant
	 */
	public Gerant getGerant() {
		return gerant;
	}
	/**
	 * @param gerant set Gerant
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}
	/**
	 * @return GetNom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom SetNom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return Getadresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse setAdresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return getCompteAgence
	 */
	public CompteAgence getCompteAgence() {
		return compteAgence;
	}
	/**
	 * @param compteAgence setCompeAgence
	 */
	public void setCompteAgence(CompteAgence compteAgence) {
		this.compteAgence = compteAgence;
	}
	/** constructeur avec param
	 * @param gerant
	 * @param nom
	 * @param adresse
	 * @param compteAgence
	 */
	public Agence(Gerant gerant, String nom, String adresse, CompteAgence compteAgence) {
		super();
		this.gerant = gerant;
		this.nom = nom;
		this.adresse = adresse;
		this.compteAgence = compteAgence;
	}
	/**
	 *  constructeur sans param
	 */
	public Agence() {
		super();
	}
	
	

}
