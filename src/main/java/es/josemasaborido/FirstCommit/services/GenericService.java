package es.josemasaborido.FirstCommit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Proyecto First Commit
 * Servicio Generico que implementa los metodos crud. Clase abstracta
 *
 * @author josema
 * @version 1.0
 */

public interface GenericService <T, ID extends Serializable>{

    T findById(ID id);

    List<T> findAll();

    T save(T entity);

   T update(T entity);

    boolean deleteById(ID id);

    void deleteAll();

    boolean existByid(ID id);

}
