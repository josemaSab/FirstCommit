# ESPECIFICACIONES API REST

## CONTROLLER LOGIN

* [POST] /login/{Usuario} 

Pasaremos un objeto Usuario para su comprobación si existe en la base de datos y comprobaremos que la contraseña es correcta

## CONTROLLER LISTADO

* [GET] /listado

Recuperara de la base de datos todos los candidatos para componer la tabla

* [GET] /listado/{Palabra Clave}

Recuparara de la base de datos aquellos campos que contengan la palabra clave pasada por parametro

## CONTROLLER FICHA 

* [GET] /ficha/{Id Candidato}

Recuperara la ficha del candidato pasada su id por parametro

* [UPDATE] /ficha/CV/{Ruta CV}

Actualizará la ruta del curriculum del candidato con la ruta pasada por parametro

* [DELETE] /ficha/CV/{Id Candidato}

Eliminara la ruta del curriculum del Candidato pasada su id por parametro
