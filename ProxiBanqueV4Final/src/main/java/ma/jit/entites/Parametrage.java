package ma.jit.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author GroupeF
 *
 */
@Entity
public class Parametrage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double commission;
	private boolean graphe;
	private int nombreMaxClient;
	private int nombreMaxConseiller;
	
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
	public double getCommission() {
		return commission;
	}
	/**
	 * @param commission
	 */
	public void setCommission(double commission) {
		this.commission = commission;
	}
	/**
	 * @return
	 */
	public boolean isGraphe() {
		return graphe;
	}
	/**
	 * @param graphe
	 */
	public void setGraphe(boolean graphe) {
		this.graphe = graphe;
	}
	/**
	 * @return
	 */
	public int getNombreMaxClient() {
		return nombreMaxClient;
	}
	/**
	 * @param nombreMaxClient
	 */
	public void setNombreMaxClient(int nombreMaxClient) {
		this.nombreMaxClient = nombreMaxClient;
	}
	/**
	 * @return
	 */
	public int getNombreMaxConseiller() {
		return nombreMaxConseiller;
	}
	/**
	 * @param nombreMaxConseiller
	 */
	public void setNombreMaxConseiller(int nombreMaxConseiller) {
		this.nombreMaxConseiller = nombreMaxConseiller;
	}
	/** constructeur avec param
	 * @param commission
	 * @param graphe
	 * @param nombreMaxClient
	 * @param nombreMaxConseiller
	 */
	public Parametrage(double commission, boolean graphe, int nombreMaxClient, int nombreMaxConseiller) {
		super();
		this.commission = commission;
		this.graphe = graphe;
		this.nombreMaxClient = nombreMaxClient;
		this.nombreMaxConseiller = nombreMaxConseiller;
	}
	/**
	 *  constructeur sans param
	 */
	public Parametrage() {
		super();
	}
	
	
	
}
