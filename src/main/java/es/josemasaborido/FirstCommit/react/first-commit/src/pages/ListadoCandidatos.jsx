import React from 'react'
import '../styles/listadoStyle.scss'
import MenuSuperior from '../components/listado/MenuSuperior'
import ListadoContainer from '../components/container/ListadoContainer'

function ListadoCandidatos(props) {
    return (
        <div className='contenedor-principal'>
            <MenuSuperior clase='nav-superior'></MenuSuperior>
            <ListadoContainer></ListadoContainer>
        </div>
    )
}


export default ListadoCandidatos

