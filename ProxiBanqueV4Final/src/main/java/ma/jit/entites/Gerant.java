package ma.jit.entites;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * @author GroupeF
 *
 */
@Entity
@DiscriminatorValue("GERANT")
public class Gerant extends Employe {
	

	@JsonIgnore
	@OneToMany(mappedBy = "gerant",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ConseillerClient> listConseiller;
	@OneToOne
	private Agence agence;

	public List<ConseillerClient> getListConseiller() {
		return listConseiller;
	}

	public void setListConseiller(List<ConseillerClient> listConseiller) {
		this.listConseiller = listConseiller;
	}

	/**
	 *  constructeur sans param
	 */
	public Gerant() {

	}


	
	
	

}
