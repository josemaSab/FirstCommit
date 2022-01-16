package es.josemasaborido.FirstCommit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import es.josemasaborido.FirstCommit.enums.Presencialidad;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Proyecto First Commit
 * Clase alumno. Se define la entidad alumno
 *
 * @author josema
 * @version 1.0
 */
@Entity
@Table(name = "alumnos")
public class Alumno {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlumno;
    private String nombreAlumno;
    private String apellidosAlumno;
    private String emailAlumno;
    private String telefono;
    private Presencialidad presencialidad;
    private Boolean traslado;
    private String foto;
    private String curriculum;

    @JsonIgnore
    //Relacion muchos a uno con la tabla usuarios
    @ManyToOne(fetch = FetchType.LAZY)
    //idUsuario_FK es el campo que se crea para relacionar con la tabla de usuarios
    @JoinColumn(name = "idUsuario_FK")
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    //idCiudad_FK es el campo que se crea para relacionar con la tabla de ciudad
    @JoinColumn(name = "idCiudad_FK")
    private Ciudad ciudad;


    //mappedBy hace referencia al nombre del atributo asignado en el Set de la entidad Certificaciones
    //Que es la que se relaciona con esta entidad
    @ManyToMany(mappedBy = "alumnosCertificados")
    private Set<Certificacion> certificaciones;


    //CONTRUCTORES

    /**
     * Constructor sin parametros
     */
    public Alumno(){}

    /**
     * Constructor con parametros
     *
     * @param nombreAlumno    nombre del alumno
     * @param apellidosAlumno apellidos del alumno
     * @param emailAlumno     email del alumno
     * @param telefono        telefono del alumno
     * @param presencialidad  presencialidad si es remoto, presencial o hibrido
     * @param traslado        si necesita traslado
     * @param foto            direccion del archivo de la  fotografia
     * @param curriculum      dirección del archivo del curriculum
     * @param usuario         usuario asignado
     */
    public Alumno(String nombreAlumno, String apellidosAlumno, String emailAlumno, String telefono,
                  Presencialidad presencialidad, Boolean traslado, String foto, String curriculum, Usuario usuario) {
        this.nombreAlumno = nombreAlumno;
        this.apellidosAlumno = apellidosAlumno;
        this.emailAlumno = emailAlumno;
        this.telefono = telefono;
        this.presencialidad = presencialidad;
        this.traslado = traslado;
        this.foto = foto;
        this.curriculum = curriculum;
        this.usuario = usuario;
        //Inicializamos el set al instanciar el alumno
        certificaciones = new HashSet<>();

    }

    //GETTER Y SETTER


    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidosAlumno() {
        return apellidosAlumno;
    }

    public void setApellidosAlumno(String apellidosAlumno) {
        this.apellidosAlumno = apellidosAlumno;
    }

    public String getEmailAlumno() {
        return emailAlumno;
    }

    public void setEmailAlumno(String emailAlumno) {
        this.emailAlumno = emailAlumno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Presencialidad getPresencialidad() {
        return presencialidad;
    }

    public void setPresencialidad(Presencialidad presencialidad) {
        this.presencialidad = presencialidad;
    }

    public Boolean getTraslado() {
        return traslado;
    }

    public void setTraslado(Boolean traslado) {
        this.traslado = traslado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Certificacion> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(Set<Certificacion> certificaciones) {
        this.certificaciones = certificaciones;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
