package es.josemasaborido.FirstCommit.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Proyecto First Commit
 * Clase pais. Se define la entidad pais
 *
 * @author josema
 * @version 1.0
 */

@Entity
@Table(name = "paises")
public class Pais {

    //ATRIBUTOS
    private Long idPais;
    private String pais;

    //CONSTRUCTORES

    /**
     * Constructor con parametros
     *
     * @param idPais id del pais
     * @param pais   nombre del pais
     */
    public Pais(Long idPais, String pais) {
        this.idPais = idPais;
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
}
