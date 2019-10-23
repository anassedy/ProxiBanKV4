package ma.jit.rest;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.entites.Parametrage;
import ma.jit.service.IParametrageService;


/**
 * @author GroupeF
 *
 */
@CrossOrigin
@RestController
public class ParametrageRest {
	
	/**
	 *  injection de dependance
	 */
	@Autowired
	private IParametrageService parametrageService;
	
	/** method avec param
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/parametrage/{id}", method = RequestMethod.GET)
	public Parametrage getParametrage(@PathVariable Long id) {
		return parametrageService.getParametrage(id);
	}
	
	/** method avec param
	 * @param id
	 * @param parametrage
	 * @return
	 */
	@RequestMapping(value = "/parametrage/{id}", method = RequestMethod.PUT)
	public Parametrage updateParametrage(@PathVariable Long id,@RequestBody Parametrage parametrage) {
		
		return parametrageService.updateParametrage(id, parametrage);
	}

}
