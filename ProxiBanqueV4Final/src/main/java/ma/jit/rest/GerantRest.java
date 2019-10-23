package ma.jit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.service.IGerantService;

/**
 * @author GroupeF
 *
 */
@RestController
public class GerantRest {
	/**
	 *  injection de dependance
	 */
	@Autowired
	private IGerantService gerantService;
	/** method avec param
	 * @param idClient
	 * @param idConseiller
	 */
	@RequestMapping(value = "/affecterclient/{idClient}/{idConseiller}", method = RequestMethod.PUT)
	public void affecterClient(@PathVariable Long idClient,@PathVariable Long idConseiller) {
		gerantService.affecterClient(idClient, idConseiller);
	}

}
