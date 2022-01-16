package es.josemasaborido.FirstCommit.services;

import es.josemasaborido.FirstCommit.entities.Alumno;
import es.josemasaborido.FirstCommit.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Proyecto First Commit
 * Servicio de Alumno que implementa los metodos crud.
 *
 * @author josema
 * @version 1.0
 */
@Service
public class AlumnoService implements GenericService<Alumno, Long>{

    //ATRIBUTOS
    @Autowired
    AlumnoRepository alumnoRepository;
    List<Alumno> listaAlumnos;

    //CONTRUCTORES

    /**
     * Consutrctor con parametros
     * @param alumnoRepository Repositorio de Alumno
     */
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
        this.listaAlumnos = new ArrayList<>();
        this.listaAlumnos = this.alumnoRepository.findAll();
    }

    //METODOS

    /**
     * Metodo que busca en persistencia un alumno por id de alumno
     * @param id del alumno
     * @return el objeto alumno si todo_ es correcto y null si no lo encuentra
     */
    @Override
    public Alumno findById(Long id) {
        if(this.existByid(id)){
            return alumnoRepository.findById(id).get();
        }
        return null;
    }

    /**
     * Metodo que devuelve todos los alumnos de la base datos
     * @return Lista con todos los alumnos
     */
    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    /**
     * Metodo que guarda un alumno en persistencia. Se comprueba que el correo del alumno no exista
     * para comprobar que el alumno ya existe en la base de datos
     * @param alumno objeto alumno pasado por parametro
     * @return objeto alumno si todo_ es correcto
     */
    @Override
    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    /**
     * MEtodo que actualiza los atributos de un alumno en persistencia
     * @param alumno objeto alumno pasado por parametros
     * @return el objeto guardado con las modificaciones
     */
    @Override
    public Alumno update(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    /**
     * Metodo que elimina un alumno de la base de datos por su id
     * @param id del alumno
     * @return
     */
    @Override
    public boolean deleteById(Long id) {
        if(this.existByid(id)){
            alumnoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Metodo que elimina todos los alumnos de la base de datos
     */
    @Override
    public void deleteAll() {
        alumnoRepository.deleteAll();

    }

    /**
     * Metodo que comprueba si un alumno existe por su id
     * @param id del alumno pasado por parametro
     * @return true si existe y false si no existe
     */
    @Override
    public boolean existByid(Long id) {
        if(alumnoRepository.existsById(id)){
            return true;
        }
        return false;
    }

    //GETTER Y SETTER

    public AlumnoRepository getAlumnoRepository() {
        return alumnoRepository;
    }

    public void setAlumnoRepository(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
}
