package ma.jit.service;

import java.util.List;

import ma.jit.entites.Client;
import ma.jit.entites.Compte;
import ma.jit.entites.CompteEpargne;

/**
 * @author GroupeF
 *
 */
public interface ICompteService {
	
	public Compte consulterCompte(Long numCompte);
	public Compte addCompteEpargne(Long id,CompteEpargne compteEpargne);
	public List<Compte> getAllCompte();
	public void supprimerCompte(Long numCompte);
	public boolean virement(long idParametrage,long numCompteA,long numCompteE, long numCompteC, double montant);

}
