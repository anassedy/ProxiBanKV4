package ma.jit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.entites.Client;
import ma.jit.service.IClientService;

/**
 * @author GroupeF
 *
 */
@CrossOrigin
@RestController
public class ClientRest {
	
	/**
	 *  injection de dependance
	 */
	@Autowired
	private IClientService clientService;
	
	/** methode avec param
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
	public Client findClient(@PathVariable Long id) {
		
		return clientService.findClient(id);
	}
	
	/** method avec param
	 * @return
	 */
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> getAllClient() {
		
		return clientService.getAllClient();
	}
	/** method avec param
	 * @param client
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/client/{id}",method = RequestMethod.POST)
	public Client addClient(@RequestBody Client client,@PathVariable Long id) {
		
		return clientService.addClient(id,client);
	}
	
	/** methode avec param
	 * @param id
	 */
	@RequestMapping(value = "/client/{id}" , method = RequestMethod.DELETE)
	public void deleteClient(@PathVariable Long id) {
		
		clientService.deleteClient(id);
	}
	
	/** method avec param
	 * @param id
	 * @param client
	 * @return
	 */
	@RequestMapping(value = "/client/{id}", method = RequestMethod.PUT)
	public Client updateClient(@PathVariable Long id,@RequestBody Client client) {
		
		return clientService.updateClient(id,client);
	}
	/** method avec param
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/clientbycc/{id}", method = RequestMethod.GET)
	public List<Client>getClientByCc(@PathVariable Long id){
		
		return clientService.getClientByCc(id);
	}

}
