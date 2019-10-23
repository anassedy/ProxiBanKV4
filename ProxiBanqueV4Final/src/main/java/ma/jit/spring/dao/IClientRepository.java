package ma.jit.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entites.Client;

/**
 * @author GroupeF
 *
 */
public interface IClientRepository extends JpaRepository<Client, Long> {

}
