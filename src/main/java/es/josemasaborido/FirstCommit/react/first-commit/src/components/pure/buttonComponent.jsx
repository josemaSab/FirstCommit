import React from 'react'
import PropTypes from 'prop-types'

function ButtonComponent(props) {
    return (
        <div>
            <button onclick={props.onClick}>{props.name}</button>
        </div>
    )
}

ButtonComponent.propTypes = {
    name: PropTypes.string,
    onClick: PropTypes.string,
}

export default ButtonComponent

