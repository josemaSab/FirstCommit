package es.josemasaborido.FirstCommit.controllers;

import es.josemasaborido.FirstCommit.entities.Certificacion;
import es.josemasaborido.FirstCommit.services.CertificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Proyecto First Commit
 * Controlador de certificacion. Se controlaran las peticiones y respuestas API
 *
 * @author josema
 * @version 1.0
 */
@RestController
public class CertificacionController {

    //ATRIBUTOS

    private static final String API_BASE = "/api/v1";
    @Autowired
    private CertificacionService certificacionService;

    //CONSTRUCTORES

    /**
     * Consutrctor con parametros
     * @param certificacionService sercivio de certificacion
     */
    public CertificacionController(CertificacionService certificacionService) {
        this.certificacionService = certificacionService;
    }


    //METODOS

    /**
     * Metodo que busca todas las certificaciones en la base de datos
     * @return ResponseEntity con la lista de certificaciones
     */
    @GetMapping(API_BASE + "/certificaciones")
    public ResponseEntity<List<Certificacion>> findAll(){
        return new ResponseEntity<>(certificacionService.findAll(), HttpStatus.OK);
    }

    /**
     * Metodo que busca una certificacion por su id
     * @param id de la certificacion pasada por parametro
     * @return ResponseEntity con la certificacion y status OK o null y status NO CONTENT si no lo encuentra
     */
    @GetMapping(API_BASE + "/certificaciones/{id}")
    public ResponseEntity<Certificacion> findById(@PathVariable("id") Long id){
        if(certificacionService.findById(id) != null){
            return new ResponseEntity<>(certificacionService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    /**
     * Metodo que actualiza los datos de una certificacion de la base de datos si lo encuentra por el id
     * @param id del certificacion pasada por parametro
     * @param certificacion objeto certificacion pasada por el body con los datos a actualizar
     * @return ReponseEntity con la certificacion si ha actualizado y status CREATED o null y status NOT FOUND si no lo ha
     * podido encontrar
     */
    @PutMapping(API_BASE + "/certificaciones/{id}")
    public ResponseEntity<Certificacion> update(@PathVariable("id") Long id, @RequestBody Certificacion certificacion){
        if(certificacionService.existByid(id)){
            return new ResponseEntity<>(certificacionService.save(certificacion), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Metodo que crea una certificacion en la base de datos si el nombre de certificacion no existe en persistencia
     * @param certificacion objeto certificacion pasada por el body
     * @return ResponseEntity con el objeto certificacion creado y status CREATED o null y BAD REQUEST si ya existe el certificacion
     * en persistencia
     */
    @PostMapping(API_BASE + "/certificaciones")
    public ResponseEntity<Certificacion> save(@RequestBody Certificacion certificacion){
        return new ResponseEntity<>(certificacionService.save(certificacion), HttpStatus.CREATED);
    }

    /**
     * Metodo que elimina de la base de datos todos las certificaciones existentes
     * @return ResponseEntity con Status OK si se ha llevado a cabo correctamente y INTERNAL SERVER ERROR si hubo algun problema
     */
    @DeleteMapping(API_BASE + "/certificaciones")
    public ResponseEntity<HttpStatus> deleteAll(){
        //Intentaremos realizar el borrado de todos los certificacions de la base de datos
        try{
            certificacionService.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Metodo que elimina una certificacion pasandole su id por parametro
     * @param id de la certificacion pasado por parametro
     * @return ResponseEntity con Status OK si se eliminó, Status INTERNAL SERVER ERROR si hubo algun problema con el
     * borrado y Status NOT FOUND si la certificacion no existe en la base de datos
     */
    @DeleteMapping(API_BASE + "/certificaciones/{id}")

    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        if(certificacionService.existByid(id)){
            try{
                certificacionService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }catch(Exception e){
                System.err.println(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //GETTER Y SETTER


    public CertificacionService getCertificacionService() {
        return certificacionService;
    }

    public void setCertificacionService(CertificacionService certificacionService) {
        this.certificacionService = certificacionService;
    }
}
