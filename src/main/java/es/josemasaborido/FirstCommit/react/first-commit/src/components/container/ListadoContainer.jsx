import React from 'react'
import PropTypes from 'prop-types'
import NavListadoComponent from '../pure/NavListadoComponent'
import TablaComponent from '../pure/TablaComponent'

function ListadoContainer(props) {
    return (
        <div>
            <NavListadoComponent></NavListadoComponent>
            <TablaComponent></TablaComponent>
            
        </div>
    )
}

ListadoContainer.propTypes = {

}

export default ListadoContainer

