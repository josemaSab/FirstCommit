import React from 'react'
import PropTypes from 'prop-types'
import EtiquetaComponent from '../pure/EtiquetaComponent'
import CajaTextoComponent from '../pure/CajaTextoComponent'

function DatosCandidato(props) {
    return (
        <div className={props.clase}>
            <div className='titulo-datos'>
                <div className='foto-titulo'>
                    <img src='/images/Josema.png' />

                </div>
                <div className='ciudad-pais'>
                    <EtiquetaComponent clase='nombre-foto-titulo' descripcion='Josema Saborido'></EtiquetaComponent>
                    <div className='labels-ciudad-pais'>
                        <span></span>
                        <EtiquetaComponent clase='label-ciudad' descripcion='Cádiz'></EtiquetaComponent>
                        <EtiquetaComponent clase='label-ciudad' descripcion='| España'></EtiquetaComponent>
                    </div>
                </div>
            </div>
            <div className='fila-datos'>
                <EtiquetaComponent clase='label-datos' descripcion='Nombre y Apellidos'></EtiquetaComponent>
                <CajaTextoComponent clase='text-datos' tipo='text' descripcion='Josema Saborido' name='nombre'></CajaTextoComponent>
            </div>
            <div className='fila-datos-mitad'>
                <div className='mitad'>
                    <EtiquetaComponent clase='label-datos' descripcion='Teléfono'></EtiquetaComponent>
                    <CajaTextoComponent clase='text-datos' tipo='text' descripcion='666888777' name='telefono'></CajaTextoComponent>
                </div>
                <div className='mitad'>
                    <EtiquetaComponent clase='label-datos' descripcion='Email'></EtiquetaComponent>
                    <CajaTextoComponent clase='text-datos' tipo='text' descripcion='josema@gmail.com' name='email'></CajaTextoComponent>
                </div>
            </div>
            <div className='fila-datos-mitad'>
                <div className='fila-datos'>
                    <EtiquetaComponent clase='label-datos' descripcion='Ciudad'></EtiquetaComponent>
                    <input type='text' list='ciudades' placeholder='Cádiz' />
                    <datalist id='ciudades'>
                        <option>Cádiz</option>
                        <option>Madrid</option>
                        <option>Barcelona</option>
                    </datalist>
                </div>
                <div className='fila-datos'>
                    <EtiquetaComponent clase='label-datos' descripcion='Email'></EtiquetaComponent>
                    <input type='text' list='paises' placeholder='España' />
                    <datalist id='paises'>
                        <option>España</option>
                        <option>Francia</option>
                        <option>Alemania</option>
                    </datalist>
                </div>
            </div>
            <div className='fila-datos-mitad'>
                <div className='fila-datos'>
                    <EtiquetaComponent clase='label-datos' descripcion='Traslado'></EtiquetaComponent>
                    <input type='text' list='traslado' placeholder='No' />
                    <datalist id='traslado'>
                        <option>Sí</option>
                        <option>No</option>
                    </datalist>
                </div>
                <div className='fila-datos'>
                    <EtiquetaComponent clase='label-datos' descripcion='Presencialidad'></EtiquetaComponent>
                    <input type='text' list='presencialidad' placeholder='Presencial' />
                    <datalist id='presencialidad'>
                        <option>Remoto</option>
                        <option>Híbrido</option>
                        <option>Presencial</option>
                    </datalist>
                </div>
            </div>
            <div className='fila-datos'>
                <EtiquetaComponent clase='label-datos' descripcion='Documentos CV'></EtiquetaComponent>
                <div className='botones-cv'>
                    <span className='carga'></span><button className='carga-cv'>Subir de nuevo</button>
                    <span className='borrar'></span><button className='borrar-cv'>Borrar</button>
                </div>
            </div>
            <div className='fila-datos'>
                <EtiquetaComponent clase='label-datos' descripcion='Etiquetas'></EtiquetaComponent>
                <input type='text' list='etiquetas' placeholder='Escribe para buscar' />
                <datalist id='etiquetas'>
                    <option>HTMLS+CSS</option>
                    <option>JAVA</option>
                    <option>REACT</option>
                </datalist>
            </div>
            <div className='etiquetas'>
                <EtiquetaComponent clase='tag-etiquetas' descripcion='HTMLS+CSS'></EtiquetaComponent><button className='eliminar'></button>
                <EtiquetaComponent clase='tag-etiquetas' descripcion='JAVA'></EtiquetaComponent><button className='eliminar'></button>
                <EtiquetaComponent clase='tag-etiquetas' descripcion='REACT'></EtiquetaComponent><button className='eliminar'></button>
            </div>

        </div>
    )
}

DatosCandidato.propTypes = {
    clase: PropTypes.string,
}

export default DatosCandidato

