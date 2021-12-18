package es.josemasaborido.FirstCommit.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Proyecto First Commit
 * Clase usuario. Se define la entidad usuario
 *
 * @author josema
 * @version 1.0
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nombreUsuario;
    private String password;
    private String email;

    //mappedBy hace referencia al nombre del atributo Usuario dado en la clase Alumno
    @OneToMany(mappedBy = "usuario")
    private List<Alumno> alumnos;


    //CONSTRUCTORES

    /**
     * Consutructor con todos los parametros
     *
     * @param idUsuario     id del usuario es clave primaria
     * @param nombreUsuario nombre del usuario
     * @param password      password del usuario
     * @param email         del usuario
     */
    public Usuario(Long idUsuario, String nombreUsuario, String password, String email) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
        //inicializamos el Listde la relacion @OnetoMany
        alumnos = new ArrayList<>();
    }


    //GETTER Y SETTER


    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}