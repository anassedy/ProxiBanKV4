package ma.jit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.entites.Parametrage;
import ma.jit.spring.dao.IParametrageRepository;

/**
 * @author GroupeF
 *
 */
@Service
public class ParametrageService implements IParametrageService {
	
	/**
	 *  injection de dependance
	 */
	@Autowired
	private IParametrageRepository parametrageRepository;

	/**
	 * method avec param
	 */
	@Override
	public Parametrage updateParametrage(Long id, Parametrage parametrage) {
		parametrage.setId(id);
		return parametrageRepository.save(parametrage);
	}

	/**
	 * method avec param
	 */
	@Override
	public Parametrage getParametrage(Long id) {
		
		return parametrageRepository.findById(id).get();
	}
	
		
	

}
