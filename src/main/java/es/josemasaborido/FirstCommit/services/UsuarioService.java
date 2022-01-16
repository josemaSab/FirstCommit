package es.josemasaborido.FirstCommit.services;

import es.josemasaborido.FirstCommit.entities.Usuario;
import es.josemasaborido.FirstCommit.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Proyecto First Commit
 * Servicio de Usuario que implementa los metodos crud.
 *
 * @author josema
 * @version 1.0
 */
@Service
public class UsuarioService implements GenericService<Usuario, Long> {
    
    //ATRIBUTOS
    @Autowired
    UsuarioRepository usuarioRepository;
    List<Usuario> listaUsuarios;
    
    //CONSTRUCTORES

    /**
     * Consutructor con parametros
     * @param usuarioRepository repositorio de usuario
     */
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.listaUsuarios = new ArrayList<>();
        this.listaUsuarios = this.usuarioRepository.findAll();
    }


    //METODOS

    /**
     * Metodo que busca en persistencia un usuario por id de usuario
     * @param id del usuario
     * @return el objeto usuario si todo_ es correcto y null si no lo encuentra
     */
    @Override
    public Usuario findById(Long id) {
        if(this.existByid(id)){
            return usuarioRepository.findById(id).get();
        }
        return null;
    }

    /**
     * Metodo que devuelve todos los usuarios de la base datos
     * @return Lista con todos los usuarios
     */
    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    /**
     * Metodo que guarda un usuario en persistencia. Se comprueba que el correo del usuario no exista
     * para comprobar que el usuario ya existe en la base de datos
     * @param usuario objeto usuario pasado por parametro
     * @return objeto usuario si todo_ es correcto y null si el usuario ya existe
     */
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * MEtodo que actualiza los atributos de un usuario en persistencia
     * @param usuario objeto usuario pasado por parametros
     * @return el objeto guardado con las modificaciones
     */
    @Override
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Metodo que elimina un usuario de la base de datos por su id
     * @param id del usuario
     * @return
     */
    @Override
    public boolean deleteById(Long id) {
        if(this.existByid(id)){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Metodo que elimina todos los usuarios de la base de datos
     */
    @Override
    public void deleteAll() {
        usuarioRepository.deleteAll();

    }

    /**
     * Metodo que comprueba si un usuario existe por su id
     * @param id del usuario pasado por parametro
     * @return true si existe y false si no existe
     */
    @Override
    public boolean existByid(Long id) {
        if(usuarioRepository.existsById(id)){
            return true;
        }
        return false;
    }
    
    //GETTER Y SETTER

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
