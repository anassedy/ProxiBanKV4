package ma.jit.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entites.Operation;

/**
 * @author GroupeF
 *
 */
public interface IOperationRepository extends JpaRepository<Operation, Long> {

}
