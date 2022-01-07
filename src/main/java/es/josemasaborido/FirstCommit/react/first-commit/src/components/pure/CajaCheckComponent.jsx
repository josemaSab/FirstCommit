import React from 'react'
import PropTypes from 'prop-types'
import EtiquetaComponent from './EtiquetaComponent'

function CajaCheckComponent(props) {
    return (
        <div className={props.clase}>
            <input type="checkbox" className={props.clase} name={props.name} /><label className={props.clase}>{props.descripcion}</label>
        </div>
    )
}

CajaCheckComponent.propTypes = {
    clase: PropTypes.string,
    name: PropTypes.string,
    descripcion: PropTypes.string
}

export default CajaCheckComponent

