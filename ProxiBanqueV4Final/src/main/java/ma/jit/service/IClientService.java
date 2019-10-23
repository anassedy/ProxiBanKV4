package ma.jit.service;

import java.util.List;

import ma.jit.entites.Client;

/**
 * @author GroupeF
 *
 */
public interface IClientService {

	public Client addClient(Long id,Client client);
	public void deleteClient(Long id);
	public List<Client> getAllClient();
	public Client updateClient(Long id, Client client);
	public Client findClient(Long id);
	public List<Client>getClientByCc(Long id);
}
