import React from 'react'
import ImagenContainer from './ImagenContainer'
import TituloFormContainer from './TituloFormContainer'

function PrincipalContainer() {
    return (
        <div className='contenedor-principal-login'>
            <TituloFormContainer></TituloFormContainer>
            <ImagenContainer></ImagenContainer>
        </div>
    )
}

export default PrincipalContainer

