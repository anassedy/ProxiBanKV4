package ma.jit.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author GroupeF
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE")
public abstract class Compte implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numCompte;
	private Date dateCreation;
	private double solde;
	@JsonIgnore
	@ManyToOne
	private Client client;
	@OneToMany(mappedBy = "compteRecepteur" ,fetch = FetchType.LAZY)
	private Collection<Operation> debits;
	
	@OneToMany(mappedBy = "compteEmetteur" ,fetch = FetchType.LAZY)
	private Collection<Operation> credit;
	
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
	public Client getClient() {
		return client;
	}
	/**
	 * @param client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	
	/**
	 * @return
	 */
	public Collection<Operation> getDebits() {
		return debits;
	}
	/**
	 * @param debits
	 */
	public void setDebits(Collection<Operation> debits) {
		this.debits = debits;
	}
	/**
	 * @return
	 */
	public Collection<Operation> getCredit() {
		return credit;
	}
	/**
	 * @param credit
	 */
	public void setCredit(Collection<Operation> credit) {
		this.credit = credit;
	}
	/** constructeur avec param
	 * @param dateCreation
	 * @param solde
	 * @param client
	 */
	public Compte(Date dateCreation, double solde, Client client) {
		super();
		
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;

	}
	/** constructeur sans param
	 * 
	 */
	public Compte() {
		super();
	}
	
	

}
