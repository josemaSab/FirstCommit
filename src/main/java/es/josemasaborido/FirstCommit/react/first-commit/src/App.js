import './App.css';
import FichaCandidato from './pages/FichaCandidato';
import LoginPage from './pages/home/LoginPage';
import ListadoCandidatos from './pages/ListadoCandidatos';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LoginPage/>}></Route>
        <Route path="/ficha" element={<FichaCandidato/>}></Route>
        <Route path="/datos" element={<ListadoCandidatos/>}></Route>
      </Routes>
    </Router>
  );
}

export default App;
