import React from 'react'
import CreditosComponent from '../pure/CreditosComponent';
import FormularioLogin from '../pure/forms/FormularioLogin'
import TituloComponent from '../pure/TituloComponent'

function TituloFormContainer() {
  
    return (
        <div className='titulo-form-container'>
            <TituloComponent clase='titulo' tituloH1='OpenBootcamp' tituloH2='| Alumnos'></TituloComponent>
            <FormularioLogin accion='#' clase='form-login'></FormularioLogin>
            <CreditosComponent clase='creditos'></CreditosComponent>
        </div>
    )
}


export default TituloFormContainer

