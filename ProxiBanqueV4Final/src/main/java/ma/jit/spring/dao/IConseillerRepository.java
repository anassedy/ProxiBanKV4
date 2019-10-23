package ma.jit.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entites.ConseillerClient;

/**
 * @author GroupeF
 *
 */
public interface IConseillerRepository extends JpaRepository<ConseillerClient, Long> {

}
