import React from 'react'
import PropTypes from 'prop-types'
import EtiquetaComponent from '../EtiquetaComponent'
import CajaTextoComponent from '../CajaTextoComponent'
import CajaCheckComponent from '../CajaCheckComponent'
import EnlaceComponent from '../EnlaceComponent'
import BotonSubmitFormComponent from '../BotonSubmitFormComponent'

function FormularioLogin(props) {
    return (
        <div className={props.clase}>
            <form action={props.accion} className={props.clase}>
                <EtiquetaComponent clase='lbl-form' descripcion='Email'></EtiquetaComponent>
                <CajaTextoComponent tipo='text' clase='txt-form' descripcion='Introduce tu email' name='email'></CajaTextoComponent>
                <EtiquetaComponent clase='lbl-form' descripcion='Constraseña'></EtiquetaComponent>
                <CajaTextoComponent tipo='password' clase='txt-form' descripcion='Introduce tu contraseña' name='password'></CajaTextoComponent>
                <div className='check-lnk'>
                    <CajaCheckComponent clase='check-form' name='check-recuerdame' descripcion='Recuérdame'></CajaCheckComponent>
                    <EnlaceComponent enlace='#' clase='lnk-form' descripcion='He olvidado mi contraseña'></EnlaceComponent>
                </div>
                <BotonSubmitFormComponent clase='btn-form' descripcion='Iniciar Sesión'></BotonSubmitFormComponent>
            </form>
        </div>
    )
}

FormularioLogin.propTypes = {
    accion: PropTypes.string,
    clase: PropTypes.string
}

export default FormularioLogin

