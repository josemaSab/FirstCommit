/*
    Proyecto FirstCommit

    Clase que define objetos Alumno

    autor: Josema Saborido
    version: 1.0
 */

export default class Alumno{

    //ATRIBUTOS

    #nombreCompleto;
    #ciudad;
    #pais;
    #telefono;
    #email;
    #etiquetas;

    //CONSTRUCTORES

    constructor(nombreCompleto, ciudad, pais, telefono, email, etiquetas){
        this.#nombreCompleto = nombreCompleto;
        this.#ciudad = ciudad;
        this.#pais = pais;
        this.#telefono = telefono;
        this.#email = email;
        this.#etiquetas = etiquetas;
    }


    //GETTER Y SETTER

    get getNombreCompleto(){
        return this.#nombreCompleto;
    }

    set setNombreCompleto(nombreCompleto){
        this.#nombreCompleto = nombreCompleto;
    }

    get getCiudad(){
        return this.#ciudad;
    }

    set setCiudad(ciudad){
        this.#ciudad = ciudad;
    }

    get getPais(){
        return this.#pais;
    }

    set setCiudad(pais){
        this.#ciudad = pais;
    }

    get getTelefono(){
        return this.#telefono;
    }

    set setTelefono(telefono){
        this.#telefono = telefono;
    }

    get getEmail(){
        return this.#email;
    }

    set setEmail(email){
        this.#email = email;
    }

    get getEtiquetas(){
        return this.#etiquetas;
    }

    set setEtiquetas(etiquetas){
        this.#etiquetas = etiquetas;
    }


}