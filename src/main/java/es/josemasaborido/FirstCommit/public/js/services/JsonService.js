import { Alumno } from "../models/Alumno.js"
/*
    Proyecto FirstCommit

    Clase Servicio que realiza las operaciones necesarias
    para obtener los datos a partir de un JSON local o un 
    objeto JSON

    autor: Josema Saborido
    version: 1.0
 */

export default class JsonService{

    //ATRIBUTOS

    #listadoAlumnosJSON;

    //CONSTRUCTORES
    /*
        Constructor con parametros
        @lisdoAlumnosJson es el listado de alumnos en formato JSON

     */
    constructor(listadoAlumnosJSON){
        this.#listadoAlumnosJSON = listadoAlumnosJSON;
    }

    //METODOS

    /*
        Metodo que obtiene un array de objetos Alumno y
        los devulve para su tratamiento
        Si todo es correcto devulve un array con los objetos
        Si hay algun error devulve null
     */
    obtenerTodos(){
        //Definimos un array donde iran los objetos alumnos
        let listadoAlumnos = [];
        //Comprobamos que el listado instanciado en la clase es un objeto
        if(typeof this.#listadoAlumnosJSON == 'object'){
            for(let i = 0; i< this.#listadoAlumnosJSON.length; i++){
                //Instanciamos un alumno con los datos del JSON
                const alumno = new Alumno(
                    this.#listadoAlumnosJSON[i].nombre,
                    this.#listadoAlumnosJSON[i].ciudad,
                    this.#listadoAlumnosJSON[i].pais,
                    this.#listadoAlumnosJSON[i].telefono,
                    this.#listadoAlumnosJSON[i].email,
                    this.#listadoAlumnosJSON[i].etiquetas
                );
                listadoAlumnos.push(alumno);
            }
            console.log("El listado pasado no es un objeto JSON valido para ser procesado")
            return listadoAlumnos
        }
        return null;
    }

    //GETTER Y SETTER

    get getListadoAlumnosJSON(){
        return this.#listadoAlumnosJSON;
    }

    set setListadoAlumnosJSON(listadoAlumnosJSON){
        this.#listadoAlumnosJSON = listadoAlumnosJSON;
    }

}