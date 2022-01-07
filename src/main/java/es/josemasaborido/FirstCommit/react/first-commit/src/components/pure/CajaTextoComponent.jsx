import React, {useState} from 'react'
import PropTypes from 'prop-types'

function CajaTextoComponent(props) {

    //Estado inicial del tipo del input va a ser text
    const [estadoInicial, setEstadoInicial] = useState('text');
    
    //Función que cambia el tipo del input con el valor pasado por props
    function actualizaTipo(){
        setEstadoInicial(props.tipo);
    }
    return (
        <div className={props.clase}>
            <input type={estadoInicial} onClick={actualizaTipo} className={props.clase} placeholder={props.descripcion} name={props.name}></input>
        </div>
    )
}

CajaTextoComponent.propTypes = {
    tipo: PropTypes.string,
    clase: PropTypes.string,
    descripcion: PropTypes.string,
    name: PropTypes.string
}

export default CajaTextoComponent

