package ma.jit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.entites.Client;
import ma.jit.entites.ConseillerClient;
import ma.jit.spring.dao.IClientRepository;
import ma.jit.spring.dao.IConseillerRepository;


/**
 * @author GroupeF
 *
 */
@Service
public class GerantService implements IGerantService {
	
	/**
	 *   injection de dependance
	 */
	@Autowired
	private IConseillerRepository conseillerRepository;
	/**
	 *   injection de dependance
	 */
	@Autowired
	private IClientRepository clientRepository;

	/**
	 *  method avec param
	 */
	@Override
	public void affecterClient(Long idClient, Long idConseiller) {
		ConseillerClient conseiller = conseillerRepository.findById(idConseiller).get();
        Client client = clientRepository.findById(idClient).get();
        client.getConseiller().getListeClient().remove(client);
        conseiller.getListeClient().add(client);
        client.setConseiller(conseiller);
        clientRepository.save(client);
	}

}
