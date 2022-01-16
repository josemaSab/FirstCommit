package es.josemasaborido.FirstCommit.controllers;

import es.josemasaborido.FirstCommit.entities.Alumno;
import es.josemasaborido.FirstCommit.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    AlumnoService alumnoService;

    //CONSTRUCTORES

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }


    //METODOS
    @GetMapping(API_BASE + "/alumnos")
    public ResponseEntity<List<Alumno>> findAll(){
        return new ResponseEntity<>(alumnoService.findAll(), HttpStatus.OK);
    }

    //GETTER Y SETTER


    public AlumnoService getAlumnoService() {
        return alumnoService;
    }

    public void setAlumnoService(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }
}
