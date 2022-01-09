import React from 'react';
import ReactDOM from 'react-dom';
import './styles/loginStyle.scss'
import './styles/listadoStyle.scss'
import './styles/fichaStyle.scss'
import App from './App'
// ? Importamos bootstrap a nuestro proyecto
import '../node_modules/bootstrap/dist/css/bootstrap.css'
// ! Debe ir antes que la hoja de estilo que viene por defecto para que no se pise

import './index.css';
import reportWebVitals from './reportWebVitals';


ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
