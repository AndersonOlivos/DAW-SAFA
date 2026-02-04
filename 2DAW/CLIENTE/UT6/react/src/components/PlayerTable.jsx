import React from 'react';
import {useState} from "react";
import "../styles/table.css";


const PlayerTable = ({jugadores,ordenarJugadores, handleEditarJugador, handleEliminarJugador}) => {

    const flechaArriba = "↑";
    const flechaAbajo = "↓";

    const [flecha, setFlecha] = useState(flechaAbajo);

    const ordenarDorsal = () => {
        if (flecha === flechaAbajo) {
            setFlecha(flechaArriba);
            ordenarJugadores(false);

        } else {
            setFlecha(flechaAbajo);
            ordenarJugadores(true);
        }
    }

    return (
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Dorsal
                        <button
                            className="boton-ordenar-dorsal"
                            onClick={ordenarDorsal}
                            title={flecha === flechaAbajo ? "Orden descendente" : "Orden ascendente"}
                        >{flecha}</button>
                    </th>
                    <th>Posición</th>
                    <th>Altura (cm)</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            {jugadores.map(jugador => (
                <tr key={jugador.id} className={jugador.posicion.toLowerCase()}>
                    <td>{jugador.nombre}</td>
                    <td>{jugador.dorsal}</td>
                    <td>{jugador.posicion}</td>
                    <td>{jugador.altura}</td>
                    <td>
                        <button onClick={() => handleEditarJugador(jugador.id)}>Editar</button>
                        <button onClick={() => handleEliminarJugador(jugador.id)}>Eliminar</button>
                    </td>
                </tr>
            ))}
            </tbody>
        </table>
    );
};

export default PlayerTable;