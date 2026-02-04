import React from 'react';
import { Link } from 'react-router-dom';
import {useState} from "react";
import "../App.css"

const Ejercicio3 = () => {

    const [valorInput, setValorInput] = useState("");
    const [mostrarPassword, setMostrarPassword] = useState(true);

    const handleChange = (e) => {
        setValorInput(e.target.value);
    };

    return (
        <>
            <Link to="/">Ir al Gestor De Jugadores De Voleibol</Link>
            <h1>Ejercicio 3</h1>
            <div className="ejercicio">
                <input type={mostrarPassword?"text":"password"}
                       value={valorInput}
                       name="password"
                       onChange={handleChange}></input>
                <button onClick={() => {setMostrarPassword(!mostrarPassword)}}>Evento click</button>
                <p>Estás escribiendo: <strong>{valorInput}</strong></p>
            </div>
        </>
    );
};

export default Ejercicio3;