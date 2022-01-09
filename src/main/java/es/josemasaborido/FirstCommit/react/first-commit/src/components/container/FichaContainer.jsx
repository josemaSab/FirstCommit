import React from 'react'
import PropTypes from 'prop-types'
import DatosCandidato from '../ficha/DatosCandidato'
import VisorPdfCV from '../ficha/VisorPdfCV'

function FichaContainer(props) {
    return (
        <div className={props.clase}>
            <DatosCandidato clase='datos-candidato'></DatosCandidato>
            <VisorPdfCV clase='visor-pdf'></VisorPdfCV>
        </div>
    )
}

FichaContainer.propTypes = {
    clase: PropTypes.string,
}

export default FichaContainer

