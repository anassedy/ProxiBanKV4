package ma.jit.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entites.Compte;

/**
 * @author GroupeF
 *
 */
public interface ICompteRepository extends JpaRepository<Compte, Long> {

}
