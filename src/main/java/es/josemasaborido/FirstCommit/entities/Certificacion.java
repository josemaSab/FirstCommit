package es.josemasaborido.FirstCommit.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Proyecto First Commit
 * Clase certificacion. Se define la entidad certificacion
 *
 * @author josema
 * @version 1.0
 */
@Entity
@Table(name = "certificaciones")
public class Certificacion implements Serializable {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCertificacion;
    private String certificacion;
    @JsonBackReference
    //La entidad Certificacion es la entidad padre en la relacion ManytoMany
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "alum_cert",
            joinColumns = {@JoinColumn(name = "idCert_FK")},
            inverseJoinColumns = {@JoinColumn(name = "idAlum_FK")}
    )
    //Uso set para que no se dupliquen los alumnos
            private Set<Alumno> alumnosCertificados = new HashSet<>();

    //CONSTRUCTORES

    /**
     * Constructor sin parametros
     */
    public Certificacion(){}

    /**
     * Constructor con parametros
     *
     * @param certificacion   nombre de la certificacion
     */
    public Certificacion(String certificacion) {
        this.certificacion = certificacion;
    }

    //GETTER Y SETTER


    public Long getIdCertificacion() {
        return idCertificacion;
    }

    public void setIdCertificacion(Long idCertificacion) {
        this.idCertificacion = idCertificacion;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }

    public Set<Alumno> getAlumnosCertificados() {
        return alumnosCertificados;
    }

    public void setAlumnosCertificados(Set<Alumno> alumnosCertificados) {
        this.alumnosCertificados = alumnosCertificados;
    }
}
