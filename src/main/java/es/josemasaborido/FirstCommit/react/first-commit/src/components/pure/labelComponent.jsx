import React from 'react'
import PropTypes from 'prop-types'

function LabelComponent(props) {
    return (
        <div>
            <label>{props.name}</label>
        </div>
    )
}

LabelComponent.propTypes = {
    name: PropTypes.string,
}

export default LabelComponent

