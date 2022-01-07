import React from 'react'
import PropTypes from 'prop-types'

function EnlaceComponent(props) {
    return (
        <div className={props.clase}>
            <a href={props.enlace} className={props.clase}>{props.descripcion}</a>
        </div>
    )
}

EnlaceComponent.propTypes = {
    enlace: PropTypes.string,
    clase: PropTypes.string,
    descripcion: PropTypes.string
}

export default EnlaceComponent

