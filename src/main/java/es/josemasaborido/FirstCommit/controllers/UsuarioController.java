package es.josemasaborido.FirstCommit.controllers;
import es.josemasaborido.FirstCommit.entities.Usuario;
import es.josemasaborido.FirstCommit.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Proyecto First Commit
 * Controlador de usuario. Se controlaran las peticiones y respuestas API
 *
 * @author josema
 * @version 1.0
 */
@RestController
public class UsuarioController {

    //ATRIBUTOS

    private static final String API_BASE = "/api/v1";
    @Autowired
    private UsuarioService usuarioService;

    //CONSTRUCTORES

    /**
     * Consutrctor con parametros
     * @param usuarioService sercivio de usuario
     */
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    //METODOS

    /**
     * Metodo que busca todos los usuarios en la base de datos
     * @return ResponseEntity con la lista de usuarios
     */
    @GetMapping(API_BASE + "/usuarios")
    public ResponseEntity<List<Usuario>> findAll(){
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }

    /**
     * Metodo que busca a un usuario por su id
     * @param id del usuario pasado por parametro
     * @return ResponseEntity con el ususiario  y status OK o null y status NO CONTENT si no lo encuentra
     */
    @GetMapping(API_BASE + "/usuarios/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable("id") Long id){
        if(usuarioService.findById(id) != null){
            return new ResponseEntity<>(usuarioService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    /**
     * Metodo que actualiza los datos de un usuario de la base de datos si lo encuentra por el id
     * @param id del usuario pasado por parametro
     * @param usuario objeto usuario pasado por el body con los datos a actualizar
     * @return ReponseEntity con el usuario si ha actualizado y status CREATED o null y status NOT FOUND si no lo ha
     * podido encontrat
     */
    @PutMapping(API_BASE + "/usuarios/{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        if(usuarioService.existByid(id)){
            return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Metodo que crea un usuario en la base de datos si el nombre de usuario no existe en persistencia
     * @param usuario objeto usuario pasado por el body
     * @return ResponseEntity con el objeto usuario creado y status CREATED o null y BAD REQUEST si ya existe el usuario
     * en persistencia
     */
    @PostMapping(API_BASE + "/usuarios")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
            return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
    }

    /**
     * Metodo que elimina de la base dedatos todos los usuarios existentes
     * @return ResponseEntity con Status OK si se ha llevado a cabo correctamente y INTERNAL SERVER ERROR si hubo algun problema
     */
    @DeleteMapping(API_BASE + "/usuarios")
    public ResponseEntity<HttpStatus> deleteAll(){
        //Intentaremos realizar el borrado de todos los usuarios de la base de datos
        try{
            usuarioService.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Metodo que elimina un usuario pasandole su id por parametro
     * @param id del usuario pasado por parametro
     * @return ResponseEntity con Status OK si se eliminó, Status INTERNAL SERVER ERROR si hubo algun problema con el
     * borrado y Status NOT FOUND si el usuario no existe en la base de datos
     */
    @DeleteMapping(API_BASE + "/usuarios/{id}")

    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        if(usuarioService.existByid(id)){
            try{
                usuarioService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }catch(Exception e){
                System.err.println(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //GETTER Y SETTER


    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
