import React from 'react'
import PropTypes from 'prop-types'
import EnlaceComponent from './EnlaceComponent'

function CreditosComponent(props) {
    
    return (
        
        <div className={props.clase}>
            <p className={props.clase}>Copyright © 2021 Open Bootcamp SL, Imagina Group</p>
            <p className={props.clase}>Todos los derechos reservados.</p>
            <EnlaceComponent enlace='#' clase='link-creditos' descripcion='Política de Privacidad'></EnlaceComponent>
        </div>
    )
}

CreditosComponent.propTypes = {
    clase: PropTypes.string
}

export default CreditosComponent

