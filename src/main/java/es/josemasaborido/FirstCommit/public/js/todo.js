console.log("LLEGO EL MOMENTO DEL CAOS");

const listadoAlumnosJSON = [
    {
        "nombre" : "josema",
        "ciudad" : "Cádiz",
        "pais" : "España",
        "telefono" : "666111555",
        "email" : "j.saborido@josemasaborido.es",
        "etiquetas" : [
            {
                "id" : 1,
                "name" : "HTML+CSS"
            },
            {
                "id" : 2,
                "name" : "JAVASCRIPT"
            },
            ,
            {
                "id" : 3,
                "name" : "JAVA"
            },
            {
                "id" : 4,
                "name" : "SPRING"
            }
        ]
    },
    {
        "nombre" : "Clemen",
        "ciudad" : "Malaga",
        "pais" : "España",
        "telefono" :"57788855",
        "email" : "info@clemente.com",
        "etiquetas" : [
            {
                "id" : 1,
                "name" : "HTML+CSS"
            },
            {
                "id" : 2,
                "name" : "JAVASCRIPT"
            },
            ,
            {
                "id" : 3,
                "name" : "JAVA"
            },
            {
                "id" : 4,
                "name" : "SPRING"
            }
        ]
    },
    {
        "nombre" : "Ana",
        "ciudad" : "Gijon",
        "pais" : "España",
        "telefono" :"777555888",
        "email" : "info@ana.es",
        "etiquetas" : [
            {
                "id" : 1,
                "name" : "HTML+CSS"
            },
            {
                "id" : 2,
                "name" : "JAVASCRIPT"
            },
            ,
            {
                "id" : 5,
                "name" : "REACT"
            },
            {
                "id" : 3,
                "name" : "JAVA"
            }
    ]
    },
    {
        "nombre" : "Javier",
        "ciudad" : "Caceres",
        "pais" : "España",
        "telefono" :"7755585475",
        "email" : "info@javi.net",
        "etiquetas" : [
            {
                "id" : 1,
                "name" : "HTML+CSS"
            },
            {
                "id" : 2,
                "name" : "JAVASCRIPT"
            },
            ,
            {
                "id" : 5,
                "name" : "REACT"
            }
        ]
    }];
/**
 * Clase que define un alumno
 */
class Alumno{

    //ATRIBUTOS

    #nombreCompleto;
    #ciudad;
    #pais;
    #telefono;
    #email;
    #etiquetas;

    //CONSTRUCTORES
    /**
     * Constructor con parametros
     * @param {*} nombreCompleto nombre del alumno
     * @param {*} ciudad ciudad en la que vive el alumno
     * @param {*} pais pais en el que vive el alumno
     * @param {*} telefono telefono del alumno
     * @param {*} email email del alumno
     * @param {*} etiquetas certificaciones conseguidas por el alumno en array
     */
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
/**
 * Clase que define la gestion del los datos obtenidos a partir de un JSON
 */
class JsonService{

    //ATRIBUTOS

    #listadoAlumnosJSON;

    //CONSTRUCTORES
  
    /**
     * Constructor con parametros
     * 
     * @param {*} listadoAlumnosJSON  es el listado de alumnos en formato JSON
     */
    constructor(listadoAlumnosJSON){
        this.#listadoAlumnosJSON = listadoAlumnosJSON;
    }

    //METODOS

    /** 
     *  Metodo que obtiene un array de objetos Alumno y
     *  los devulve para su tratamiento
     * 
     * @returns Si todo es correcto devuelve un array con los objetos. Si hay algun error devuelve null
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
            return listadoAlumnos;
        }
        console.log("El listado pasado no es un objeto JSON valido para ser procesado");
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



/**
 * Clase que gestiona la generación de la tabla de alumnos
 */
class ViewListadoAlumnos{
    
    //ATRIBUTOS

    #tipoAlmacenamiento;
    #jsonService;

    //CONSTRUCTORES
    /**
     * Constructor con parametros
     * @param {*} listadoAlumnosJSON  el json con los datos de los alumnos
     * @param {*} jsonService objeto del servicio jsonService
     */
    constructor(listadoAlumnosJSON, jsonService){
        //console.log("Estamos en el constrcutor de View");
        this.#tipoAlmacenamiento = listadoAlumnosJSON;
        //console.log(this.getTipoAlmacenamiento);
        this.#jsonService = jsonService;
        //console.log(this.getJsonService);
    }

