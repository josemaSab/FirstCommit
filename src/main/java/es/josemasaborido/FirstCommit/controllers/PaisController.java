package es.josemasaborido.FirstCommit.controllers;

import es.josemasaborido.FirstCommit.entities.Pais;
import es.josemasaborido.FirstCommit.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Proyecto First Commit
 * Controlador de pais. Se controlaran las peticiones y respuestas API
 *
 * @author josema
 * @version 1.0
 */
@RestController
public class PaisController {
    
    //ATRIBUTOS

    private static final String API_BASE = "/api/v1";
    @Autowired
    private PaisService paisService;

    //CONSTRUCTORES

    /**
     * Consutrctor con parametros
     * @param paisService sercivio de pais
     */
    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }


    //METODOS

    /**
     * Metodo que busca todos los paiss en la base de datos
     * @return ResponseEntity con la lista de paiss
     */
    @GetMapping(API_BASE + "/paises")
    public ResponseEntity<List<Pais>> findAll(){
        return new ResponseEntity<>(paisService.findAll(), HttpStatus.OK);
    }

    /**
     * Metodo que busca a un pais por su id
     * @param id del pais pasado por parametro
     * @return ResponseEntity con el ususiario  y status OK o null y status NO CONTENT si no lo encuentra
     */
    @GetMapping(API_BASE + "/paises/{id}")
    public ResponseEntity<Pais> findById(@PathVariable("id") Long id){
        if(paisService.findById(id) != null){
            return new ResponseEntity<>(paisService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    /**
     * Metodo que actualiza los datos de un pais de la base de datos si lo encuentra por el id
     * @param id del pais pasado por parametro
     * @param pais objeto pais pasado por el body con los datos a actualizar
     * @return ReponseEntity con el pais si ha actualizado y status CREATED o null y status NOT FOUND si no lo ha
     * podido encontrat
     */
    @PutMapping(API_BASE + "/paises/{id}")
    public ResponseEntity<Pais> update(@PathVariable("id") Long id, @RequestBody Pais pais){
        if(paisService.existByid(id)){
            return new ResponseEntity<>(paisService.save(pais), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Metodo que crea un pais en la base de datos si el nombre de pais no existe en persistencia
     * @param pais objeto pais pasado por el body
     * @return ResponseEntity con el objeto pais creado y status CREATED o null y BAD REQUEST si ya existe el pais
     * en persistencia
     */
    @PostMapping(API_BASE + "/paises")
    public ResponseEntity<Pais> save(@RequestBody Pais pais){
        return new ResponseEntity<>(paisService.save(pais), HttpStatus.CREATED);
    }

    /**
     * Metodo que elimina de la base dedatos todos los paiss existentes
     * @return ResponseEntity con Status OK si se ha llevado a cabo correctamente y INTERNAL SERVER ERROR si hubo algun problema
     */
    @DeleteMapping(API_BASE + "/paises")
    public ResponseEntity<HttpStatus> deleteAll(){
        //Intentaremos realizar el borrado de todos los paiss de la base de datos
        try{
            paisService.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Metodo que elimina un pais pasandole su id por parametro
     * @param id del pais pasado por parametro
     * @return ResponseEntity con Status OK si se eliminó, Status INTERNAL SERVER ERROR si hubo algun problema con el
     * borrado y Status NOT FOUND si el pais no existe en la base de datos
     */
    @DeleteMapping(API_BASE + "/paises/{id}")

    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        if(paisService.existByid(id)){
            try{
                paisService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }catch(Exception e){
                System.err.println(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //GETTER Y SETTER


    public PaisService getPaisService() {
        return paisService;
    }

    public void setPaisService(PaisService paisService) {
        this.paisService = paisService;
    }
}
