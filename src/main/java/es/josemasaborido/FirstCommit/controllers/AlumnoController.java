package es.josemasaborido.FirstCommit.controllers;

import es.josemasaborido.FirstCommit.entities.Alumno;
import es.josemasaborido.FirstCommit.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Proyecto First Commit
 * Controlador de alumno. Se controlaran las peticiones y respuestas API
 *
 * @author josema
 * @version 1.0
 */
@RestController
public class AlumnoController {
    //ATRIBUTOS

    private static final String API_BASE = "/api/v1";
    @Autowired
    private AlumnoService alumnoService;

    //CONSTRUCTORES

    /**
     * Consutrctor con parametros
     * @param alumnoService sercivio de alumno
     */
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }


    //METODOS

    /**
     * Metodo que busca todos los alumnos en la base de datos
     * @return ResponseEntity con la lista de alumnos
     */
    @GetMapping(API_BASE + "/alumnos")
    public ResponseEntity<List<Alumno>> findAll(){
        return new ResponseEntity<>(alumnoService.findAll(), HttpStatus.OK);
    }

    /**
     * Metodo que busca a un alumno por su id
     * @param id del alumno pasado por parametro
     * @return ResponseEntity con el ususiario  y status OK o null y status NO CONTENT si no lo encuentra
     */
    @GetMapping(API_BASE + "/alumnos/{id}")
    public ResponseEntity<Alumno> findById(@PathVariable("id") Long id){
        if(alumnoService.findById(id) != null){
            return new ResponseEntity<>(alumnoService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    /**
     * Metodo que actualiza los datos de un alumno de la base de datos si lo encuentra por el id
     * @param id del alumno pasado por parametro
     * @param alumno objeto alumno pasado por el body con los datos a actualizar
     * @return ReponseEntity con el alumno si ha actualizado y status CREATED o null y status NOT FOUND si no lo ha
     * podido encontrat
     */
    @PutMapping(API_BASE + "/alumnos/{id}")
    public ResponseEntity<Alumno> update(@PathVariable("id") Long id, @RequestBody Alumno alumno){
        if(alumnoService.existByid(id)){
            return new ResponseEntity<>(alumnoService.save(alumno), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Metodo que crea un alumno en la base de datos si el nombre de alumno no existe en persistencia
     * @param alumno objeto alumno pasado por el body
     * @return ResponseEntity con el objeto alumno creado y status CREATED o null y BAD REQUEST si ya existe el alumno
     * en persistencia
     */
    @PostMapping(API_BASE + "/alumnos")
    public ResponseEntity<Alumno> save(@RequestBody Alumno alumno){
        return new ResponseEntity<>(alumnoService.save(alumno), HttpStatus.CREATED);
    }

    /**
     * Metodo que elimina de la base dedatos todos los alumnos existentes
     * @return ResponseEntity con Status OK si se ha llevado a cabo correctamente y INTERNAL SERVER ERROR si hubo algun problema
     */
    @DeleteMapping(API_BASE + "/alumnos")
    public ResponseEntity<HttpStatus> deleteAll(){
        //Intentaremos realizar el borrado de todos los alumnos de la base de datos
        try{
            alumnoService.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Metodo que elimina un alumno pasandole su id por parametro
     * @param id del alumno pasado por parametro
     * @return ResponseEntity con Status OK si se eliminó, Status INTERNAL SERVER ERROR si hubo algun problema con el
     * borrado y Status NOT FOUND si el alumno no existe en la base de datos
     */
    @DeleteMapping(API_BASE + "/alumnos/{id}")

    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        if(alumnoService.existByid(id)){
            try{
                alumnoService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }catch(Exception e){
                System.err.println(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //GETTER Y SETTER


    public AlumnoService getAlumnoService() {
        return alumnoService;
    }

    public void setAlumnoService(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }
}
