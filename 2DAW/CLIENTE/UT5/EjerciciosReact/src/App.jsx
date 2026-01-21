import './App.css'
import Saludo from "./components/Saludo.jsx";
import Contador from "./components/Contador.jsx";
import ListaAlumnos from "./components/ListaAlumnos.jsx";
import FormularioSimple from "./components/FormularioSimple.jsx";

function App() {

  return (
    <>
        <Saludo nombre = "Anderson"/>
        <Saludo nombre = "Pepito"/>
        <Contador />
        <ListaAlumnos />
        <FormularioSimple/>
    </>
  )
}

export default App
