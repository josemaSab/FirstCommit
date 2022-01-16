package es.josemasaborido.FirstCommit.services;

import es.josemasaborido.FirstCommit.entities.Pais;
import es.josemasaborido.FirstCommit.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Proyecto First Commit
 * Servicio de Pais que implementa los metodos crud.
 *
 * @author josema
 * @version 1.0
 */
@Service
public class PaisService implements GenericService<Pais, Long>{
    
    //ATRIBUTOS
    @Autowired
    PaisRepository paisRepository;
    List<Pais> listaPaises;

    //CONSTRUCTORES

    /**
     * Consutructor con parametros
     * @param paisRepository repositorio de pais
     */
    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
        this.listaPaises = new ArrayList<>();
        this.listaPaises = this.paisRepository.findAll();
    }


    //METODOS

    /**
     * Metodo que busca en persistencia un pais por id de pais
     * @param id del pais
     * @return el objeto pais si todo_ es correcto y null si no lo encuentra
     */
    @Override
    public Pais findById(Long id) {
        if(this.existByid(id)){
            return paisRepository.findById(id).get();
        }
        return null;
    }

    /**
     * Metodo que devuelve todos los paiss de la base datos
     * @return Lista con todos los paiss
     */
    @Override
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    /**
     * Metodo que guarda un pais en persistencia. Se comprueba que el correo del pais no exista
     * para comprobar que el pais ya existe en la base de datos
     * @param pais objeto pais pasado por parametro
     * @return objeto pais si todo_ es correcto y null si el pais ya existe
     */
    @Override
    public Pais save(Pais pais) {
        for(Pais p: this.listaPaises){
            if(pais.getPais().equals(p.getPais())){
                return null;
            }
        }
        return paisRepository.save(pais);
    }

    /**
     * MEtodo que actualiza los atributos de un pais en persistencia
     * @param pais objeto pais pasado por parametros
     * @return el objeto guardado con las modificaciones
     */
    @Override
    public Pais update(Pais pais) {
        return paisRepository.save(pais);
    }

    /**
     * Metodo que elimina un pais de la base de datos por su id
     * @param id del pais
     * @return
     */
    @Override
    public boolean deleteById(Long id) {
        if(this.existByid(id)){
            paisRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Metodo que elimina todos los paiss de la base de datos
     */
    @Override
    public void deleteAll() {
        paisRepository.deleteAll();

    }

    /**
     * Metodo que comprueba si un pais existe por su id
     * @param id del pais pasado por parametro
     * @return true si existe y false si no existe
     */
    @Override
    public boolean existByid(Long id) {
        if(paisRepository.existsById(id)){
            return true;
        }
        return false;
    }

    //GETTER Y SETTER

    public PaisRepository getPaisRepository() {
        return paisRepository;
    }

    public void setPaisRepository(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public List<Pais> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(List<Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }
}
