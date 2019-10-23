package ma.jit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.entites.ConseillerClient;
import ma.jit.service.IConseillerService;


/**
 * @author GroupeF
 *
 */
@CrossOrigin
@RestController
public class ConseillerRest {
	
	/**
	 *  injection de dependance
	 */
	@Autowired
	private IConseillerService conseillerService;
	
	
	/** method avec param
	 * @param conseiller
	 * @return
	 */
	@RequestMapping(value = "/conseiller", method = RequestMethod.POST)
	public ConseillerClient addConseiller(@RequestBody ConseillerClient conseiller) {
		return conseillerService.addConseiller(conseiller);
	}
	
	/** method avec param
	 * @param id
	 */
	@RequestMapping(value = "/conseiller/{id}" , method = RequestMethod.DELETE)
	public void deleteConseiller(@PathVariable Long id) {
		
		conseillerService.deleteConseiller(id);
	}
	
	/** method avec param
	 * @return
	 */
	@RequestMapping(value = "/conseillers", method = RequestMethod.GET)
	public List<ConseillerClient> getAllConseiller() {
		
		return conseillerService.getAllConseiller();
	}
	
	/** method avec param
	 * @param id
	 * @param conseiller
	 * @return
	 */
	@RequestMapping(value = "/conseiller/{id}", method = RequestMethod.PUT)
	public ConseillerClient updateConseiller(@PathVariable Long id,@RequestBody ConseillerClient conseiller) {
		conseiller.setId(id);
		return conseillerService.updateConseiller(id, conseiller);
	}
	
	/** method avec param
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/conseiller/{id}",method = RequestMethod.GET)
	public ConseillerClient findConseiller(@PathVariable Long id) {
		return conseillerService.findConseiller(id);
	}

}
