import React from 'react'
import PropTypes from 'prop-types'
import EtiquetaComponent from '../pure/EtiquetaComponent'
import TituloComponent from '../pure/TituloComponent'

function MenuSuperior(props) {
    return (
        <div className={props.clase}>
            <div className='izq-titulo'><TituloComponent clase='titulo-nav' tituloH1='OpenBootcamp' tituloH2='| Alumnos'></TituloComponent></div>
            <div className='dcha-titulo'><img alt='Imagen de usuario'/><EtiquetaComponent clase='user-nav' descripcion='Josema'></EtiquetaComponent></div> 
        </div>
    )
}

MenuSuperior.propTypes = {
    clase: PropTypes.string

}

export default MenuSuperior

