package es.josemasaborido.FirstCommit.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Proyecto First Commit
 * Clase ciudad. Se define la entidad ciudad
 *
 * @author josema
 * @version 1.0
 */
@Entity
@Table(name = "ciudades")
public class Ciudad {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCiudad;
    private String ciudad;

    //mappedBy hace referencia al nombre del atributo ciudad dado en la clase Alumno
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ciudad")
    private List<Alumno> alumnosCiudad;


    @ManyToOne
    //idPais_FK es el campo que se crea para relacionar con la tabla de pais
    @JoinColumn(name = "idPais_FK")
    private Pais pais;

    //CONSTRUCTORES

    /**
     * Constructor sin parametros
     */
    public Ciudad(){}

    /**
     * Consturctor con parametros
     *
     * @param ciudad   nombre de la ciudad
     */
    public Ciudad(String ciudad) {
        this.ciudad = ciudad;
        //Se inicializa el List al instanciar la ciudad
        this.alumnosCiudad = new ArrayList<>();
    }


    //GETTER Y SETTER


    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Alumno> getAlumnosCiudad() {
        return alumnosCiudad;
    }

    public void setAlumnosCiudad(List<Alumno> alumnosCiudad) {
        this.alumnosCiudad = alumnosCiudad;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
