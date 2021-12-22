/*
    Proyecto FirstCommit

    Clase que AlumnoRepository. Se encarga de definir de forma general
    la obtención de alumnos de un tipo de almacenamiento

    autor: Josema Saborido
    version: 1.0
 */
export default class AlumnoRepository{
    
    //ATRIBUTOS

    //Sera la variable para hacer el polimorfismo
    //Le pasaremos un objeto tipo de almacenamiento
    //y segun el tipo realizara el CRUD de una forma u otra
    #tipoAlmacenamiento; 

    //CONSTRUCTORES
    constructor(tipoAlmacenamiento){
        this.#tipoAlmacenamiento = tipoAlmacenamiento;
    }
    //METODOS 

    /*
        Metodo que obtiene todos los alumnos del tipo de almacenmiento
        devulve null ha habido algun problema al obtener todos los
        alumnos. Si todo ha ido bien devuelve el array de alumnos
    */
    obtenerTodos(){
        //Definimos un array
        const listadoAlumnos=[];
        //Comprueba que el tipo de almacenamiento es de tipo objeto
        //y ademas comprueba que tiene definido el metodo guardar
        if(this.compruebaObjeto &&
            this.#tipoAlmacenamiento.obtenerTodos == 'function'){
                listadoAlumnos = this.#tipoAlmacenamiento.obtenerTodos();
                return listadoAlumnos;
            }
        console.log("El tipo de almacenamiento instanciado no es un objeto" 
        + "o no tiene definido el metodo obtenerTodos")    
        return null;
    }

    
    /*
        Metodo que comprueba que el tipo de almacenamiento instanciado es 
        de tipo objeto.
        devulve true si es correcto y false si no es de tipo objeto
    */
    compruebaObjeto(){
        //Comrpueba si el 
        if(typeof this.#tipoAlmacenamiento == 'object'){
            return true
        }
        console.log("Tipo de almacenamiento no es un objeto")
        return false
    }

    //GETTER Y SETTER

    get getTipoAlmacenamiento(){
        return this.#tipoAlmacenamiento;
    }

    set setTipoAlmacenamiento(tipoAlmacenamiento){
        this.#tipoAlmacenamiento = tipoAlmacenamiento;
    }
}