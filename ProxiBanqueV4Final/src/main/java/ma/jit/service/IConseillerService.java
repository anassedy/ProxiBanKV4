package ma.jit.service;

import java.util.List;

import ma.jit.entites.ConseillerClient;



/**
 * @author GroupeF
 *
 */
public interface IConseillerService {
	
	public ConseillerClient addConseiller(ConseillerClient conseiller);
	public void deleteConseiller(Long id);
	public List<ConseillerClient> getAllConseiller();
	public ConseillerClient updateConseiller(Long id, ConseillerClient conseiller);
	public ConseillerClient findConseiller(Long id);

}
