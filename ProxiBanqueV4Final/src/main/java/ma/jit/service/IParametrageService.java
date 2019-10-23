package ma.jit.service;

import ma.jit.entites.Parametrage;

/**
 * @author GroupeF
 *
 */
public interface IParametrageService {
	
	public Parametrage updateParametrage(Long id,Parametrage parametrage);
	public Parametrage getParametrage(Long id);
	

}
