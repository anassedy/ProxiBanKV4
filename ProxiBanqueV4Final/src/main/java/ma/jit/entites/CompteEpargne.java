package ma.jit.entites;

import java.util.Date;

import javax.persistence.Entity;

/**
 * @author GroupeF
 *
 */
@Entity
public class CompteEpargne extends Compte {
	
	private double taux = 0.03;

	/**
	 *  constructeur sans param 
	 */
	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @return
	 */
	public double getTaux() {
		return taux;
	}


	/**
	 * @param taux
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}


	/** constructeur avec param
	 * @param dateCreation
	 * @param solde
	 * @param client
	 * @param taux
	 */
	public CompteEpargne( Date dateCreation, double solde, Client client, double taux) {
		super( dateCreation, solde, client);
		this.taux = taux;
	}
	
	
	

}
