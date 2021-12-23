console.log("LLEGO EL MOMENTO DEL CAOS");

const listadoAlumnosJSON = [
    {
        "nombre" : "josema",
        "ciudad" : "El Puerto de Santa María",
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

class Alumno{

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

class JsonService{

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

const jsonService = new JsonService(listadoAlumnosJSON);
console.log(jsonService.obtenerTodos()[1]);

class ViewListadoAlumnos{
    
    //ATRIBUTOS

    #tipoAlmacenamiento;
    #jsonService;

    //CONSTRUCTORES
    /*
        Constructor sin parametros
        Instanciamos el services, el repository 
        y el tipo de almacenamiento
    */
    constructor(listadoAlumnosJSON, jsonService){
        console.log("Estamos en el constrcutor de View");
        this.#tipoAlmacenamiento = listadoAlumnosJSON;
        console.log(this.getTipoAlmacenamiento);
        this.#jsonService = jsonService;
        console.log(this.getJsonService);
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
const view = new ViewListadoAlumnos(listadoAlumnosJSON, jsonService);
console.log(view.obtenerListado());

window.onload= view.componerTabla();
    