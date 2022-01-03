import logo from './logo.svg';
import './App.css';
import LabelComponent from './components/pure/labelComponent';
import TextBoxCompoment from './components/pure/textBoxCompoment';
import ButtonComponent from './components/pure/buttonComponent';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <LabelComponent name="Usuario"></LabelComponent>
        <TextBoxCompoment placeHolder='Escribe el nombre del usuario'></TextBoxCompoment>
        <ButtonComponent name="Pulsa para continuar" onClick='void(0);'></ButtonComponent>
      </header>
    </div>
  );
}

export default App;
