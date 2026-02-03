import React from 'react';

const PlayerTable = ({jugadores, handleEditarJugador, handleEliminarJugador}) => {

    return (
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Dorsal</th>
                    <th>Posición</th>
                    <th>Altura</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            {jugadores.map(jugador => (
                <tr key={jugador.id}>
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