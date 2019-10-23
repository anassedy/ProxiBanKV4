package ma.jit.entites;

import java.util.Date;

import javax.persistence.Entity;

/**
 * @author GroupeF
 *
 */
@Entity
public class CompteCourant extends Compte {
	
	private double decouvert = 1000;

	/**
	 * constructeur sans param
	 */
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** constructeur avec param
	 * @param decouvert
	 */
	public CompteCourant(double decouvert) {
		super();
		this.decouvert = decouvert;
	}

	/** constructeur avec param
	 * @param dateCreation
	 * @param solde
	 * @param client
	 * @param decouvert
	 */
	public CompteCourant( Date dateCreation, double solde, Client client, double decouvert) {
		super( dateCreation, solde, client);
		this.decouvert = decouvert;
	}

	/**
	 * @return
	 */
	public double getDecouvert() {
		return decouvert;
	}

	/**
	 * @param decouvert
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	
	
	

}
