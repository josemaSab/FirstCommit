import React from 'react'
import '../styles/fichaStyle.scss'
import MenuSuperiorFichaC from '../components/ficha/MenuSuperiorFichaC'
import FichaContainer from '../components/container/FichaContainer'

function FichaCandidato(props) {
    return (
        <div className='contenedor-principal'>
            <MenuSuperiorFichaC clase='nav-sup'></MenuSuperiorFichaC>
            <FichaContainer clase='contenedor-ficha'></FichaContainer>
        </div>
    )
}

export default FichaCandidato

