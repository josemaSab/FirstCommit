import React from 'react'
import PropTypes from 'prop-types'
import NavListadoComponent from '../pure/NavListadoComponent'
import TablaComponent from '../pure/TablaComponent'

function ListadoContainer(props) {
    return (
        <div className={props.clase}>
            <NavListadoComponent clase='nav-listado'></NavListadoComponent>
            <TablaComponent clase='tabla'></TablaComponent> 
        </div>
    )
}

ListadoContainer.propTypes = {
    clase: PropTypes.string,
}

export default ListadoContainer

