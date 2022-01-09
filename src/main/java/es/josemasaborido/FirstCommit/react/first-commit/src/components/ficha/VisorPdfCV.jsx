import React from 'react'
import PropTypes from 'prop-types'

function VisorPdfCV(props) {
    return (
        <div className={props.clase}>
            <embed class="visorCV" src="/pdf/Josema.pdf#toolbar=1&navpanes=1&scrollbar=1" type="application/pdf" />
        </div>
    )
}

VisorPdfCV.propTypes = {
    clase: PropTypes.string,

}

export default VisorPdfCV

