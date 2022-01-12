package es.josemasaborido.FirstCommit.services;

import es.josemasaborido.FirstCommit.repositories.GenericRepository;
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
@Service
public abstract class GenericService <T, ID extends Serializable> {

    //ATRIBUTOS

    private GenericRepository<T, ID> genericRepository;

    //METODOS

    /**
     * Metodo que busca una entidad por el id
     * @param id del objeto  entidad a buscar
     * @return el objeto de la entidad buscada
     */
    public T findById(ID id){
        return (T) genericRepository.findById(id);
    }

    /**
     * Metodo que busca todos los objetos de una entidad
     * @return una lista de objetos de la entidad
     */
    public List<T> findAll(){
        return genericRepository.findAll();
    }

    /**
     * Metodo que guarda en persistencia un objeto entidad
     * @param entity objeto entidad pasada por parametro
     * @return objeto entidad
     */
    public T save(T entity){
        return genericRepository.save(entity);
    }

    /**
     * Metodo que actualiza en persistencia un objeto entidad
     * @param entity objeto entidad pasada por parametro
     * @return objeto entidad
     */
    public T update(T entity){
        return genericRepository.save(entity);
    }

    /**
     * Metodo que elimina de persistencia un objeto entidad
     * @param id id del objeto entidad pasado por parametro
     */
    public void deleteById(ID id){
        genericRepository.deleteById(id);
    }

    /**
     * Metodo que elimina todos los objetos de la entidad en persistencia
     */
    public void deleteAll(){
        genericRepository.deleteAll();
    }

    public boolean existByid(ID id){
        return genericRepository.existsById(id);
    }

    //GETTER Y SETTER


    public GenericRepository<T, ID> getGenericRepository() {
        return genericRepository;
    }

    public void setGenericRepository(GenericRepository<T, ID> genericRepository) {
        this.genericRepository = genericRepository;
    }
}
