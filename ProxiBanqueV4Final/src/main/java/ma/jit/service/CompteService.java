package ma.jit.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.jit.entites.Client;
import ma.jit.entites.Compte;
import ma.jit.entites.CompteAgence;
import ma.jit.entites.CompteCourant;
import ma.jit.entites.CompteEpargne;
import ma.jit.entites.Operation;
import ma.jit.entites.Parametrage;
import ma.jit.spring.dao.IClientRepository;
import ma.jit.spring.dao.ICompteAgenceRepository;
import ma.jit.spring.dao.ICompteRepository;
import ma.jit.spring.dao.IOperationRepository;
import ma.jit.spring.dao.IParametrageRepository;

/**
 * @author GroupeF
 *
 */
@Service
public class CompteService implements ICompteService {
	
	/**
	 *  injection de dependance
	 */
	@Autowired
	private ICompteRepository compteRepository;

	/**
	 *  injection de dependance
	 */
	@Autowired
	private IOperationRepository operationRepository;
	
	/**
	 *  injection de dependance
	 */
	@Autowired
	private ICompteAgenceRepository compteAgenceRepo;
	/**
	 *  injection de dependance
	 */
	@Autowired
	private IClientRepository clientRepository;
	
	/**
	 *  injection de dependance
	 */
	@Autowired
	private IParametrageRepository parametrageRepository;

	/**
	 * method avec param
	 */
	@Override
	public Compte consulterCompte(Long numCompte) {
		
		return compteRepository.findById(numCompte).get();
	}

	/**
	 * method avec param
	 */
	
	@Transactional
	@Override
	public boolean virement(long idParametrage,long numCompteA,long numCompteE, long numCompteC, double montant) {
		
		Compte compteEmetteur =compteRepository.findById(numCompteE).get();
		Compte compteRecepteur =compteRepository.findById(numCompteC).get();
		CompteAgence compteAgence = compteAgenceRepo.findById(numCompteA).get();
		List<Parametrage> parametrage = parametrageRepository.findAll();
		
		Operation operation = new Operation(new Date(), montant, compteEmetteur, compteRecepteur);
		
		double commission = montant * parametrage.get(0).getCommission();
		double montantFinal = montant - commission;
		double soldeEmetteur = compteEmetteur.getSolde();
		double soldeRecepteur = compteRecepteur.getSolde();
		double soldeAgence = compteAgence.getSolde();
		
		compteAgence.setSolde(soldeAgence+commission);
		
		if(compteEmetteur instanceof CompteCourant) {
			
			if(compteEmetteur.getSolde()- montant + ((CompteCourant) compteEmetteur).getDecouvert() > 0) {
				
				compteEmetteur.setSolde(soldeEmetteur - montant);
				compteRecepteur.setSolde(soldeRecepteur + montantFinal);
				compteRepository.save(compteEmetteur);
				compteRepository.save(compteRecepteur);
				compteAgenceRepo.save(compteAgence);
				operationRepository.save(operation);
				
				return true;
			}
		}
		
		else if (compteEmetteur instanceof CompteEpargne) {
			if(compteEmetteur.getSolde() - montant > 0) {
				compteEmetteur.setSolde(soldeEmetteur - montant);
				compteRecepteur.setSolde(soldeRecepteur + montantFinal);
				compteRepository.save(compteEmetteur);
				compteRepository.save(compteRecepteur);
				compteAgenceRepo.save(compteAgence);
				operationRepository.save(operation);
				
				return true;
			}
		}
		
		return false;
		
		
		
		

	}

	/**
	 * method avec param
	 */
	@Override
	public void supprimerCompte(Long numCompte) {
		compteRepository.deleteById(numCompte);
		
	}

	/**
	 * method avec param
	 */
	@Override
	public List<Compte> getAllCompte() {
		
		return compteRepository.findAll();
	}

	/**
	 * method avec param
	 */
	@Override
	public Compte addCompteEpargne(Long id, CompteEpargne compteEpargne) {
		Client client = clientRepository.findById(id).get();
		client.getListeCompte().add(compteEpargne);
		compteEpargne.setDateCreation(new Date());
		compteEpargne.setClient(client);
		return compteRepository.save(compteEpargne);
	}
}
