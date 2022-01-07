import React from 'react'
import PropTypes from 'prop-types'

function EtiquetaComponent(props) {
    return (
        <div className={props.clase}>
            <label className={props.clase}>{props.descripcion}</label>
            
        </div>
    )
}

EtiquetaComponent.propTypes = {
    clase: PropTypes.string,
    descripcion: PropTypes.string,
}

export default EtiquetaComponent

