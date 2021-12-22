import Alumno from "./models/Alumno";
import JsonService from "./services/JsonService";
import AlumnoRepository from "./repositories/AlumnoRepository";
import { listadoAlumnosJSON } from "./almacenamiento/json";

/*
    Proyecto FirstCommit

    clase que se encargará de pintar la tabla

    autor: Josema Saborido
    version: 1.0
 */
export default class ViewListadoAlumnos{
    
    //ATRIBUTOS

    #tipoAlmacenamiento;
    #jsonService;
    #alumnoRepository;

    //CONSTRUCTORES
    /*
        Constructor sin parametros
        Instanciamos el services, el repository 
        y el tipo de almacenamiento
    */
    constructor(){
        this.#tipoAlmacenamiento = listadoAlumnosJSON;
        this.#jsonService = new JsonService(this.#listadoAlumnosJSON);
        this.#alumnoRepository = new AlumnoRepository(this.#jsonService)
    }

    //METODOS
    /*
        Metodo encargado de componer la tabla con los alumnos
        devulve un string para procesarlo posteriormente como html
    */
    componerTabla(){
        //Obtenemos el listado de Alumnos
        let listadoAlumnos = this.obtenerListado();
        let tabla = "";
        //Recorrecmos el array y vamos componiendo la tabla
        for(let i in listadoAlumnos){
            tabla += `<tr>
            <td class="datosAlumnos">${listadoAlumnos[i].getNombreCompleto}</td>
            <td class="datosAlumnos">${listadoAlumnos[i].getCiudad}</td>
            <td class="datosAlumnos">${listadoAlumnos[i].getPais}</td>
            <td class="datosAlumnos">${listadoAlumnos[i].getTelefono}</td>
            <td class="datosAlumnos">${listadoAlumnos[i].getEmail}</td>
            <td class="datosAlumnos">${listadoAlumnos[i].getEtiquetas.map(
                //Con map creamos un nuevo array del array de etiquetas para procesarlas
                (etiquetas) => 
                //Componenmos la lista de etiquetas
                `<li class="tags" key="${etiquetas.id}">${etiquetas.name}</li>`
                //Unimos todo en una cadena de caracteres
                ).join("")
            }</ul></td>
            </tr>`;
        }
        //Pasamos al html al table body con clase datos la composicion
        document.getElementById("datos").innerHTML = tabla;
    }

    /*
        Metodo que obtiene el Listado de Alumnos almacenados
        devulve un array de alumnos
    */
    obtenerListado(){
        //metemos en una variable el array[Alumnos]
        let listadoAlumnos = this.#alumnoRepository.obtenerTodos();
        return listadoAlumnos;
    }

    //GETTER Y SETTER

    get getTipoAlmacenamiento(){
        return this.#tipoAlmacenamiento;
    }

    set setTipoAlmacenamiento(tipoAlmacenamiento){
        this.#tipoAlmacenamiento = tipoAlmacenamiento;
    }

    get getJsonService(){
        return this.#jsonService;
    }

    set setJsonService(jsonService){
        this.#jsonService = jsonService;
    }

    get getAlumnoRepository(){
        return this.#alumnoRepository;
    }

    set setAlumnoRepository(alumnoRepository){
        this.#alumnoRepository = alumnoRepository;
    }

}



