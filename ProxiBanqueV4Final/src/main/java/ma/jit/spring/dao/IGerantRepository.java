package ma.jit.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entites.Gerant;

/**
 * @author GroupeF
 *
 */
public interface IGerantRepository extends JpaRepository<Gerant, Long> {

}
