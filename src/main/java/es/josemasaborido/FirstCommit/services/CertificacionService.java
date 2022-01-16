package es.josemasaborido.FirstCommit.services;

import es.josemasaborido.FirstCommit.entities.Certificacion;
import es.josemasaborido.FirstCommit.repositories.CertificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Proyecto First Commit
 * Servicio de Certificacion que implementa los metodos crud.
 *
 * @author josema
 * @version 1.0
 */
@Service
public class CertificacionService implements  GenericService<Certificacion, Long> {

    //ATRIBUTOS
    @Autowired
    CertificacionRepository certificacionRepository;
    List<Certificacion> listaCertificaciones;

    //CONSTRUCTORES

    /**
     * Consutructor con parametros
     * @param certificacionRepository repositorio de certificacion
     */
    public CertificacionService(CertificacionRepository certificacionRepository) {
        this.certificacionRepository = certificacionRepository;
        this.listaCertificaciones = new ArrayList<>();
        this.listaCertificaciones = this.certificacionRepository.findAll();
    }


    //METODOS

    /**
     * Metodo que busca en persistencia una certificacion por id de certificacion
     * @param id del certificacion
     * @return el objeto certificacion si todo_ es correcto y null si no la encuentra
     */
    @Override
    public Certificacion findById(Long id) {
        if(this.existByid(id)){
            return certificacionRepository.findById(id).get();
        }
        return null;
    }

    /**
     * Metodo que devuelve todas las certificacions de la base datos
     * @return Lista con todas las certificacions
     */
    @Override
    public List<Certificacion> findAll() {
        return certificacionRepository.findAll();
    }

    /**
     * Metodo que guarda un certificacion en persistencia. Se comprueba que el correo del certificacion no exista
     * para comprobar que la certificacion ya existe en la base de datos
     * @param certificacion objeto certificacion pasado por parametro
     * @return objeto certificacion si todo_ es correcto y null si la certificacion ya existe
     */
    @Override
    public Certificacion save(Certificacion certificacion) {
        for(Certificacion c: this.listaCertificaciones){
            if(certificacion.getCertificacion().equals(c.getCertificacion())){
                return null;
            }
        }
        return certificacionRepository.save(certificacion);
    }

    /**
     * MEtodo que actualiza los atributos de un certificacion en persistencia
     * @param certificacion objeto certificacion pasado por parametros
     * @return el objeto guardado con las modificaciones
     */
    @Override
    public Certificacion update(Certificacion certificacion) {
        return certificacionRepository.save(certificacion);
    }

    /**
     * Metodo que elimina un certificacion de la base de datos por su id
     * @param id de la certificacion
     * @return
     */
    @Override
    public boolean deleteById(Long id) {
        if(this.existByid(id)){
            certificacionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Metodo que elimina todas las certificacions de la base de datos
     */
    @Override
    public void deleteAll() {
        certificacionRepository.deleteAll();

    }

    /**
     * Metodo que comprueba si un certificacion existe por su id
     * @param id de la certificacion pasado por parametro
     * @return true si existe y false si no existe
     */
    @Override
    public boolean existByid(Long id) {
        if(certificacionRepository.existsById(id)){
            return true;
        }
        return false;
    }

    //GETTER Y SETTER

    public CertificacionRepository getCertificacionRepository() {
        return certificacionRepository;
    }

    public void setCertificacionRepository(CertificacionRepository certificacionRepository) {
        this.certificacionRepository = certificacionRepository;
    }

    public List<Certificacion> getListaCertificaciones() {
        return listaCertificaciones;
    }

    public void setListaCertificaciones(List<Certificacion> listaCertificacions) {
        this.listaCertificaciones = listaCertificacions;
    }   
}
