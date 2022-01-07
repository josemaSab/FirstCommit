import React from 'react'
import PropTypes from 'prop-types'

function TituloComponent(props) {
    return (
        <div className={props.clase}>
            <h1 className={props.clase}>{props.tituloH1}</h1>
            <h2 className={props.clase}>{props.tituloH2}</h2>
        </div>
    )
}

TituloComponent.propTypes = {
    tituloH1: PropTypes.string,
    tituloH2: PropTypes.string,
    clase: PropTypes.string
}

export default TituloComponent

