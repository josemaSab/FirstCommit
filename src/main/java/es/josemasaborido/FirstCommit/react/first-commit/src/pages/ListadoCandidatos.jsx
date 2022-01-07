import React from 'react'
import '../styles/listadoStyle.scss'
import MenuSuperior from '../components/listado/MenuSuperior'
import ListadoContainer from '../components/container/ListadoContainer'
import FiltroCointainer from '../components/container/FiltroCointainer'

function ListadoCandidatos(props) {
    return (
        <div className='contenedor-principal'>
            <MenuSuperior clase='nav-superior'></MenuSuperior>
            <div className='inferior-principal'>
                <ListadoContainer clase='listado-alumnos'></ListadoContainer>
                <FiltroCointainer clase='filtros'></FiltroCointainer>
            </div>
        </div>
    )
}


export default ListadoCandidatos

