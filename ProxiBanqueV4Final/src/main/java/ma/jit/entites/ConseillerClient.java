package ma.jit.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author GroupeF
 *
 */
@Entity
@DiscriminatorValue("CONSEILLER")
public class ConseillerClient extends Employe implements Serializable {
	

	@JsonIgnore
	@OneToMany(mappedBy = "conseiller" , fetch = FetchType.LAZY)
	private List<Client> listeClient;
	
	@ManyToOne
	private Gerant gerant;
	



	/**
	 * @return
	 */
	public List<Client> getListeClient() {
		return listeClient;
	}

	/**
	 * @param listeClient
	 */
	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}

	/**
	 * @return
	 */
	public Gerant getGerant() {
		return gerant;
	}

	/**
	 * @param gerant
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}


	/**
	 *  constructeur sans param
	 */
	public ConseillerClient() {
	}

	/** constructeur avec param
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 */
	public ConseillerClient(String nom, String prenom, String email, String adresse) {
		super(nom, prenom, email, adresse);
	}


	
	

}
