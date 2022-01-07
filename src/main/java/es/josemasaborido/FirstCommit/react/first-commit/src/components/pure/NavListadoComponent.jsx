import React from 'react'
import PropTypes from 'prop-types'

function NavListadoComponent(props) {
    return (
        <div className={props.clase}>
            <div className='izquierda-nav'>
                <label>Alumnos</label><input type='text' placeholder='Busca por nombre, Email o Palabra Clave' /> <button></button>
            </div>
            <div className='derecha-nav'>
                <a href='#'>Añadir alumnos</a><span></span>
            </div>
        </div>
    )
}

NavListadoComponent.propTypes = {
    clase: PropTypes.string,
    descripcion: PropTypes.string

}

export default NavListadoComponent

