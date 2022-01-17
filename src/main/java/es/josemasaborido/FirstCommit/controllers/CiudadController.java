package es.josemasaborido.FirstCommit.controllers;

import es.josemasaborido.FirstCommit.entities.Ciudad;
import es.josemasaborido.FirstCommit.services.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * Proyecto First Commit
 * Controlador de ciudad. Se controlaran las peticiones y respuestas API
 *
 * @author josema
 * @version 1.0
 */
@RestController
public class CiudadController {
    
    //ATRIBUTOS

    private static final String API_BASE = "/api/v1";
    @Autowired
    private CiudadService ciudadService;

    //CONSTRUCTORES

    /**
     * Consutrctor con parametros
     * @param ciudadService sercivio de ciudad
     */
    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }


    //METODOS

    /**
     * Metodo que busca todas las ciudades en la base de datos
     * @return ResponseEntity con la lista de ciudades
     */
    @GetMapping(API_BASE + "/ciudades")
    public ResponseEntity<List<Ciudad>> findAll(){
        return new ResponseEntity<>(ciudadService.findAll(), HttpStatus.OK);
    }

    /**
     * Metodo que busca una ciudad por su id
     * @param id de la ciudad pasada por parametro
     * @return ResponseEntity con la ciudad y status OK o null y status NO CONTENT si no lo encuentra
     */
    @GetMapping(API_BASE + "/ciudades/{id}")
    public ResponseEntity<Ciudad> findById(@PathVariable("id") Long id){
        if(ciudadService.findById(id) != null){
            return new ResponseEntity<>(ciudadService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    /**
     * Metodo que actualiza los datos de una ciudad de la base de datos si lo encuentra por el id
     * @param id del ciudad pasada por parametro
     * @param ciudad objeto ciudad pasada por el body con los datos a actualizar
     * @return ReponseEntity con la ciudad si ha actualizado y status CREATED o null y status NOT FOUND si no lo ha
     * podido encontrar
     */
    @PutMapping(API_BASE + "/ciudades/{id}")
    public ResponseEntity<Ciudad> update(@PathVariable("id") Long id, @RequestBody Ciudad ciudad){
        if(ciudadService.existByid(id)){
            return new ResponseEntity<>(ciudadService.save(ciudad), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Metodo que crea una ciudad en la base de datos si el nombre de ciudad no existe en persistencia
     * @param ciudad objeto ciudad pasada por el body
     * @return ResponseEntity con el objeto ciudad creado y status CREATED o null y BAD REQUEST si ya existe el ciudad
     * en persistencia
     */
    @PostMapping(API_BASE + "/ciudades")
    public ResponseEntity<Ciudad> save(@RequestBody Ciudad ciudad){
        return new ResponseEntity<>(ciudadService.save(ciudad), HttpStatus.CREATED);
    }

    /**
     * Metodo que elimina de la base de datos todos las ciudades existentes
     * @return ResponseEntity con Status OK si se ha llevado a cabo correctamente y INTERNAL SERVER ERROR si hubo algun problema
     */
    @DeleteMapping(API_BASE + "/ciudades")
    public ResponseEntity<HttpStatus> deleteAll(){
        //Intentaremos realizar el borrado de todos los ciudads de la base de datos
        try{
            ciudadService.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Metodo que elimina una ciudad pasandole su id por parametro
     * @param id de la ciudad pasado por parametro
     * @return ResponseEntity con Status OK si se eliminó, Status INTERNAL SERVER ERROR si hubo algun problema con el
     * borrado y Status NOT FOUND si la ciudad no existe en la base de datos
     */
    @DeleteMapping(API_BASE + "/ciudades/{id}")

    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        if(ciudadService.existByid(id)){
            try{
                ciudadService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }catch(Exception e){
                System.err.println(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //GETTER Y SETTER


    public CiudadService getCiudadService() {
        return ciudadService;
    }

    public void setCiudadService(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }
}
