import React from 'react'
import PropTypes from 'prop-types'
import FiltrosComponent from '../pure/FiltrosComponent'

function FiltroCointainer(props) {
    return (
        <div className={props.clase}>
            <FiltrosComponent clase='filtros-listado'></FiltrosComponent>
            
        </div>
    )
}

FiltroCointainer.propTypes = {
    clase: PropTypes.string
}

export default FiltroCointainer

