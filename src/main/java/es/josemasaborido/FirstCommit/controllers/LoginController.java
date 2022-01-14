package es.josemasaborido.FirstCommit.controllers;

import es.josemasaborido.FirstCommit.entities.Usuario;
import es.josemasaborido.FirstCommit.models.Autenticacion;
import es.josemasaborido.FirstCommit.services.GenericService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Proyecto First Commit
 * Controlador de Login. Se controlaran las peticiones y respuestas API de la parte de login
 *
 * @author josema
 * @version 1.0
 */
@RestController
public class LoginController {

    //ATRIBUTOS
    private static final String API_BASE = "/api/v1";
    private GenericService<Usuario, Long> genericService;

    //METODOS

    /**
     * Metodo que comprueba si los datos de autenticación son correctos para acceder al sistema
     * @param autenticacion objeto que contiene el usuario y contraseña de la autenticacion para su tratamiento
     * @return Status OK si todo_ es correcto BAD REQUEST si la contraseña no es la correcta y NOT FOUND si el usuario
     * no existe.
     */
    @PostMapping(API_BASE + "/login")
    @ApiOperation("Comprueba que el usuario y contraseña sean correctos para acceder al sistema")
    public ResponseEntity<HttpStatus> login(@ApiParam("Datos de autenticacion")@RequestBody Autenticacion autenticacion){
        List<Usuario> listaUsuarios = genericService.findAll();
        for(Usuario u: listaUsuarios){
            if(u.getNombreUsuario().equals(autenticacion.getNombreUsuario())){
                //TODO habra que hasear la contraseña para hacer la comprobacion con la base de datos
                if(u.getPassword().equals(autenticacion.getPassword())){
                    return new ResponseEntity<>(HttpStatus.OK);
                }
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //GETTER Y SETTER
}
