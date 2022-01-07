import React from 'react'
import PropTypes from 'prop-types'
import CajaCheckComponent from './CajaCheckComponent'

function FiltrosComponent(props) {
    return (
        <div className={props.clase}>
            <div className='titulo-filtro'>
                <h3>Filtros de búsqueda</h3> <button></button>
            </div>
            <div className='fila-filtros'>
                <label> Etiquetas</label>
                <input type='text' placeholder='Escribe para buscar' />
                <datalist>
                    <option>HTML+CSS</option>
                </datalist>
                <div className='etiquetas-filtros'>
                    <ul>
                        <li>HTML+CSS</li>
                        <li>REACT</li>
                        <li>JAVA</li>
                    </ul>
                </div>
            </div>
            <div className='fila-filtros'>
                <label> Pais</label>
                <input type='text' placeholder='Escribe para buscar' />
                <datalist>
                    <option>España</option>
                </datalist>
            </div>
            <div className='fila-filtros'>
                <label> Ciudad</label>
                <input type='text' placeholder='Escribe para buscar' />
                <datalist>
                    <option>Cádiz</option>
                </datalist>
            </div>
            <div className='fila-filtros'>
                <label> Presencial / a distancia</label>
                <CajaCheckComponent clase='check-filtro' name='presencial' descripcion='Presencial'></CajaCheckComponent>
                <CajaCheckComponent clase='check-filtro' name='remoto' descripcion='En remoto'></CajaCheckComponent>
            </div>
            <div className='fila-filtros'>
                <label> Posibilidad traslado</label>
                <CajaCheckComponent clase='check-filtro' name='si' descripcion='Sí'></CajaCheckComponent>
                <CajaCheckComponent clase='check-filtro' name='no' descripcion='No'></CajaCheckComponent>
            </div>
        </div>
    )
}

FiltrosComponent.propTypes = {
    clase: PropTypes.string,

}

export default FiltrosComponent

