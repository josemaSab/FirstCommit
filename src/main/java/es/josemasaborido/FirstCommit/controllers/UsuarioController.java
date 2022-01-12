package es.josemasaborido.FirstCommit.controllers;

import es.josemasaborido.FirstCommit.entities.Usuario;
import es.josemasaborido.FirstCommit.services.GenericService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(API_BASE + "/usuarios/{id}")
    @ApiOperation("Busca un usuario por su id pasada por parametro")
    public ResponseEntity<Usuario> findById(@ApiParam("Clave primaria") @PathVariable("id") Long id){
        if(genericService.existByid(id)){
            return new ResponseEntity<>(genericService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    //GETTER Y SETTER

    public GenericService<Usuario, Long> getGenericService() {
        return genericService;
    }
}
