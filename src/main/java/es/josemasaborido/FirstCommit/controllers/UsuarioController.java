package es.josemasaborido.FirstCommit.controllers;

import es.josemasaborido.FirstCommit.entities.Usuario;
import es.josemasaborido.FirstCommit.services.GenericService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    private final GenericService<Usuario, Long> genericService;

    //CONSTRUCTORES

    public UsuarioController(GenericService<Usuario, Long> genericService) {
        this.genericService = genericService;
    }

    //METODOS

    /**
     * Metodo que busca todos los usuarios en la base de datos
     * @return ResponseEntity con la lista de usuarios
     */
    @GetMapping(API_BASE + "/usuarios")
    @ApiOperation("Busca todos los usuarios en la base de datos")
    public ResponseEntity<List<Usuario>> findAll(){
        return new ResponseEntity<>(genericService.findAll(), HttpStatus.OK);
    }

    /**
     * Metodo que busca a un usuario por su id
     * @param id del usuario pasado por parametro
     * @return ResponseEntity con el ususiario  y status OK o null y status NO CONTENT si no lo encuentra
     */
    @GetMapping(API_BASE + "/usuarios/{id}")
    @ApiOperation("Busca un usuario por su id pasada por parametro")
    public ResponseEntity<Usuario> findById(@ApiParam("Clave primaria") @PathVariable("id") Long id){
        if(genericService.existByid(id)){
            return new ResponseEntity<>(genericService.findById(id), HttpStatus.OK);
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
    @ApiOperation("Actualiza un usuario por su id")
    public ResponseEntity<Usuario> update(@ApiParam("Clave primaria") @PathVariable("id") Long id,
                                          @ApiParam("Atributos de usuario pasados por Json en el body") @RequestBody Usuario usuario){
        if(genericService.existByid(id)){
            return new ResponseEntity<>(genericService.save(usuario), HttpStatus.CREATED);
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
    @ApiOperation("Crea un usuario en la base de datos")
    public ResponseEntity<Usuario> save(@ApiParam("Atributos pasados por Json en el body") @RequestBody Usuario usuario){
        List<Usuario> listaUsuarios = genericService.findAll();
        for(Usuario u: listaUsuarios){
            if(usuario.getNombreUsuario().equals(u.getNombreUsuario())){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(genericService.save(usuario), HttpStatus.CREATED);
    }

    /**
     * Metodo que elimina de la base dedatos todos los usuarios existentes
     * @return ResponseEntity con Status OK si se ha llevado a cabo correctamente y INTERNAL SERVER ERROR si hubo algun problema
     */
    @DeleteMapping(API_BASE + "/usuarios")
    @ApiOperation("Elimina todos los usuarios de la base de datos")
    public ResponseEntity<HttpStatus> deleteAll(){
        //Intentaremos realizar el borrado de todos los usuarios de la base de datos
        try{
            genericService.deleteAll();
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
    @ApiOperation("Elimina un usuarios por su id")
    public ResponseEntity<HttpStatus> deleteById(@ApiParam("Clave primaria") @PathVariable("id") Long id){
        if(genericService.existByid(id)){
            try{
                genericService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }catch(Exception e){
                System.err.println(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //GETTER Y SETTER

    public GenericService<Usuario, Long> getGenericService() {
        return genericService;
    }
}
