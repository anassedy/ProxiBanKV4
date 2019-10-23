package ma.jit.entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author GroupeF
 *
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

public class Operation implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private Date dateOperation;
    private double montant;
    @ManyToOne
    @JoinColumn(name="ID_COMPTE_EMETTEUR")
    @JsonIgnore
    private Compte compteEmetteur;
    @ManyToOne
    @JoinColumn(name="ID_COMPTE_RECEPTEUR")
    @JsonIgnore
    private Compte compteRecepteur;
    
    /**
     *  constructeur avec param
     */
    public Operation() {
        super();
    }

    /**
     * @return
     */
    public Long getNumero() {
        return numero;
    }
    /**
     * @param numero
     */
    public void setNumero(Long numero) {
        this.numero = numero;
    }
    /**
     * @return
     */
    public Date getDateOperation() {
        return dateOperation;
    }
    /**
     * @param dateOperation
     */
    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }
    /**
     * @return
     */
    public double getMontant() {
        return montant;
    }
    /**
     * @param montant
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

	/**
	 * @return
	 */
	public Compte getCompteEmetteur() {
		return compteEmetteur;
	}

	/**
	 * @param compteEmetteur
	 */
	public void setCompteEmetteur(Compte compteEmetteur) {
		this.compteEmetteur = compteEmetteur;
	}

	/**
	 * @return
	 */
	public Compte getCompteRecepteur() {
		return compteRecepteur;
	}

	/**
	 * @param compteRecepteur
	 */
	public void setCompteRecepteur(Compte compteRecepteur) {
		this.compteRecepteur = compteRecepteur;
	}

	/** constructeur avec param
	 * @param dateOperation
	 * @param montant
	 * @param compteEmetteur
	 * @param compteRecepteur
	 */
	public Operation(Date dateOperation, double montant, Compte compteEmetteur, Compte compteRecepteur) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compteEmetteur = compteEmetteur;
		this.compteRecepteur = compteRecepteur;
	}

    
    
    
}
