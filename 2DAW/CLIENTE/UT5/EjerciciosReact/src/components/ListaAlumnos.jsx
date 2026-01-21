import React, {useState} from 'react';

const ListaAlumnos = () => {

    const [listaAlumnos, setListaAlumnos] = useState(["Anderson", "Pepito", "Ivan"]);

    const [valorInput, setValorInput] = useState("");

    const anadirAlumno = () => {
      setListaAlumnos([...listaAlumnos, valorInput]);
      setValorInput('');
    }

    const eliminarAlumno = (indexAlumno) => {
        let newListaAlumno = listaAlumnos.filter((alumno,index) => index !== indexAlumno);
        setListaAlumnos(newListaAlumno);
    }

    return (
        <div>
            <h1>Lista de Alumnos</h1>
            <input placeholder={"Introduce un alumno nuevo"}
            onChange={(event) => setValorInput(event.target.value)}
            value={valorInput}
            ></input>
            <button onClick={anadirAlumno}>Añadir</button>
            <ul>
            {listaAlumnos.map((alumno, index) => (
                <li key={index}>{alumno}
                <button onClick={() => eliminarAlumno(index)}>Eliminar</button></li>
            ))}
            </ul>
        </div>
    );
};

export default ListaAlumnos;