import React from 'react'
import '../styles/fichaStyle.scss'
import FichaContainer from '../components/container/FichaContainer'

function FichaCandidato(props) {
    return (
        <div className='contenedor-principal'>
            <FichaContainer clase='contenedor-ficha'></FichaContainer>
        </div>
    )
}

export default FichaCandidato

