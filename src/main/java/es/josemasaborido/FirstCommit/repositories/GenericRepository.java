package es.josemasaborido.FirstCommit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Proyecto First Commit
 * Interface que hereda de JpaRepository para implementar los metodos CRUD
 * Implementacion Generica
 *
 * @author josema
 * @version 1.0
 */
public interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T,ID> {
}
