package ma.jit.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ma.jit.entites.Client;
import ma.jit.entites.Compte;
import ma.jit.entites.CompteCourant;
import ma.jit.entites.ConseillerClient;
import ma.jit.entites.Parametrage;
import ma.jit.spring.dao.IClientRepository;
import ma.jit.spring.dao.ICompteRepository;
import ma.jit.spring.dao.IConseillerRepository;
import ma.jit.spring.dao.IParametrageRepository;

/**
 * @author GroupeF
 *
 */
@Service
public class ClientService implements IClientService {
	
	/**
	 *  injection de dependance
	 */
	@Autowired
	private IClientRepository clientRepository;
	/**
	 *  injection de dependance
	 */
	@Autowired
	private ICompteRepository compteRepository;
	/**
	 *  injection de dependance
	 */
	@Autowired
	private IParametrageRepository parametrageRepository;
	/**
	 *  injection de dependance
	 */
	@Autowired
	private IConseillerRepository conseillerRepository;

	
	/**
	 * method avec param
	 */
	@Override
	public Client addClient(Long id,Client client) {
		Parametrage parametrage = parametrageRepository.findById(1L).get();
		ConseillerClient conseiller = conseillerRepository.findById(id).get();
		if(conseiller.getListeClient().size() < parametrage.getNombreMaxClient() ) {
		Compte compte = new CompteCourant();
		compte.setSolde(20);
		compte.setDateCreation(new Date());
		client.addCompte(compte);
		client.setConseiller(conseiller);
		return clientRepository.save(client);
	}
		else {
			return client;
		} }

	/** 
	 * method avec param
	 */
	@Override
	public void deleteClient(Long id) {
		
		clientRepository.deleteById(id);
	}

	/**
	 * method avec param
	 */
	@Override

	public List<Client> getAllClient() {
		
		return clientRepository.findAll();
	}

	/**
	 * method avec param
	 */
	@Override
	public Client updateClient(Long id, Client client) {
		
		client.setId(id);
		return clientRepository.save(client);
	}

	/**
	 * method avec param
	 */
	@Override

	public Client findClient(Long id) {
		
		return clientRepository.findById(id).get();
	}

	/**
	 * method avec param
	 */
	public List<Client>getClientByCc(Long id){
		
		return conseillerRepository.findById(id).get().getListeClient();
		
	}
	
	
}
