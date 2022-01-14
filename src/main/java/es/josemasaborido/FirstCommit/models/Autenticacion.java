package es.josemasaborido.FirstCommit.models;

/**
 * Proyecto First Commit
 * Clase que define los objetos autenticación que se pasará al login para logearse al sistema.
 * Contendrá los atributos de nombre de usuario y contraseña
 *
 * @author josema
 * @version 1.0
 */
public class Autenticacion {

    //ATRIBUTOS
    private String nombreUsuario;
    private String password;

    //CONSTRUCTORES

    /**
     * Consutructor con todos los parametros
     * @param nombreUsuario nombre de usuario a autenticar
     * @param contraseña del usuario
     */
    public Autenticacion(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.password = contraseña;
    }

    //GETTER Y SETTER

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
}
