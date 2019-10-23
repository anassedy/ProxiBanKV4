package ma.jit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ma.jit.entites.ConseillerClient;
import ma.jit.entites.Gerant;
import ma.jit.entites.Parametrage;
import ma.jit.entites.User;
import ma.jit.spring.dao.IConseillerRepository;
import ma.jit.spring.dao.IGerantRepository;
import ma.jit.spring.dao.IParametrageRepository;
import ma.jit.spring.dao.UserRepository;

/**
 * @author GroupeF
 *
 */
@Service
public class ConseillerService implements IConseillerService {

	/**
	 *   injection de dependance
	 */
	@Autowired
	private IConseillerRepository conseillerRepository;
	
	/**
	 *   injection de dependance
	 */
	@Autowired
	private IParametrageRepository parametrageRepository;
	/**
	 *   injection de dependance
	 */
	@Autowired
	private IGerantRepository gerantRepository;
	/**
	 *  injection de dependance
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;
	/**
	 *  injection de dependance
	 */
	@Autowired
	private UserRepository userRepository;
	
	/**
	 *  method avec param
	 */
	@Override
	public ConseillerClient addConseiller(ConseillerClient conseiller) {
		ConseillerClient cc = conseiller;
		User user = new User(cc.getNom(),passwordEncoder.encode(cc.getNom()), "CONSEILLER","");
		user.setEmploye(conseiller);
		userRepository.save(user);
		Parametrage parametrage =  parametrageRepository.findById(1L).get();
		List<Gerant> gerants =  gerantRepository.findAll();
		Gerant gerant = gerants.get(0);
		if(conseillerRepository.findAll().size()+1 < parametrage.getNombreMaxConseiller()) {
			conseiller.setGerant(gerant);
			
		return conseillerRepository.save(conseiller);
		}else {
			return conseiller;
		} 
	}

	/**
	 * method avec param
	 */
	@Override
	public void deleteConseiller(Long id) {
		
		conseillerRepository.deleteById(id);
	}

	/**
	 * method avec param
	 */
	@Override
	public List<ConseillerClient> getAllConseiller() {
		
		return conseillerRepository.findAll();
	}

	/**
	 * method avec param
	 */
	@Override
	public ConseillerClient updateConseiller(Long id, ConseillerClient conseiller) {
		conseiller.setId(id);
		List<Gerant> gerants =  gerantRepository.findAll();
		Gerant gerant = gerants.get(0);
		conseiller.setGerant(gerant);
		return conseillerRepository.save(conseiller);
	}

	/** 
	 * method avec param
	 */
	@Override
	public ConseillerClient findConseiller(Long id) {
		return conseillerRepository.findById(id).get();
	}

}
