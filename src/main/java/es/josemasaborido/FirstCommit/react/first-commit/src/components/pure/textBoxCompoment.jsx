import React from 'react'
import PropTypes from 'prop-types'

function TextBoxCompoment(props) {
    return (
        <div>
            <input type="text" placeholder={props.placeHolder}></input>
        </div>
    )
}

TextBoxCompoment.propTypes = {
    placeHolder: PropTypes.string,
}

export default TextBoxCompoment

