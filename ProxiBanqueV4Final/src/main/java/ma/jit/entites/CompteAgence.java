package ma.jit.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author GroupeF
 *
 */
@Entity
public class CompteAgence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numCompte;
	private Date dateCreation;
	private double solde;
	@OneToOne
	private Agence agence;
	
	/**
	 * @return
	 */
	public Long getNumCompte() {
		return numCompte;
	}
	/**
	 * @param numCompte
	 */
	public void setNumCompte(Long numCompte) {
		this.numCompte = numCompte;
	}
	/**
	 * @return
	 */
	public Date getDateCreation() {
		return dateCreation;
	}
	/**
	 * @param dateCreation
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	/**
	 * @return
	 */
	public double getSolde() {
		return solde;
	}
	/**
	 * @param solde
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}
	/**
	 * @return
	 */
	public Agence getAgence() {
		return agence;
	}
	/**
	 * @param agence
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	/** constructeur avec param
	 * @param dateCreation
	 * @param solde
	 * @param agence
	 */
	public CompteAgence(Date dateCreation, double solde, Agence agence) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
		
		this.agence = agence;
	}
	/**
	 *  constructeur sans param
	 */
	public CompteAgence() {
		super();
	}
	
	
	
	

}
