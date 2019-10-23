package ma.jit.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Groupe F
 *
 */
/**
 * @author FOLIO 9740M
 *
 */
/**
 * @author FOLIO 9740M
 *
 */
@Entity
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	
	@ManyToOne
	private ConseillerClient conseiller;
	
	@OneToMany(mappedBy = "client" ,fetch = FetchType.LAZY, cascade=CascadeType.ALL )
	private List<Compte> listeCompte = new ArrayList<>();
	
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

	/**
	 * @return
	 */
	public ConseillerClient getConseiller() {
		return conseiller;
	}

	/**
	 * @param conseiller
	 */
	public void setConseiller(ConseillerClient conseiller) {
		this.conseiller = conseiller;
	}

	/**
	 * @return
	 */
	public List<Compte> getListeCompte() {
		return listeCompte;
	}

	/**
	 * @param listeCompte
	 */
	public void setListeCompte(List<Compte> listeCompte) {
		this.listeCompte = listeCompte;
	}

	/** constructeur avec param
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 * @param conseiller
	 * @param listeCompte
	 */
	public Client(String nom, String prenom, String email, String adresse, ConseillerClient conseiller,
			List<Compte> listeCompte) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.conseiller = conseiller;
		this.listeCompte = listeCompte;
	}
	
	/**
	 * @param compte  methode addcompte
	 */
	public void addCompte(Compte compte) {
		listeCompte.add(compte);
		compte.setClient(this);
	}
	

	/** constructeur avec param
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 * @param conseiller
	 */
	public Client(String nom, String prenom, String email, String adresse, ConseillerClient conseiller) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.conseiller = conseiller;
	}

	/**
	 *  constructeur sans param
	 */
	public Client() {
		super();
	}

	/** constructeur avec param
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 */
	public Client(String nom, String prenom, String email, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}

	/** constructeur avec param
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 */
	public Client(Long id, String nom, String prenom, String email, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}
	
	
	
}
