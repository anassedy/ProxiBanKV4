package ma.jit.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entites.CompteAgence;

/**
 * @author GroupeF
 *
 */
public interface ICompteAgenceRepository extends JpaRepository<CompteAgence, Long> {

}
