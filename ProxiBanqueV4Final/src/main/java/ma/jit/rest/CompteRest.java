package ma.jit.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.entites.Compte;
import ma.jit.entites.CompteEpargne;
import ma.jit.service.ICompteService;


/**
 * @author GroupeF
 *
 */
@CrossOrigin
@RestController
public class CompteRest {
	
	/**
	 *  injection de dependance
	 */
	@Autowired
	private ICompteService compteService;
	
	/** methode avec param
	 * @param numCompte
	 * @return
	 */
	@RequestMapping(value = "/consulter/{numCompte}",method = RequestMethod.GET)
	public Compte consulterCompte(@PathVariable Long numCompte) {
		return compteService.consulterCompte(numCompte);
	}
	

	
	/** method avec param
	 * @param operation
	 * @return
	 */
	@RequestMapping(value = "/virement" , method = RequestMethod.PUT)
	public boolean virement(@RequestBody HashMap<String, Object> operation) {
		long numCompteEmetteur = (int) operation.get("compte1");
		long numCompteRecepteur = (int) operation.get("compte2");
		long numCompteAgence = (int) operation.get("compteAgence");
		long idParametrage = (int) operation.get("id");
		double montant = (int) operation.get("montant");
		
		return compteService.virement(idParametrage, numCompteAgence, numCompteEmetteur, numCompteRecepteur, montant);
		
	}
	/** methode avec param
	 * @param numCompte
	 */
	@RequestMapping(value = "/compte/{id}", method = RequestMethod.DELETE)
	public void supprimerCompte(@PathVariable Long numCompte) {
		compteService.supprimerCompte(numCompte);
		
	}
	/** methode avec param
	 * @return
	 */
	@RequestMapping(value = "/comptes", method = RequestMethod.GET)
	public List<Compte> getAllCompte() {
		
		return compteService.getAllCompte();
	}
	
	/** method avec param
	 * @param id
	 * @param compteEpargne
	 * @return
	 */
	@RequestMapping(value = "/compte/{id}",method = RequestMethod.POST)
	public Compte addCompteEpargne(@PathVariable Long id,@RequestBody CompteEpargne compteEpargne) {
		return compteService.addCompteEpargne(id, compteEpargne);
	}
}
