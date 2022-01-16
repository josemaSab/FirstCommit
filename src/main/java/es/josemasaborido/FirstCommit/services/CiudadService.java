package es.josemasaborido.FirstCommit.services;

import es.josemasaborido.FirstCommit.entities.Ciudad;
import es.josemasaborido.FirstCommit.repositories.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Proyecto First Commit
 * Servicio de Ciudad que implementa los metodos crud.
 *
 * @author josema
 * @version 1.0
 */
@Service
public class CiudadService implements GenericService<Ciudad, Long>{
    //ATRIBUTOS
    @Autowired
    CiudadRepository ciudadRepository;
    List<Ciudad> listaCiudades;

    //CONSTRUCTORES

    /**
     * Consutructor con parametros
     * @param ciudadRepository repositorio de ciudad
     */
    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
        this.listaCiudades = new ArrayList<>();
        this.listaCiudades = this.ciudadRepository.findAll();
    }


    //METODOS

    /**
     * Metodo que busca en persistencia un ciudad por id de ciudad
     * @param id de la ciudad
     * @return el objeto ciudad si todo_ es correcto y null si no la encuentra
     */
    @Override
    public Ciudad findById(Long id) {
        if(this.existByid(id)){
            return ciudadRepository.findById(id).get();
        }
        return null;
    }

    /**
     * Metodo que devuelve todos los ciudads de la base datos
     * @return Lista con todos los ciudads
     */
    @Override
    public List<Ciudad> findAll() {
        return ciudadRepository.findAll();
    }

    /**
     * Metodo que guarda un ciudad en persistencia. Se comprueba que el nombre de la ciudad no exista
     * para comprobar que la ciudad ya existe en la base de datos
     * @param ciudad objeto ciudad pasado por parametro
     * @return objeto ciudad si todo_ es correcto y null si la ciudad ya existe
     */
    @Override
    public Ciudad save(Ciudad ciudad) {
        for(Ciudad c: this.listaCiudades){
            if(ciudad.getCiudad().equals(c.getCiudad())){
                return null;
            }
        }
        return ciudadRepository.save(ciudad);
    }

    /**
     * MEtodo que actualiza los atributos de una ciudad en persistencia
     * @param ciudad objeto ciudad pasado por parametros
     * @return el objeto guardado con las modificaciones
     */
    @Override
    public Ciudad update(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    /**
     * Metodo que elimina una ciudad de la base de datos por su id
     * @param id de la ciudad
     * @return
     */
    @Override
    public boolean deleteById(Long id) {
        if(this.existByid(id)){
            ciudadRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Metodo que elimina todas las ciudades de la base de datos
     */
    @Override
    public void deleteAll() {
        ciudadRepository.deleteAll();

    }

    /**
     * Metodo que comprueba si una ciudad existe por su id
     * @param id de la ciudad pasado por parametro
     * @return true si existe y false si no existe
     */
    @Override
    public boolean existByid(Long id) {
        if(ciudadRepository.existsById(id)){
            return true;
        }
        return false;
    }

    //GETTER Y SETTER

    public CiudadRepository getCiudadRepository() {
        return ciudadRepository;
    }

    public void setCiudadRepository(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    public List<Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(List<Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }
}
