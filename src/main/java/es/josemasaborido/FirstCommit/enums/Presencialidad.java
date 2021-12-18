package es.josemasaborido.FirstCommit.enums;

/**
 * Proyecto First Commit
 * Enum presencialidad. Si es en remoto , presencial o hibrido
 *
 * @author josema
 * @version 1.0
 */
public enum Presencialidad {
    //ENUMS
    REMOTO("Remoto"), PRESENCIAL("Presencial"), HIBRIDO("Hibrido");

    //ATRIBUTOS
    private String tipoPresnecialidad;

    //CONSTRUCTORES

    /**
     * Constructor con parametro
     * @param tipoPresnecialidad tipo de presencialidad
     */
    private Presencialidad(String tipoPresnecialidad) {
        this.tipoPresnecialidad = tipoPresnecialidad;
    }

    //GETTER Y SETTER


    public String getTipoPresnecialidad() {
        return tipoPresnecialidad;
    }
}
