import React from 'react'
import PropTypes from 'prop-types'
import EnlaceComponent from '../pure/EnlaceComponent'
import EtiquetaComponent from '../pure/EtiquetaComponent'

function MenuSuperiorFichaC(props) {
    return (
        <div className={props.clase}>
            <div className='izq-nav'>
                <span></span>
                <EnlaceComponent enlace='#' clase='link-nav-sup' descripcion='Volver'></EnlaceComponent>
            </div>
            <div className='dcha-nav'>
                <img/><EtiquetaComponent clase='user-nav' descripcion='Josema'></EtiquetaComponent>
            </div>
        </div>
    )
}

MenuSuperiorFichaC.propTypes = {
    clase: PropTypes.string,
}

export default MenuSuperiorFichaC

