/* OPCIONES DE LOS COMBOBOX */

const etiquetas = [
    "HTML+CSS",
    "JAVASCRIPT",
    "JAVA",
    "SPRING",
    "HIBERNATE"
];

const paises = [
    "España",
    "Francia",
    "Portugal"
];

const ciudades = [
    "Cádiz",
    "Málaga",
    "Sevilla",
    "Madrid",
    "Barcelona"
];

const traslados = [
    "Si",
    "No"
];

const presencialidad = [
    "Remoto",
    "Híbrido",
    "Presencial"
];

/* CLASES */

/**
 * Clase que define el funcionamiento del combobox, la carga de opciones
 * y la recuperacion de la ipción seleccionada
 */
class ComboBox {
    //ATRIBUTOS

    #listaOpciones = [];
    #nombreLista;
    #idCombo;


    //CONSTRUCTORES
    /**
     * Constructor con parametros
     * @param {*} listaOpciones lista con las opciones del combobox
     * @param {*} nombreLista nombre que se le asigna a la lista
     * @param {*} idCombo el id identificativo del combobox
     */
    constructor(listaOpciones, nombreLista, idCombo) {
        this.#listaOpciones = listaOpciones;
        this.#nombreLista = nombreLista;
        this.#idCombo = idCombo;
    }

    //METODOS
    /**
     * Metodo que carga las opciones en el combobox seleccionado
     */
    cargarOpciones() {
        let opciones = "";
        opciones += `<datalist id="${this.#nombreLista}">`;
        for (let i in this.#listaOpciones) {
            opciones += ` 
                <option value="${this.#listaOpciones[i]}">${this.#listaOpciones[i]}</option>
            `;
        }
        opciones += `</datalist>`;

        console.log(opciones);
        console.log(this.getIdCombo);
        document.getElementById("" + this.#idCombo + "").innerHTML = opciones;
    }

    //GETTER Y SETTER

    get getListaOpciones() {
        return this.#listaOpciones;
    }

    set setListaOpciones(listaOpciones) {
        this.#listaOpciones = listaOpciones;
    }

    get getNombreLista() {
        return this.#nombreLista;
    }

    set setNombreLista(nombreLista) {
        this.#nombreLista = nombreLista;
    }

    get getIdCombo() {
        return this.#idCombo;
    }

    set setIdCombo(idCombo) {
        this.#idCombo = idCombo;
    }
}

/**
 * Clase que define el funcionamiento de las etiquetas asignadas 
 * a un alumno
 */
class EtiquetasAsignadas {
    //ATRIBUTOS

    #listaEtiquetas;

    //CONSTRUCTORES
    /**
     * Constructor sin parametros. Inicializamos el array para contener
     * las etiquetas elegidas
     */
    constructor() {
        this.#listaEtiquetas = [];
    }

    //METODOS
    /**
     * Metodo que busca en el listado de etiquetas si existe una etiqueta 
     * pasada por parametro
     * @param {*} etiqueta pasada por parametro
     * @returns true si existe y false si no existe en el array
     */
    existeEtiqueta(etiqueta) {
        if (this.#listaEtiquetas.find(etiqueta)) {
            return true;
        }
        return false;
    }

    /**
     * Metodo que añade una etiqueta al array
     * @param {*} etiqueta pasada por parametro
     */
    addEtiqueta(etiqueta) {
        if (this.#listaEtiquetas.length != 0) {
            if (this.existeEtiqueta(etiqueta)) {
                console.log("La etiqueta ya existe en la lista");
            } else {
                this.#listaEtiquetas.push(etiqueta);
                console.log(this.#listaEtiquetas);
                this.componerEtiquetas();
            }
        }else{
            this.#listaEtiquetas.push(etiqueta);
            console.log(this.#listaEtiquetas);
            this.componerEtiquetas();
        }
        console.log(this.#listaEtiquetas);
        
    }
    /**
     * Metodo que elimina una etiqueta del array
     * @param {*} etiqueta passada por parametro
     */
    borrarEtiqueta(etiqueta) {
        if (this.existeEtiqueta(etiqueta)) {
            this.#listaEtiquetas.slice(this.#listaEtiquetas.indexOf(etiqueta), 1);
        } else {
            console.log("No se puede eliminar una etiqueta que no existe");
        }
        this.componerEtiquetas();
    }

    /**Metodo que compone visualmente la parte de las etiquetas
     * añadiendo las etiquetas en el array
     */
    componerEtiquetas() {
        let etiquetas = "";
        for (let i in this.#listaEtiquetas) {
            etiquetas += `
            <label class="itemEtiqueta">${this.#listaEtiquetas[i]}</label><button class="eliminaEtiqueta" onclick="quitarEtiqueta(${this.#listaEtiquetas[i]});"></button>
            `;
        }
        document.getElementById("etiquetaSeleccionada").innerHTML = etiquetas;
    }
//TODO queda terminar el metodo listerner para que le de funcionalidad a las etiquetas
    listenerEtiquetas() {
        var resultado;
        let getValue;
        getValue = document.getElementById("etiqueta")
        getValue.addEventListener('input', function () {
            resultado = this.value;
            console.log("Opcion seleccionada:" + resultado);
            
        });
        this.addEtiqueta(resultado);
    }

    //GETTER Y SETTER

    get getListaEtiquetas() {
        return this.#listaEtiquetas;
    }

    set setListaEtiquetas(listaEtiquetas) {
        this.#listaEtiquetas = listaEtiquetas;
    }

}

/* INSTANCIAS DE OBJETOS */


const cbmPaises = new ComboBox(paises, "paises", "pais");
const cbmCiudades = new ComboBox(ciudades, "ciudades", "ciudad");
const cbmTraslado = new ComboBox(traslados, "traslados", "traslado");
const cbmPresencialidad = new ComboBox(presencialidad, "tipoPresencialidad", "presencialidad");
const cmbEtiquetas = new ComboBox(etiquetas, "etiquetas", "etiqueta");
const etiquetasAsignadas = new EtiquetasAsignadas();


/* CARGA DE LA APLICACION */
function cargaCombo() {
    cbmCiudades.cargarOpciones();
    cbmPaises.cargarOpciones();
    cbmTraslado.cargarOpciones();
    cbmPresencialidad.cargarOpciones();
    cmbEtiquetas.cargarOpciones();
    etiquetasAsignadas.listenerEtiquetas();
}

function quitarEtiqueta(indexEtiqueta) {
    etiquetasAsignadas.borrarEtiqueta(indexEtiqueta);
}


window.onload = function () {
    cargaCombo();
};