    //METODOS
    /**
     * Metodo encargado de componer la tabla con los alumnos
     *   devulve un string para procesarlo posteriormente como html
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

    /**
     * Metodo que obtiene el Listado de Alumnos almacenados
        devulve un array de alumnos
     * @returns listado de alumnos
     */
    obtenerListado(){
        //metemos en una variable el array[Alumnos]
        let listadoAlumnos = this.#jsonService.obtenerTodos();
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

}

/**
 * Clase que define el funcionamiento del filtro de la tabla de alumnos
 */
class FiltroOrdenarTabla{
    //ATRIBUTOS
    #filtroElementID;
    #tipoAlmacenamiento;
    #contador = 0; //Si es impar ordena ascendente y si es par

    //CONSTRUCTORES
    /**
     * 
     * @param {*} filtroElementID referencia del elemento ID del documento HTML
     * @param {*} tipoAlmacenamiento fuente de datos
     */
    constructor(filtroElementID, tipoAlmacenamiento){
        this.#filtroElementID = filtroElementID;
        this.#tipoAlmacenamiento = tipoAlmacenamiento;
    }

    //METODOS
    /**
     * Metodo que ordena de forma ascendente o descendente el listado de alumnos por el tipo de filtro selccionado
     */
    ordenar(){
        //console.log("Estamos dentro de ordenar");
        //asignamos el elemento pasado por parametro a una constante
        const elemento = document.getElementById(this.#filtroElementID);
        elemento.onclick = this.aumentarContador();
        //console.log(this.getContador) //Si se hace click en el elemento aumenta el contador
        if(this.#contador > 0){//si el elemento se ha pulsado al menos una vez
            if(this.#contador%2 == 0){
                //console.log("Estamos eligiendo orden descendente"); //si el valor del contador es par ordena de forma descendente
                this.ordenDescendente(this.#filtroElementID);

            }else {//Si el valor del contador es impar ordena de forma ascendente
                //console.log("Estamos eligiendo orden ascendente");
                this.ordenAscendente(this.#filtroElementID);
            }
        }
    }

    ordenAscendente(filtroElementID){
        //console.log("Estamos dentro de orden Ascendente");
        //console.log(filtroElementID);
        //Creamos un array
        let lista = [];
        //Asignamos el listado de alumnos
        switch(filtroElementID){
            case "filtroNombre":
                lista = this.#tipoAlmacenamiento.sort(this.sortArrayNombre);
                this.componerTabla(lista);
                break;
            case "filtroCiudad":
                lista = this.#tipoAlmacenamiento.sort(this.sortArrayCiudad);
                this.componerTabla(lista);
                break;
            case "filtroPais":
                lista = this.#tipoAlmacenamiento.sort(this.sortArrayPais);
                this.componerTabla(lista);
                break;
            case "filtroTelefono":
                lista = this.#tipoAlmacenamiento.sort(this.sortArrayTelefono);
                this.componerTabla(lista);
                break;
            case "filtroEmail":
                lista = this.#tipoAlmacenamiento.sort(this.sortArrayEmail);
                this.componerTabla(lista);
                break;
            case "filtroEtiquetas":
                lista = this.#tipoAlmacenamiento.sort(this.sortArrayEtiquetas);
                this.componerTabla(lista);
                break;
        }

    }

    ordenDescendente(filtroElementID){
        //console.log("Estamos dentro de orden Descendente");
        //Creamos un array
        let lista = [];
        //Asignamos el listado de alumnos
        lista = this.#tipoAlmacenamiento;
        switch(filtroElementID){
            case "filtroNombre":
                lista = this.#tipoAlmacenamiento.reverse(this.sortArrayNombre);
                this.componerTabla(lista);
                break;
            case "filtroCiudad":
                lista = this.#tipoAlmacenamiento.reverse(this.sortArrayCiudad);
                this.componerTabla(lista);
                break;
            case "filtroPais":
                lista = this.#tipoAlmacenamiento.reverse(this.sortArrayPais);
                this.componerTabla(lista);
                break;
            case "filtroTelefono":
                lista = this.#tipoAlmacenamiento.reverse(this.sortArrayTelefono);
                this.componerTabla(lista);
                break;
            case "filtroEmail":
                lista = this.#tipoAlmacenamiento.reverse(this.sortArrayEmail);
                this.componerTabla(lista);
                break;
            case "filtroEtiquetas":
                lista = this.#tipoAlmacenamiento.reverse(this.sortArrayEtiquetas);
                this.componerTabla(lista);
                break;
        }

    }
    /**
     * Metodo que aumenta en 1 el contador. Se realzia cuando se hace click
     * en alguno de los filtros
     */
    aumentarContador(){
        this.setContador = this.#contador + 1;
    }

    /**
     * METODOS QUE ORDENAN EL ARRAY POR EL CAMPO SELECCIONADO
     */
    sortArrayNombre(a, b){
        if(a.nombre > b.nombre){return 1}
        if(a.nombre < b.nombre){return -1}
        return 0;
    }

    sortArrayCiudad(a, b){
        if(a.ciudad > b.ciudad){return 1}
        if(a.ciudad < b.ciudad){return -1}
        return 0;
    }
    sortArrayPais(a, b){
        if(a.pais > b.pais){return 1}
        if(a.pais < b.pais){return -1}
        return 0;
    }
    sortArrayTelefono(a, b){
        if(a.telefono > b.telefono){return 1}
        if(a.telefono < b.telefono){return -1}
        return 0;
    }
    sortArrayEmail(a, b){
        if(a.email > b.email){return 1}
        if(a.email < b.email){return -1}
        return 0;
    }
    sortArrayEtiquetas(a, b){
        if(a.etiquetas.name > b.etiquetas.name){return 1}
        if(a.etiquetas.name < b.etiquetas.name){return -1}
        return 0;
    }
    
    /**
     *Metodo que dibuja la tabla a partir de un lisado pasado por parametros
     * @param {*} listado de alumnos pasado por parametros
     */
    componerTabla(listado){
        //console.log("Dentro de componer Tabla");
         //Obtenemos el listado de Alumnos
         let listadoAlumnos = listado;
         let tabla = "";
         //Recorrecmos el array y vamos componiendo la tabla
         for(let i in listadoAlumnos){
             //console.log("Dentro del for");
             console.log(listadoAlumnos[i].nombre);
             tabla += `<tr>
             <td class="datosAlumnos">${listadoAlumnos[i].nombre}</td>
             <td class="datosAlumnos">${listadoAlumnos[i].ciudad}</td>
             <td class="datosAlumnos">${listadoAlumnos[i].pais}</td>
             <td class="datosAlumnos">${listadoAlumnos[i].telefono}</td>
             <td class="datosAlumnos">${listadoAlumnos[i].email}</td>
             <td class="datosAlumnos">${listadoAlumnos[i].etiquetas.map(
                 //Con map creamos un nuevo array del array de etiquetas para procesarlas
                 (etiquetas) => 
                 //Componenmos la lista de etiquetas
                 `<li class="tags" key="${etiquetas.id}">${etiquetas.name}</li>`
                 //Unimos todo en una cadena de caracteres
                 ).join("")
             }</ul></td>
             </tr>`;
             //console.log("Intentando pinter la tabla");
         }
         //Pasamos al html al table body con clase datos la composicion
         document.getElementById("datos").innerHTML = tabla;
    }

    //GETTER Y SETTER
    get getFiltroElementID(){
        return this.#filtroElementID;
    }

    set setFiltroElementID(filtroElementID){
        this.#filtroElementID = filtroElementID;
    }

    get getTipoAlmacenamiento(){
        return this.#tipoAlmacenamiento;
    }

    set setTipoAlmacenamiento(tipoAlmacenamiento){
        this.#tipoAlmacenamiento = tipoAlmacenamiento;
    }

    get getContador(){
        return this.#contador;
    }

    set setContador(numero){
        this.#contador = numero;
    }
}

/**
 * Clase que define el funcionamiento de la barra de busqueda
 */
class BarraBusqueda{

}

/*EJECUCION DEL PROGRAMA*/

//Creamos los filtros
const filtroNombre = new FiltroOrdenarTabla("filtroNombre", listadoAlumnosJSON);
const filtroCiudad = new FiltroOrdenarTabla("filtroCiudad", listadoAlumnosJSON);
const filtroPais = new FiltroOrdenarTabla("filtroPais", listadoAlumnosJSON);
const filtroTelefono = new FiltroOrdenarTabla("filtroTelefono", listadoAlumnosJSON);
const filtroEmail = new FiltroOrdenarTabla("filtroEmail", listadoAlumnosJSON);
const filtroEtiquetas = new FiltroOrdenarTabla("filtroEtiquetas", listadoAlumnosJSON);

// Funcion que llama al metodo fitrar por el campo Seleccionado
function filtrarNombre(){
    filtroNombre.ordenar();
}

function filtrarCiudad(){
    filtroCiudad.ordenar();
}

function filtrarPais(){
    filtroPais.ordenar();
}

function filtrarTelefono(){
    filtroTelefono.ordenar();
}

function filtrarEmail(){
    filtroEmail.ordenar();
}

function filtrarEtiquetas(){
    filtroEtiquetas.ordenar();
}

//Instanciamos los servicios y las vistas
const jsonService = new JsonService(listadoAlumnosJSON);
const view = new ViewListadoAlumnos(listadoAlumnosJSON, jsonService);

//Mostramos por consola el listado de alumnos
console.log(view.obtenerListado());
//Procedemos a la carga de la pagina
window.onload= view.componerTabla();
    