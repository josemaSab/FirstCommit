import React from 'react'
import PropTypes from 'prop-types'

function TablaComponent(props) {
    return (
        <div className = {props.clase}>
            <table className={props.clase}>
                <thead>
                    <tr>
                        <th>NOMBRE<button onClick='#'></button></th>
                        <th>CIUDAD<button onClick='#'></button></th>
                        <th>PAIS<button onClick='#'></button></th>
                        <th>TELEFONO<button onClick='#'></button></th>
                        <th>CORREO ELECTRONICO<button onClick='#'></button></th>
                        <th>ETIQUETAS<button onClick='#'></button></th>
                    </tr>

                </thead>
                <tbody>
                    <tr>
                        <td>Josema Saborido</td>
                        <td>Cádiz</td>
                        <td>España</td>
                        <td>666888999</td>
                        <td>josema@gmail.com</td>
                        <td className='tags'>
                            <ul>
                                <li>HTML+css</li>
                                <li>JAVA</li>
                                <li>REACT</li>
                            </ul>
                        </td>
                    </tr>
                    <tr>
                        <td>Ana Suarez</td>
                        <td>Zaragoza</td>
                        <td>España</td>
                        <td>777555855</td>
                        <td>ana@gmail.com</td>
                        <td className='tags'>
                            <ul>
                                <li>HTML+css</li>
                                <li>REACT</li>
                            </ul>
                        </td>
                    </tr>
                    <tr>
                        <td>Pepe Dominguez</td>
                        <td>Madrid</td>
                        <td>España</td>
                        <td>888555888</td>
                        <td>pepe@gmail.com</td>
                        <td className='tags'>
                            <ul>
                                <li>HTML+css</li>
                                <li>JAVA</li>
                                <li>REACT</li>
                            </ul>
                        </td>
                    </tr>
                </tbody>
            </table>
            
        </div>
    )
}

TablaComponent.propTypes = {
    clase: PropTypes.string,

}

export default TablaComponent

