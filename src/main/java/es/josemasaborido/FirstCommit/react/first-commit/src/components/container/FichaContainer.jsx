import React from 'react'
import PropTypes from 'prop-types'
import MenuSuperiorFichaC from '../ficha/MenuSuperiorFichaC'
import DatosCandidato from '../ficha/DatosCandidato'
import VisorPdfCV from '../ficha/VisorPdfCV'

function FichaContainer(props) {
    return (
        <div className={props.clase}>
            <MenuSuperiorFichaC clase='nav-sup'></MenuSuperiorFichaC>
            <DatosCandidato clase='datos-candidato'></DatosCandidato>
            <VisorPdfCV clase='visor-pdf'></VisorPdfCV>
        </div>
    )
}

FichaContainer.propTypes = {
    clase: PropTypes.string,
}

export default FichaContainer

