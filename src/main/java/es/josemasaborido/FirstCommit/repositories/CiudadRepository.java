package es.josemasaborido.FirstCommit.repositories;

import es.josemasaborido.FirstCommit.entities.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Proyecto First Commit
 * Interface que hereda de JpaRepository para implementar los metodos CRUD

 *
 * @author josema
 * @version 1.0
 */
@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
}
