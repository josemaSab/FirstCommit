import React from 'react'
import PropTypes from 'prop-types'

function BotonSubmitFormComponent(props) {
    return (
        <div className={props.clase}>
            <input type="submit" className={props.clase} value={props.descripcion}/>
        </div>
    )
}

BotonSubmitFormComponent.propTypes = {
    clase: PropTypes.string,
    descripcion: PropTypes.string
}

export default BotonSubmitFormComponent

