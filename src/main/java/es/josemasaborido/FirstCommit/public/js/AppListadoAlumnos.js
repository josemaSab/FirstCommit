import { ViewListadoAlumnos } from "./vistas/ViewListadoAlumnos.js";

/*
    Proyecto FirstCommit

    clase principal que muestra la tabla de alumnos

    autor: Josema Saborido
    version: 1.0
 */


window.onload = function(){
    viewListadoAlumnos = new ViewListadoAlumnos();
    viewListadoAlumnos.componerTabla();
}
console.log("Carga exitosa");


