package es.josemasaborido.FirstCommit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Proyecto First Commit
 * Clase pais. Se define la entidad pais
 *
 * @author josema
 * @version 1.0
 */

@Entity
@Table(name = "paises")
public class Pais implements Serializable {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;
    private String pais;

    //mappedBy hace referencia al nombre del atributo Pais dado en la clase Ciudad
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pais")
    private Set<Ciudad> ciudades = new HashSet<>();

    //CONSTRUCTORES

    /**
     * Constructor sin parametros
     */
    public Pais(){}

    /**
     * Constructor con parametros
     *
     * @param pais   nombre del pais
     */
    public Pais(String pais) {
        this.pais = pais;
    }

    //GETTER Y SETTER


    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Set<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(Set<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
}
